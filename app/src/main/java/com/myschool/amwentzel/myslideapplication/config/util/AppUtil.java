package com.myschool.amwentzel.myslideapplication.config.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Admin on 2016/08/25.
 */
public class AppUtil {

    private static final String URI = "http://192.168.1.95:8082/";

    public static String getStringLocation(Map<String, String> location) {
        Gson gson = new Gson();
        return gson.toJson(location);
    }

    public static Map<String, String> getLocation(String value) {
        final Gson gson = new Gson();
        Type typeOfHashMap = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(value, typeOfHashMap);
    }

    public static Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date value = null;
        try {
            value = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Map<String, Integer> getValue(String value) {
        final Gson gson = new Gson();
        Type typeOfHashMap = new TypeToken<Map<String, Integer>>() {
        }.getType();
        return gson.fromJson(value, typeOfHashMap);
    }

    public static String getStringValue(Map<String, Integer> value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }

    public static String getBaserURI() {
        return URI;
    }

    public static OkHttpClient getConnection() {
        return new OkHttpClient();
    }

    public static MediaType getJSONMediaType() {
        return MediaType.parse("application/json; charset=utf-8");
    }

    public static byte[] getImage(String imageUrl) {
        byte[] data = null;
        Request request = new Request.Builder().url(imageUrl)
                .build();
        try {
            Response response = getConnection().newCall(request).execute();
            InputStream input = response.body().byteStream();
            byte[] buffer = new byte[8192];
            int bytesRead;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            output.flush();
            output.close();
            input.close();
            data = output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }
}

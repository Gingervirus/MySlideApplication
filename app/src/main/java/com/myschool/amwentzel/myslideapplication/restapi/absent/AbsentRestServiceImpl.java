package com.myschool.amwentzel.myslideapplication.restapi.absent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Absent;
import com.myschool.amwentzel.myslideapplication.domain.Users;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/01.
 */
public class AbsentRestServiceImpl implements AbsentRestService {
    private Absent absent;
    private static final String url = AppUtil.getBaserURI() + "absent/";

    public AbsentRestServiceImpl(Absent absent) {
        this.absent = absent;
    }

    @Override
    public Absent getAbsentDetails() throws Exception{
        Request request = new Request.Builder()
                .url(url + absent.getAbsent_ID())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        absent = new Gson().fromJson(value, Absent.class);

        return absent;
    }

    @Override
    public Absent updateAbsent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(absent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + absent.getAbsent_ID())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Absent usersResource = new Gson().fromJson(value, Absent.class);
        return usersResource;
    }

    @Override
    public Absent deleteAbsent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(absent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + absent.getAbsent_ID())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Absent usersResource = new Gson().fromJson(value, Absent.class);
        return usersResource;
    }

    @Override
    public Users createAbsent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(absent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Users usersResource = new Gson().fromJson(value, Users.class);
        return usersResource;
    }

    @Override
    public Set<Absent> viewAllAbsent() throws Exception{
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();
        Set<Absent> usersResource = new Gson().fromJson(value, new TypeToken<Set<Absent>>(){}.getType());
        return usersResource;
    }
}

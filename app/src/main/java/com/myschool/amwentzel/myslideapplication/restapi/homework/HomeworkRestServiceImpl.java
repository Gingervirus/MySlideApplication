package com.myschool.amwentzel.myslideapplication.restapi.homework;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Homework;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class HomeworkRestServiceImpl implements HomeworkRestService{
    private Homework homework;
    private static final String url = AppUtil.getBaserURI() + "homework/";

    public HomeworkRestServiceImpl(Homework homework) {
        this.homework = homework;
    }

    @Override
    public Homework getHomeworkDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + homework.getHomework_ID())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        homework = new Gson().fromJson(value, Homework.class);

        return homework;
    }

    @Override
    public Homework updateHomework() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(homework);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + homework.getHomework_ID())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Homework usersResource = new Gson().fromJson(value, Homework.class);
        return usersResource;
    }

    @Override
    public Homework deleteHomework() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(homework);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + homework.getHomework_ID())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Homework usersResource = new Gson().fromJson(value, Homework.class);
        return usersResource;
    }

    @Override
    public Homework createHomework() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(homework);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Homework usersResource = new Gson().fromJson(value, Homework.class);
        return usersResource;
    }

    @Override
    public Set<Homework> viewAllHomework() throws Exception{
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        Set<Homework> usersResource = new Gson().fromJson(value, new TypeToken<Set<Homework>>(){}.getType());
        return usersResource;
    }
}

package com.myschool.amwentzel.myslideapplication.restapi.teacher;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Teacher;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class TeacherRestServiceImpl implements TeacherRestService{
    private Teacher teacher;
    private static final String url = AppUtil.getBaserURI() + "teacher/";

    public TeacherRestServiceImpl(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Teacher getTeacherDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + teacher.getTeacher_id())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        teacher = new Gson().fromJson(value, Teacher.class);

        return teacher;
    }

    @Override
    public Teacher updateTeacher() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(teacher);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + teacher.getTeacher_id())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Teacher usersResource = new Gson().fromJson(value, Teacher.class);
        return usersResource;
    }

    @Override
    public Teacher deleteTeacher() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(teacher);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + teacher.getTeacher_id())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Teacher usersResource = new Gson().fromJson(value, Teacher.class);
        return usersResource;
    }

    @Override
    public Teacher createTeacher() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(teacher);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Teacher usersResource = new Gson().fromJson(value, Teacher.class);
        return usersResource;
    }

    @Override
    public Set<Teacher> viewAllTeacher() throws Exception{
        Request request = new Request.Builder()
                .url(url + teacher.getTeacher_id())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();
        Set<Teacher> usersResource = new Gson().fromJson(value, new TypeToken<Set<Teacher>>(){}.getType());
        return usersResource;
    }
}

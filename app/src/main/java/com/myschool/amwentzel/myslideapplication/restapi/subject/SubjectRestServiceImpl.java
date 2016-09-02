package com.myschool.amwentzel.myslideapplication.restapi.subject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Subject;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class SubjectRestServiceImpl implements SubjectRestService{
    private Subject subject;
    private static final String url = AppUtil.getBaserURI() + "subject/";

    public SubjectRestServiceImpl(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Subject getSubjectDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + subject.getSubject_code())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        subject = new Gson().fromJson(value, Subject.class);

        return subject;
    }

    @Override
    public Subject updateSubject()  throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(subject);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + subject.getSubject_code())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Subject usersResource = new Gson().fromJson(value, Subject.class);
        return usersResource;
    }

    @Override
    public Subject deleteSubject() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(subject);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + subject.getSubject_code())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Subject usersResource = new Gson().fromJson(value, Subject.class);
        return usersResource;
    }

    @Override
    public Subject createSubject() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(subject);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Subject usersResource = new Gson().fromJson(value, Subject.class);
        return usersResource;
    }

    @Override
    public Set<Subject> viewAllSubject() throws Exception{
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();
        Set<Subject> usersResource = new Gson().fromJson(value, new TypeToken<Set<Subject>>(){}.getType());
        return usersResource;
    }
}

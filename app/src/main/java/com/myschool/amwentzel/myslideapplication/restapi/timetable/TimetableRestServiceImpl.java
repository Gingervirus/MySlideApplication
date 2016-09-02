package com.myschool.amwentzel.myslideapplication.restapi.timetable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Timetable;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class TimetableRestServiceImpl implements TimetableRestService{
    private Timetable timetable;
    private static final String url = AppUtil.getBaserURI() + "timetable/";

    @Override
    public Timetable getTimetableDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + timetable.getTimetable_id())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        timetable = new Gson().fromJson(value, Timetable.class);

        return timetable;
    }

    @Override
    public Timetable updateTimetable() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(timetable);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + timetable.getTimetable_id())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Timetable usersResource = new Gson().fromJson(value, Timetable.class);
        return usersResource;
    }

    @Override
    public Timetable deleteTimetable() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(timetable);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + timetable.getTimetable_id())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Timetable usersResource = new Gson().fromJson(value, Timetable.class);
        return usersResource;
    }

    @Override
    public Timetable createTimetable() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(timetable);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Timetable usersResource = new Gson().fromJson(value, Timetable.class);
        return usersResource;
    }

    @Override
    public Set<Timetable> viewAllTimetable() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(timetable);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + timetable.getTimetable_id())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Set<Timetable> usersResource = new Gson().fromJson(value, new TypeToken<Set<Timetable>>(){}.getType());
        return usersResource;
    }
}

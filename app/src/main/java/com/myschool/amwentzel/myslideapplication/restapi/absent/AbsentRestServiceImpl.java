package com.myschool.amwentzel.myslideapplication.restapi.absent;

import com.google.gson.Gson;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Absent;

import java.util.Set;

import okhttp3.Request;
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
    public void updateAbsent() {

    }

    @Override
    public void deleteAbsent() {

    }

    @Override
    public void createAbsent() {

    }

    @Override
    public Set<Absent> viewAllAbsent() {
        return null;
    }
}

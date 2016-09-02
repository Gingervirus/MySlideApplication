package com.myschool.amwentzel.myslideapplication.restapi.detention;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Detention;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class DetentionRestServiceImpl implements DetentionRestService{
    private Detention detention;
    private static final String url = AppUtil.getBaserURI() + "detention/";

    public DetentionRestServiceImpl(Detention detention) {
        this.detention = detention;
    }

    @Override
    public Detention getDetentionDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + detention.getDetention_ID())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        detention = new Gson().fromJson(value, Detention.class);

        return detention;
    }

    @Override
    public Detention updateDetention() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(detention);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + detention.getDetention_ID())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Detention usersResource = new Gson().fromJson(value, Detention.class);
        return usersResource;
    }

    @Override
    public Detention deleteDetention() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(detention);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + detention.getDetention_ID())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Detention usersResource = new Gson().fromJson(value, Detention.class);
        return usersResource;
    }

    @Override
    public Detention createDetention() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(detention);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Detention usersResource = new Gson().fromJson(value, Detention.class);
        return usersResource;
    }

    @Override
    public Set<Detention> viewAllDetention() throws Exception {
        Request request = new Request.Builder()
                .url(url + detention.getDetention_ID())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        Set<Detention> usersResource = new Gson().fromJson(value, new TypeToken<Set<Detention>>(){}.getType());

        return usersResource;
    }
}

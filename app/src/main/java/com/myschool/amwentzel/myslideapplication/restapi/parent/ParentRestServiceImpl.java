package com.myschool.amwentzel.myslideapplication.restapi.parent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Parent;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class ParentRestServiceImpl implements ParentRestService{
    private Parent parent;
    private static final String url = AppUtil.getBaserURI() + "parent/";

    public ParentRestServiceImpl(Parent parent) {
        this.parent = parent;
    }

    @Override
    public Parent getParentDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + parent.getParent_ID())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        parent = new Gson().fromJson(value, Parent.class);

        return parent;
    }

    @Override
    public Parent updateParent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(parent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + parent.getParent_ID())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Parent usersResource = new Gson().fromJson(value, Parent.class);
        return usersResource;
    }

    @Override
    public Parent deleteParent() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(parent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + parent.getParent_ID())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Parent usersResource = new Gson().fromJson(value, Parent.class);
        return usersResource;
    }

    @Override
    public Parent createParent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(parent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Parent usersResource = new Gson().fromJson(value, Parent.class);
        return usersResource;
    }

    @Override
    public Set<Parent> viewAllParent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(parent);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Set<Parent> usersResource = new Gson().fromJson(value, new TypeToken<Set<Parent>>(){}.getType());
        return usersResource;
    }
}

package com.myschool.amwentzel.myslideapplication.restapi.mark;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Mark;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class MarkRestServiceImpl implements MarkRestService {
    private Mark mark;
    private static final String url = AppUtil.getBaserURI() + "mark/";
    public MarkRestServiceImpl(Mark mark) {
        this.mark = mark;
    }

    @Override
    public Mark getMarkDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + mark.getMark_ID())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        mark = new Gson().fromJson(value, Mark.class);

        return mark;
    }

    @Override
    public Mark updateMark() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(mark);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + mark.getMark_ID())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Mark usersResource = new Gson().fromJson(value, Mark.class);
        return usersResource;
    }

    @Override
    public Mark deleteMark() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(mark);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + mark.getMark_ID())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Mark usersResource = new Gson().fromJson(value, Mark.class);
        return usersResource;
    }

    @Override
    public Mark createMark() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(mark);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Mark usersResource = new Gson().fromJson(value, Mark.class);
        return usersResource;
    }

    @Override
    public Set<Mark> viewAllMark() throws Exception{
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();
        Set<Mark> usersResource = new Gson().fromJson(value, new TypeToken<Set<Mark>>(){}.getType());
        return usersResource;
    }
}

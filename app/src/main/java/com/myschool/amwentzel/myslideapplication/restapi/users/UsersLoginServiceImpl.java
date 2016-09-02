package com.myschool.amwentzel.myslideapplication.restapi.users;

import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Timetable;
import com.myschool.amwentzel.myslideapplication.domain.Users;
import com.google.gson.Gson;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/08/31.
 */
public class UsersLoginServiceImpl implements UsersLoginService {

    private Users users;
    private static final String url = AppUtil.getBaserURI() + "login/";

    public UsersLoginServiceImpl(Users users) {
        this.users = users;
    }

    @Override
    public boolean isAccountActivated() {
        return false;
    }

    @Override
    public Users getAccountDetails() throws Exception {

        Request request = new Request.Builder()
                .url(url + users.getUser_id())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        users = new Gson().fromJson(value, Users.class);

        return users;
    }

    @Override
    public Users createAccount() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(users);
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
    public Users updateAccount() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + users.getUser_id())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Users usersResource = new Gson().fromJson(value, Users.class);
        return usersResource;
    }

    @Override
    public Users deleteAccount() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + users.getUser_id())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Users usersResource = new Gson().fromJson(value, Users.class);
        return usersResource;
    }

    @Override
    public Set<Timetable> viewAllAccounts() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Set<Timetable> usersResource = new Gson().fromJson(value, new TypeToken<Set<Timetable>>(){}.getType());
        return usersResource;
    }
}

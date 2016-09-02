package com.myschool.amwentzel.myslideapplication.restapi.users;

import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Users;
import com.google.gson.Gson;

import okhttp3.Request;
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
    public void createAccount() {

    }
}

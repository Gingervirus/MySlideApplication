package com.myschool.amwentzel.myslideapplication.restapi.users;

import com.myschool.amwentzel.myslideapplication.domain.Users;

/**
 * Created by amwentzel on 2016/08/31.
 */
public interface UsersLoginService {

    boolean isAccountActivated();

    Users getAccountDetails() throws Exception;

    void createAccount();
}

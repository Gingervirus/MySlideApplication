package com.myschool.amwentzel.myslideapplication.restapi.users;

import com.myschool.amwentzel.myslideapplication.domain.Timetable;
import com.myschool.amwentzel.myslideapplication.domain.Users;

import java.util.Set;

/**
 * Created by amwentzel on 2016/08/31.
 */
public interface UsersLoginService {

    boolean isAccountActivated();

    Users getAccountDetails() throws Exception;
    Users createAccount() throws Exception;
    Users updateAccount() throws Exception;
    Users deleteAccount() throws Exception;
    Set<Timetable> viewAllAccounts() throws Exception;
}

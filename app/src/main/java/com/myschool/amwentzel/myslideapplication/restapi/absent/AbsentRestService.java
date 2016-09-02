package com.myschool.amwentzel.myslideapplication.restapi.absent;

import com.myschool.amwentzel.myslideapplication.domain.Absent;
import com.myschool.amwentzel.myslideapplication.domain.Parent;
import com.myschool.amwentzel.myslideapplication.domain.Users;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/01.
 */
public interface AbsentRestService {
    Absent getAbsentDetails() throws Exception;

    Absent updateAbsent() throws Exception;

    Absent deleteAbsent() throws Exception;

    Users createAbsent() throws Exception;

    Set<Absent> viewAllAbsent() throws Exception;
}

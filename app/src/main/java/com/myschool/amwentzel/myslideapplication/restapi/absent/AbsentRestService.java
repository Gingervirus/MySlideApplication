package com.myschool.amwentzel.myslideapplication.restapi.absent;

import com.myschool.amwentzel.myslideapplication.domain.Absent;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/01.
 */
public interface AbsentRestService {
    Absent getAbsentDetails() throws Exception;

    void updateAbsent();

    void deleteAbsent();

    void createAbsent();

    Set<Absent> viewAllAbsent();
}

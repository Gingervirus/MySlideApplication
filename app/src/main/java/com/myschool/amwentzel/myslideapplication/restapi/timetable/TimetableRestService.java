package com.myschool.amwentzel.myslideapplication.restapi.timetable;

import com.myschool.amwentzel.myslideapplication.domain.Timetable;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface TimetableRestService {
    Timetable getAbsentDetails() throws Exception;

    void updateAbsent();

    void deleteAbsent();

    void createAbsent();

    Set<Timetable> viewAllAbsent();
}

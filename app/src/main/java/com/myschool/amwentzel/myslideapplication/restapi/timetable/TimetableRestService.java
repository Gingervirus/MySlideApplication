package com.myschool.amwentzel.myslideapplication.restapi.timetable;

import com.myschool.amwentzel.myslideapplication.domain.Timetable;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface TimetableRestService {
    Timetable getTimetableDetails() throws Exception;

    Timetable updateTimetable() throws Exception;

    Timetable deleteTimetable() throws Exception;

    Timetable createTimetable() throws Exception;

    Set<Timetable> viewAllTimetable() throws Exception;
}

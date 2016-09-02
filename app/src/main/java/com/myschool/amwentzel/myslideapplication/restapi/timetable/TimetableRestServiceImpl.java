package com.myschool.amwentzel.myslideapplication.restapi.timetable;

import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Timetable;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class TimetableRestServiceImpl implements TimetableRestService{
    private Timetable timetable;
    private static final String url = AppUtil.getBaserURI() + "timetable/";

    @Override
    public Timetable getAbsentDetails() throws Exception {
        return null;
    }

    @Override
    public void updateAbsent() {

    }

    @Override
    public void deleteAbsent() {

    }

    @Override
    public void createAbsent() {

    }

    @Override
    public Set<Timetable> viewAllAbsent() {
        return null;
    }
}

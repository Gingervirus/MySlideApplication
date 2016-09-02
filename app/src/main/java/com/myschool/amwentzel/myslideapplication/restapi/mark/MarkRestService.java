package com.myschool.amwentzel.myslideapplication.restapi.mark;

import com.myschool.amwentzel.myslideapplication.domain.Mark;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface MarkRestService {
    Mark getMarkDetails() throws Exception;

    void updateMark();

    void deleteMark();

    void createMark();

    Set<Mark> viewAllMark();
}

package com.myschool.amwentzel.myslideapplication.restapi.mark;

import com.myschool.amwentzel.myslideapplication.domain.Mark;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface MarkRestService {
    Mark getMarkDetails() throws Exception;

    Mark updateMark() throws Exception;

    Mark deleteMark() throws Exception;

    Mark createMark() throws Exception;

    Set<Mark> viewAllMark() throws Exception;
}

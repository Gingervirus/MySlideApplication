package com.myschool.amwentzel.myslideapplication.restapi.homework;

import com.myschool.amwentzel.myslideapplication.domain.Homework;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface HomeworkRestService {
    Homework getHomeworkDetails() throws Exception;

    Homework updateHomework() throws Exception;

    Homework deleteHomework() throws Exception;

    Homework createHomework() throws Exception;

    Set<Homework> viewAllHomework() throws Exception;
}

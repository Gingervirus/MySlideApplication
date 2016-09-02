package com.myschool.amwentzel.myslideapplication.restapi.homework;

import com.myschool.amwentzel.myslideapplication.domain.Homework;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class HomeworkRestServiceImpl implements HomeworkRestService{
    private Homework homework;

    public HomeworkRestServiceImpl(Homework homework) {
        this.homework = homework;
    }

    @Override
    public Homework getHomeworkDetails() throws Exception {
        return null;
    }

    @Override
    public void updateHomework() {

    }

    @Override
    public void deleteHomework() {

    }

    @Override
    public void createHomework() {

    }

    @Override
    public Set<Homework> viewAllHomework() {
        return null;
    }
}

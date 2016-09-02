package com.myschool.amwentzel.myslideapplication.restapi.mark;

import com.myschool.amwentzel.myslideapplication.domain.Mark;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class MarkRestServiceImpl implements MarkRestService {
    private Mark mark;

    public MarkRestServiceImpl(Mark mark) {
        this.mark = mark;
    }

    @Override
    public Mark getMarkDetails() throws Exception {
        return null;
    }

    @Override
    public void updateMark() {

    }

    @Override
    public void deleteMark() {

    }

    @Override
    public void createMark() {

    }

    @Override
    public Set<Mark> viewAllMark() {
        return null;
    }
}

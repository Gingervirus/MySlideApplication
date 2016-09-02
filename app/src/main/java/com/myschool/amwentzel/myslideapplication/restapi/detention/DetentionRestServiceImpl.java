package com.myschool.amwentzel.myslideapplication.restapi.detention;

import com.myschool.amwentzel.myslideapplication.domain.Detention;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class DetentionRestServiceImpl implements DetentionRestService{
    private Detention detention;

    public DetentionRestServiceImpl(Detention detention) {
        this.detention = detention;
    }

    @Override
    public Detention getDetentionDetails() throws Exception {
        return null;
    }

    @Override
    public void updateDetention() {

    }

    @Override
    public void deleteDetention() {

    }

    @Override
    public void createDetention() {

    }

    @Override
    public Set<Detention> viewAllDetention() {
        return null;
    }
}

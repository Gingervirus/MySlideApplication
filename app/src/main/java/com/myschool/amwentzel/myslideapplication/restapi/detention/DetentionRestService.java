package com.myschool.amwentzel.myslideapplication.restapi.detention;

import com.myschool.amwentzel.myslideapplication.domain.Detention;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface DetentionRestService {
    Detention getDetentionDetails() throws Exception;

    void updateDetention();

    void deleteDetention();

    void createDetention();

    Set<Detention> viewAllDetention();
}

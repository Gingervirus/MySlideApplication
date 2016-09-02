package com.myschool.amwentzel.myslideapplication.restapi.detention;

import com.myschool.amwentzel.myslideapplication.domain.Detention;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface DetentionRestService {
    Detention getDetentionDetails() throws Exception;

    Detention updateDetention() throws Exception;

    Detention deleteDetention() throws Exception;

    Detention createDetention() throws Exception;

    Set<Detention> viewAllDetention() throws Exception;
}

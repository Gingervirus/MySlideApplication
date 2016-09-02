package com.myschool.amwentzel.myslideapplication.restapi.parent;

import com.myschool.amwentzel.myslideapplication.domain.Parent;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface ParentRestService {
    Parent getParentDetails() throws Exception;

    void updateParent();

    void deleteParent();

    void createParent();

    Set<Parent> viewAllParent();
}

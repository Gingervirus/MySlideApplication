package com.myschool.amwentzel.myslideapplication.restapi.parent;

import com.myschool.amwentzel.myslideapplication.domain.Parent;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface ParentRestService {
    Parent getParentDetails() throws Exception;

    Parent updateParent() throws Exception;

    Parent deleteParent() throws Exception;

    Parent createParent() throws Exception;

    Set<Parent> viewAllParent() throws Exception;
}

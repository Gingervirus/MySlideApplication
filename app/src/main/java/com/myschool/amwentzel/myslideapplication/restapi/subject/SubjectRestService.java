package com.myschool.amwentzel.myslideapplication.restapi.subject;

import com.myschool.amwentzel.myslideapplication.domain.Subject;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface SubjectRestService {
    Subject getSubjectDetails() throws Exception;

    void updateSubject();

    void deleteSubject();

    void createSubject();

    Set<Subject> viewAllSubject();
}

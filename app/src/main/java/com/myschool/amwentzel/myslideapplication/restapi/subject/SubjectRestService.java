package com.myschool.amwentzel.myslideapplication.restapi.subject;

import com.myschool.amwentzel.myslideapplication.domain.Subject;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface SubjectRestService {
    Subject getSubjectDetails() throws Exception;

    Subject updateSubject() throws Exception;

    Subject deleteSubject() throws Exception;

    Subject createSubject() throws Exception;

    Set<Subject> viewAllSubject() throws Exception;
}

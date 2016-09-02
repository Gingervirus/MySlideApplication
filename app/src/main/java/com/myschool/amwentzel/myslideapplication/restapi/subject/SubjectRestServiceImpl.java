package com.myschool.amwentzel.myslideapplication.restapi.subject;

import com.myschool.amwentzel.myslideapplication.domain.Subject;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class SubjectRestServiceImpl implements SubjectRestService{
    private Subject subject;

    public SubjectRestServiceImpl(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Subject getSubjectDetails() throws Exception {
        return null;
    }

    @Override
    public void updateSubject() {

    }

    @Override
    public void deleteSubject() {

    }

    @Override
    public void createSubject() {

    }

    @Override
    public Set<Subject> viewAllSubject() {
        return null;
    }
}

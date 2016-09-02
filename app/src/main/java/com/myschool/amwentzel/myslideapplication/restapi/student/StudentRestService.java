package com.myschool.amwentzel.myslideapplication.restapi.student;

import com.myschool.amwentzel.myslideapplication.domain.Student;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface StudentRestService {
    Student getStudentDetails() throws Exception;

    Student updateStudent() throws Exception;

    Student deleteStudent() throws Exception;

    Student createStudent() throws Exception;

    Set<Student> viewAllStudent() throws Exception;
}

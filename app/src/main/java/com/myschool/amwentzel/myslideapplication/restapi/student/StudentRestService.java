package com.myschool.amwentzel.myslideapplication.restapi.student;

import com.myschool.amwentzel.myslideapplication.domain.Student;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface StudentRestService {
    Student getStudentDetails() throws Exception;

    void updateStudent();

    void deleteStudent();

    void createStudent();

    Set<Student> viewAllStudent();
}

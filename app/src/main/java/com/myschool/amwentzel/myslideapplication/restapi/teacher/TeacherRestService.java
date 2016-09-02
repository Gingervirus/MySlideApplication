package com.myschool.amwentzel.myslideapplication.restapi.teacher;

import com.myschool.amwentzel.myslideapplication.domain.Teacher;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface TeacherRestService {
    Teacher getTeacherDetails() throws Exception;

    Teacher updateTeacher() throws Exception;

    Teacher deleteTeacher() throws Exception;

    Teacher createTeacher() throws Exception;

    Set<Teacher> viewAllTeacher() throws Exception;
}

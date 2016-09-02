package com.myschool.amwentzel.myslideapplication.restapi.teacher;

import com.myschool.amwentzel.myslideapplication.domain.Teacher;

import java.util.Set;

/**
 * Created by amwentzel on 2016/09/02.
 */
public interface TeacherRestService {
    Teacher getAbsentDetails() throws Exception;

    void updateAbsent();

    void deleteAbsent();

    void createAbsent();

    Set<Teacher> viewAllAbsent();
}

package com.myschool.amwentzel.myslideapplication;

import android.test.AndroidTestCase;

import com.myschool.amwentzel.myslideapplication.domain.Student;
import com.myschool.amwentzel.myslideapplication.restapi.student.StudentRestServiceImpl;

import junit.framework.Assert;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class StudentRestTest extends AndroidTestCase {
    public void testExistUser() throws Exception {

        Student users = new Student.Builder()
                .parent_ID(Long.valueOf(1))
                .build();

        StudentRestServiceImpl usersLoginService = new StudentRestServiceImpl(users);

        users = usersLoginService.getStudentDetails();

        Assert.assertEquals("urjrj", users.getSurname());
    }
}

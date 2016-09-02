package com.myschool.amwentzel.myslideapplication.restapi.student;

import com.google.gson.Gson;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Student;

import java.util.Set;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class StudentRestServiceImpl implements StudentRestService{
    private Student student;
    private static final String url = AppUtil.getBaserURI() + "student/";

    public StudentRestServiceImpl(Student student) {
        this.student = student;
    }

    @Override
    public Student getStudentDetails() throws Exception {
        Request request = new Request.Builder()
                .url(url + student.getStudent_id())
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        student = new Gson().fromJson(value, Student.class);

        return student;
    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void createStudent() {

    }

    @Override
    public Set<Student> viewAllStudent() {
        return null;
    }
}

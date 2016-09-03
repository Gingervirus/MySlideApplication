package com.myschool.amwentzel.myslideapplication.restapi.student;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myschool.amwentzel.myslideapplication.config.util.AppUtil;
import com.myschool.amwentzel.myslideapplication.domain.Student;

import java.util.Set;

import okhttp3.Request;
import okhttp3.RequestBody;
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
    public Student updateStudent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(student);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + student.getStudent_id())
                .put(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Student usersResource = new Gson().fromJson(value, Student.class);
        return usersResource;
    }

    @Override
    public Student deleteStudent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(student);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url + student.getStudent_id())
                .delete(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Student usersResource = new Gson().fromJson(value, Student.class);
        return usersResource;
    }

    @Override
    public Student createStudent() throws Exception{
        Gson gson = new Gson();
        String json = gson.toJson(student);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();
        String value = response.body().string();
        Student usersResource = new Gson().fromJson(value, Student.class);
        return usersResource;
    }

    @Override
    public Set<Student> viewAllStudent() throws Exception{
        String url1 = AppUtil.getBaserURI() + "students/";
        Request request = new Request.Builder()
                .url(url1)
                .get()
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();
        Set<Student> usersResource = new Gson().fromJson(value, new TypeToken<Set<Student>>(){}.getType());
        return usersResource;
    }
}

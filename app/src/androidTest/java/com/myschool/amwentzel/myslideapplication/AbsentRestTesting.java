package com.myschool.amwentzel.myslideapplication;

import android.test.AndroidTestCase;

import com.myschool.amwentzel.myslideapplication.domain.Absent;
import com.myschool.amwentzel.myslideapplication.restapi.absent.AbsentRestServiceImpl;

import junit.framework.Assert;

/**
 * Created by amwentzel on 2016/09/02.
 */
public class AbsentRestTesting extends AndroidTestCase {

    public void testExistUser() throws Exception {

        Absent users = new Absent.Builder()
                .absent_ID(Long.valueOf(1))
                .build();

        AbsentRestServiceImpl usersLoginService = new AbsentRestServiceImpl(users);

        users = usersLoginService.getAbsentDetails();

        Assert.assertEquals("TP300S", users.getSubject());

        /*String json = new Gson().toJson(new StudentCredentials(email, password));

        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = AppUtil.getConnection()
                .newCall(request)
                .execute();

        String value = response.body().string();

        StudentResource studentResource = new Gson().fromJson(value, StudentResource.class);

        return StudentFactory.getStudent(studentResource.getName(), studentResource
*/

    }
}

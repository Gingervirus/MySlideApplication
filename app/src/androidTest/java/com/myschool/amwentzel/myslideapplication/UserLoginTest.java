package com.myschool.amwentzel.myslideapplication;

import android.test.AndroidTestCase;

import com.myschool.amwentzel.myslideapplication.domain.Users;
import com.myschool.amwentzel.myslideapplication.restapi.users.UsersLoginServiceImpl;

import junit.framework.Assert;

/**
 * Created by amwentzel on 2016/08/31.
 */


public class UserLoginTest extends AndroidTestCase {

    public void testExistUser() throws Exception {

        Users users = new Users.Builder()
                .user_id(66)
                .build();

        UsersLoginServiceImpl usersLoginService = new UsersLoginServiceImpl(users);

            users = usersLoginService.getAccountDetails();

            Assert.assertEquals("Teacher", users.getRole());

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

package com.myschool.amwentzel.myslideapplication.activities.absent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.myschool.amwentzel.myslideapplication.R;
import com.myschool.amwentzel.myslideapplication.domain.Absent;
import com.myschool.amwentzel.myslideapplication.restapi.absent.AbsentRestServiceImpl;

/**
 * Created by amwentzel on 2016/08/20.
 */
public class AddAbsent extends Fragment {

    private Absent absent;
    EditText studentnr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_add_absent,container,false);
    }

    class Mytask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            absent = new Absent.Builder()
                    .absent_ID(absent.getAbsent_ID())
                    .build();

            try {
                AbsentRestServiceImpl usersLoginService = new AbsentRestServiceImpl(absent);
                usersLoginService.createAbsent();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

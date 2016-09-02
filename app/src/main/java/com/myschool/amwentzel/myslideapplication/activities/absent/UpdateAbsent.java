package com.myschool.amwentzel.myslideapplication.activities.absent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myschool.amwentzel.myslideapplication.R;

/**
 * Created by amwentzel on 2016/08/22.
 */
public class UpdateAbsent extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_add_absent,container,false);
    }
}

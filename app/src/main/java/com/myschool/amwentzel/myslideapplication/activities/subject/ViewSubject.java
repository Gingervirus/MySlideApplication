package com.myschool.amwentzel.myslideapplication.activities.subject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myschool.amwentzel.myslideapplication.R;

/**
 * Created by amwentzel on 2016/08/20.
 */
public class ViewSubject extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_view_subjects,container,false);
    }
}

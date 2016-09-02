package com.myschool.amwentzel.myslideapplication.activities.marks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myschool.amwentzel.myslideapplication.R;

import java.util.Date;

/**
 * Created by amwentzel on 2016/08/20.
 */
public class AddMarks extends Fragment{

    TextView txtstud_nr;
    TextView txtsubject;
    TextView txtdate;

    private String student_nr;
    private String subject;
    private Date date;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_add_marks,container,false);
    }
}

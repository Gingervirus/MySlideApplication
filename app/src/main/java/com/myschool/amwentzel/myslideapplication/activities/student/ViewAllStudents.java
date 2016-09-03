package com.myschool.amwentzel.myslideapplication.activities.student;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.myschool.amwentzel.myslideapplication.R;
import com.myschool.amwentzel.myslideapplication.domain.Student;
import com.myschool.amwentzel.myslideapplication.restapi.student.StudentRestServiceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by amwentzel on 2016/08/20.
 */
public class ViewAllStudents extends Fragment {

    private Set<Student> studentSet;
    private ArrayAdapter adapter;
    //private ArrayAdapter adapter1;
    private Student stud;
    private ListView listView;
    private String[] names;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_view_students,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Mytask2().execute();
        studentSet = new HashSet<>();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator<Student> itPerson = studentSet.iterator();

        if(studentSet.size() > 0) {

            names = new String[studentSet.size()];
            // id = new String[personSet.size()];
            int i = 0;

            while(itPerson.hasNext()) {
                // id[i]= String.valueOf(itPerson.next().getId());
                names[i] = itPerson.next().getFirst_name();
                i++;
            }

            adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names);
            //adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,id);

            listView = (ListView) view.findViewById(R.id.listViewStudent);
            listView.setAdapter(adapter);
            //listView.setAdapter(adapter1);
        }
        else{
            Toast.makeText(getActivity(), "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    class Mytask2 extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {

            try{
                StudentRestServiceImpl studentRestService = new StudentRestServiceImpl(stud);
                studentSet = studentRestService.viewAllStudent();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

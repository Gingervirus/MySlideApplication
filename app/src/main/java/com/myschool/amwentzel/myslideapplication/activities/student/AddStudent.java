package com.myschool.amwentzel.myslideapplication.activities.student;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.myschool.amwentzel.myslideapplication.R;
import com.myschool.amwentzel.myslideapplication.domain.Student;
import com.myschool.amwentzel.myslideapplication.restapi.student.StudentRestServiceImpl;

/**
 * Created by amwentzel on 2016/08/19.
 */
public class AddStudent extends Fragment{
    TextView txtfirstname;
    TextView txtsurname;
    TextView txtcell_nr;
    TextView txtclass_nr;
    TextView txtemail;
    Button addStud;

    private String firstname;
    private String surname;
    private String cell_nr;
    private String class_nr;
    private String email;

    private Student stud;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_add_student,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        txtfirstname  = (EditText) view.findViewById(R.id.name);
        txtsurname  = (EditText) view.findViewById(R.id.surname);
        txtcell_nr  = (EditText) view.findViewById(R.id.cellNr);
        txtclass_nr  = (EditText) view.findViewById(R.id.classNr);
        txtemail  = (EditText) view.findViewById(R.id.email);
        addStud = (Button) view.findViewById(R.id.btnAddStudent);

        addStud.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new Mytask().execute();

            }
        });
    }

    class Mytask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            stud = new Student.Builder()
                    .first_name(firstname)
                    .surname(surname)
                    .cellphone_nr(cell_nr)
                    .class_nr(class_nr)
                    .e_mail(email)
                    .build();

            try {
                StudentRestServiceImpl usersLoginService = new StudentRestServiceImpl(stud);
                usersLoginService.createStudent();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

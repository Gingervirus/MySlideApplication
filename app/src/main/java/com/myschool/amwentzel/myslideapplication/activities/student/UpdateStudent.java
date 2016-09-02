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
 * Created by amwentzel on 2016/08/20.
 */
public class UpdateStudent extends Fragment {
    EditText txtstudent_nr;
    EditText txtfirstname;
    EditText txtsurname;
    EditText txtcell_nr;
    EditText txtclass_nr;
    EditText txtemail;
    EditText txtpassword;
    Button update;
    Button search;

    private boolean populate = false;
    private String student_nr;
    private String firstname;
    private String surname;
    private String cell_nr;
    private String class_nr;
    private String email;
    private String password;

    private Student stud;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_update_student,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        txtstudent_nr  = (EditText) view.findViewById(R.id.student_nr);
        txtfirstname  = (EditText) view.findViewById(R.id.StudUpdateName);
        txtsurname  = (EditText) view.findViewById(R.id.surname);
        txtcell_nr  = (EditText) view.findViewById(R.id.cellNr);
        txtclass_nr  = (EditText) view.findViewById(R.id.classNr);
        txtemail  = (EditText) view.findViewById(R.id.email);
        txtpassword = (EditText) view.findViewById(R.id.password);
        update = (Button) view.findViewById(R.id.btnUpdate);
        search = (Button) view.findViewById(R.id.btnSearchStudent);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            student_nr = txtstudent_nr.getText().toString();
                stud = new Student.Builder()
                        .parent_ID(Long.valueOf(student_nr))
                        .build();
                new Mytask2().execute();

            }
        });



        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                firstname = txtfirstname.getText().toString();
                surname = txtsurname.getText().toString();
                cell_nr = txtcell_nr.getText().toString();
                class_nr = txtclass_nr.getText().toString();
                email = txtemail.getText().toString();
                password = txtpassword.getText().toString();
                stud = new Student.Builder()
                        .first_name(firstname)
                        .surname(surname)
                        .cellphone_nr(cell_nr)
                        .class_nr(class_nr)
                        .e_mail(email)
                        .build();
                new Mytask().execute();

            }
        });
    }

    public void setTextboxes()
    {

        txtfirstname.setText(stud.getFirst_name());
        txtsurname.setText(stud.getSurname());
        txtcell_nr.setText(stud.getCellphone_nr());
        txtclass_nr.setText(stud.getClass_nr());
        txtemail.setText(stud.getE_mail());

    }

    class Mytask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {

            try{
                StudentRestServiceImpl studentRestService = new StudentRestServiceImpl(stud);
                stud = studentRestService.createStudent();
                setTextboxes();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    class Mytask2 extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {

            try{
                StudentRestServiceImpl studentRestService = new StudentRestServiceImpl(stud);
                stud = studentRestService.getStudentDetails();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}

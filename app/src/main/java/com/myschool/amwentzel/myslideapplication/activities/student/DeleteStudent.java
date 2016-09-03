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

import com.myschool.amwentzel.myslideapplication.R;
import com.myschool.amwentzel.myslideapplication.domain.Student;
import com.myschool.amwentzel.myslideapplication.restapi.student.StudentRestServiceImpl;

/**
 * Created by amwentzel on 2016/08/20.
 */
public class DeleteStudent extends Fragment{
    EditText txtstudent_nr;
    EditText txtfirstname;
    EditText txtsurname;
    EditText txtcell_nr;
    EditText txtclass_nr;
    EditText txtemail;

    Button update;
    Button search;

    private String student_nr;
    private String firstname;
    private String surname;
    private String cell_nr;
    private String class_nr;
    private String email;


    private Student stud;
    private Student stud2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_delete_student,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        txtstudent_nr  = (EditText) view.findViewById(R.id.student_nr);
        txtfirstname  = (EditText) view.findViewById(R.id.StudDeleteName);
        txtsurname  = (EditText) view.findViewById(R.id.StudDeletesurname);
        txtcell_nr  = (EditText) view.findViewById(R.id.StudDeleteCellNr);
        txtclass_nr  = (EditText) view.findViewById(R.id.StudDeleteClassnumber);
        txtemail  = (EditText) view.findViewById(R.id.StudDeleteEmail);
        update = (Button) view.findViewById(R.id.btnDelete);
        search = (Button) view.findViewById(R.id.btnSearchDeleteStudent);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                student_nr = txtstudent_nr.getText().toString();
                stud = new Student.Builder()
                        .parent_ID(Long.valueOf(student_nr))
                        .build();
                new Mytask2().execute();
                try {
                    Thread.sleep(5000);
                    setTextboxes();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Toast.makeText(getActivity(), "Result " + stud.getFirst_name() +", " + stud.getSurname(), Toast.LENGTH_LONG).show();
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

                stud2 = new Student.Builder()
                        .copy(stud)
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
                StudentRestServiceImpl studentRestService = new StudentRestServiceImpl(stud2);
                stud2 = studentRestService.deleteStudent();

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

package com.myschool.amwentzel.myslideapplication.activities.parent;

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
import com.myschool.amwentzel.myslideapplication.domain.Parent;
import com.myschool.amwentzel.myslideapplication.repositories.parent.Impl.ParentRepositoryImpl;
import com.myschool.amwentzel.myslideapplication.restapi.parent.ParentRestServiceImpl;

/**
 * Created by amwentzel on 2016/08/20.
 */
public class AddParent extends Fragment {
    EditText txtStudnr;
    EditText txtfirst_name;
    EditText txtsurname;
    EditText txtcellphone_nr;
    EditText txttelephone_nr;
    EditText txte_mail;
    Button btnAdd;

    private Parent p;
    private String studnr;
    private String first_name;
    private String surname;
    private String cellphone_nr;
    private String telephone_nr;
    private String e_mail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_add_parent,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        txtStudnr  = (EditText) view.findViewById(R.id.txtStudenrNr);
        txtfirst_name  = (EditText) view.findViewById(R.id.name);
        txtsurname  = (EditText) view.findViewById(R.id.surname);
        txtcellphone_nr  = (EditText) view.findViewById(R.id.txtCell);
        txttelephone_nr  = (EditText) view.findViewById(R.id.txtTell);
        txte_mail  = (EditText) view.findViewById(R.id.txtEmail);
        btnAdd = (Button) view.findViewById(R.id.btnAddParent);

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                studnr = txtStudnr.getText().toString();
                first_name = txtfirst_name.getText().toString();
                surname = txtsurname.getText().toString();
                cellphone_nr = txtcellphone_nr.getText().toString();
                telephone_nr = txttelephone_nr.getText().toString();
                e_mail = txte_mail.getText().toString();
                p = new Parent.Builder()
                        .student_nr(Long.parseLong(studnr))
                        .first_name(first_name)
                        .surname(surname)
                        .cellphone_nr(cellphone_nr)
                        .telephone_nr(telephone_nr)
                        .e_mail(e_mail)
                        .build();
                new Mytask().execute();

            }
        });

    }

    class Mytask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {

            try{
                ParentRestServiceImpl studentRestService = new ParentRestServiceImpl(p);
                p = studentRestService.createParent();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

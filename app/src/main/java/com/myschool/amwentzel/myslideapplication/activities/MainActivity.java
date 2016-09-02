package com.myschool.amwentzel.myslideapplication.activities;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.myschool.amwentzel.myslideapplication.R;
import com.myschool.amwentzel.myslideapplication.activities.absent.DeleteAbsent;
import com.myschool.amwentzel.myslideapplication.activities.absent.UpdateAbsent;
import com.myschool.amwentzel.myslideapplication.activities.absent.ViewAbsent;
import com.myschool.amwentzel.myslideapplication.activities.detention.AddDetention;
import com.myschool.amwentzel.myslideapplication.activities.detention.DeleteDetention;
import com.myschool.amwentzel.myslideapplication.activities.detention.UpdateDetention;
import com.myschool.amwentzel.myslideapplication.activities.detention.ViewAllDetention;
import com.myschool.amwentzel.myslideapplication.activities.homework.AddHomework;
import com.myschool.amwentzel.myslideapplication.activities.homework.ViewHomework;
import com.myschool.amwentzel.myslideapplication.activities.marks.AddMarks;
import com.myschool.amwentzel.myslideapplication.activities.marks.DeleteMarks;
import com.myschool.amwentzel.myslideapplication.activities.marks.UpdateMarks;
import com.myschool.amwentzel.myslideapplication.activities.marks.ViewMarks;
import com.myschool.amwentzel.myslideapplication.activities.parent.AddParent;
import com.myschool.amwentzel.myslideapplication.activities.parent.DeleteParent;
import com.myschool.amwentzel.myslideapplication.activities.parent.PreviewParents;
import com.myschool.amwentzel.myslideapplication.activities.parent.UpdateParent;
import com.myschool.amwentzel.myslideapplication.activities.student.AddStudent;
import com.myschool.amwentzel.myslideapplication.activities.student.DeleteStudent;
import com.myschool.amwentzel.myslideapplication.activities.student.UpdateStudent;
import com.myschool.amwentzel.myslideapplication.activities.student.ViewAllStudents;
import com.myschool.amwentzel.myslideapplication.activities.timetable.AddTimetable;
import com.myschool.amwentzel.myslideapplication.activities.timetable.DeleteTimetable;
import com.myschool.amwentzel.myslideapplication.activities.timetable.UpdateTimetable;
import com.myschool.amwentzel.myslideapplication.activities.timetable.ViewTimetable;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("id");
        String role = bundle.getString("role");
        if (role.equals("Teacher"))
        {
            setContentView(R.layout.activity_main);
        }else if (role.equals("Student"))
        {
            setContentView(R.layout.activity_main3);
        }else if (role.equals("Parent"))
        {
            setContentView(R.layout.activity_main2);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_add_absent) {
            fragment = new AddStudent();
        } else if (id == R.id.nav_update_absent) {
            fragment = new UpdateAbsent();
        } else if (id == R.id.nav_delete_absent) {
            fragment = new DeleteAbsent();
        } else if (id == R.id.nav_view_all_absent) {
            fragment = new ViewAbsent();
        } else if (id == R.id.nav_add_student) {
            fragment = new AddStudent();
        } else if (id == R.id.nav_update_student) {
            fragment = new UpdateStudent();
        }else if (id == R.id.nav_delete_student) {
            fragment = new DeleteStudent();
        } else if (id == R.id.nav_view_all_students) {
            fragment = new ViewAllStudents();
        }
        else if (id == R.id.nav_add_parent) {
            fragment = new AddParent();
        } else if (id == R.id.nav_update_parent) {
            fragment = new UpdateParent();
        }else if (id == R.id.nav_delete_parent) {
            fragment = new DeleteParent();
        } else if (id == R.id.nav_view_all_parents) {
            fragment = new PreviewParents();
        }else if (id == R.id.nav_add_mark) {
            fragment = new AddMarks();
        } else if (id == R.id.nav_update_mark) {
            fragment = new UpdateMarks();
        }else if (id == R.id.nav_delete_mark) {
            fragment = new DeleteMarks();
        } else if (id == R.id.nav_view_all_marks) {
            fragment = new ViewMarks();
        } else if (id == R.id.nav_add_homework) {
            fragment = new AddHomework();
        } else if (id == R.id.nav_update_homework) {
            fragment = new UpdateMarks();
        }else if (id == R.id.nav_delete_homework) {
            fragment = new DeleteMarks();
        } else if (id == R.id.nav_view_all_homework) {
            fragment = new ViewHomework();
        }else if (id == R.id.nav_add_detention) {
            fragment = new AddDetention();
        } else if (id == R.id.nav_update_detention) {
            fragment = new UpdateDetention();
        }else if (id == R.id.nav_delete_detention) {
            fragment = new DeleteDetention();
        } else if (id == R.id.nav_view_all_detention) {
            fragment = new ViewAllDetention();
        } else if (id == R.id.nav_add_period) {
            fragment = new AddTimetable();
        } else if (id == R.id.nav_update_period) {
            fragment = new UpdateTimetable();
        }else if (id == R.id.nav_delete_period) {
            fragment = new DeleteTimetable();
        } else if (id == R.id.nav_view_timetable) {
            fragment = new ViewTimetable();
        }



        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

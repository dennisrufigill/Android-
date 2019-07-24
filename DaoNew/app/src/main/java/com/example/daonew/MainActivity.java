package com.example.daonew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.daonew.database.CourseAssignDao;
import com.example.daonew.database.CourseDao;
import com.example.daonew.database.DaoSession;
import com.example.daonew.database.Users;
import com.example.daonew.database.UsersDao;

public class MainActivity extends AppCompatActivity {

    public static final int STATUS_ADMIN = 1;
    public static final int STATUS_TEACHER = 2;
    public static final int STATUS_STUDENT = 3;


    Button btn_adduser, btn_addcourse, btn_courseassign;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_adduser = findViewById(R.id.btn_addUser);
        btn_addcourse = findViewById(R.id.btn_addCourse);
        btn_courseassign = findViewById(R.id.btn_assignCourse);

        btn_adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UsersActivity.class);
                startActivity(intent);


            }
        });

      btn_addcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CoursesActivity.class);
                startActivity(intent);
            }
        });


      btn_courseassign.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent intent = new Intent(getApplicationContext(), CourseAssignActivity.class);
              startActivity(intent);
          }
      });

/*
        Users useradmin = new Users();

        useradmin.setGender("Male");
        useradmin.setName("Dennis");
        useradmin.setStatus(1);

        getUserDao().insert(useradmin);

        Users usersteacher  = new Users();
        usersteacher.setGender("Male");
        usersteacher.setName("Nadeem");
        usersteacher.setStatus(2);

        getUserDao().insert(usersteacher);

        Users usersstudent = new Users();
        usersstudent.setName("Dennis Rufi");
        usersstudent.setGender("Male");
        usersstudent.setStatus(3);


    }


    UsersDao getUserDao() {
        return ((MyApplication) getApplication()).getDaoSession().getUsersDao();
    }

    CourseDao getCourseDao() {
        return ((MyApplication) getApplication()).getDaoSession().getCourseDao();
    }

    CourseAssignDao getCourseAsgnDao() {
        return ((MyApplication) getApplication()).getDaoSession().getCourseAssignDao();
    }
    */
    }
}





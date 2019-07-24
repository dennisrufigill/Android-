package com.example.daonew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daonew.database.Course;
import com.example.daonew.database.CourseAssign;
import com.example.daonew.database.CourseAssignDao;
import com.example.daonew.database.CourseDao;
import com.example.daonew.database.DaoSession;
import com.example.daonew.database.Users;
import com.example.daonew.database.UsersDao;

import java.util.List;

public class CourseAssignActivity extends AppCompatActivity {

    DaoSession daoSession;

    CourseAssignDao courseAssignDao;
    CourseDao courseDao;
    UsersDao usersDao;

    //   List<CourseAssign> courseAssigns;

    public Spinner course_spinner, teacher_spinner, student_spinner;
    Button courseassign_button;

    //  String[] static_courses = {"DAA", "CAO", "OOP", "MAD", "OS"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_assign);


        course_spinner = findViewById(R.id.spinner_course);
        teacher_spinner = findViewById(R.id.spinner_teacher);
        student_spinner = findViewById(R.id.spinner_student);

        courseassign_button = findViewById(R.id.button_courseAssignment);


        daoSession = ((MyApplication) getApplication()).getDaoSession();


        CourseDao courseDao = daoSession.getCourseDao();

        List<Course> courselist = courseDao.queryBuilder().orderAsc().list();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.custom_spinner, courselist);
        course_spinner.setAdapter(customSpinnerAdapter);
        customSpinnerAdapter.notifyDataSetChanged();


        UsersDao usersDao = daoSession.getUsersDao();

        List<Users> teacherlist = usersDao.queryBuilder().where(UsersDao.Properties.Status.eq(2)).orderAsc().list();

        CustomSpinnerAdapterTeacher customSpinnerAdapterTeacher = new CustomSpinnerAdapterTeacher(this, R.layout.custom_spinner_teacher, teacherlist);
        teacher_spinner.setAdapter(customSpinnerAdapterTeacher);
        customSpinnerAdapterTeacher.notifyDataSetChanged();


        List<Users> studentlist1 = usersDao.queryBuilder().where(UsersDao.Properties.Status.eq(3)).orderAsc().list();

        CustomSpinnerAdapterStudent customSpinnerAdapterStudent = new CustomSpinnerAdapterStudent(this, R.layout.custom_spinner_student, studentlist1);
        student_spinner.setAdapter(customSpinnerAdapterStudent);
        customSpinnerAdapter.notifyDataSetChanged();


        courseassign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  Toast.makeText(getApplicationContext(), "Data Inserted Succesfully", Toast.LENGTH_SHORT).show();

                insertData();
            }
        });


    }

//

    public void insertData(){

        CourseAssignDao courseAssignDao = daoSession.getCourseAssignDao();

        CourseAssign courseAssign = new CourseAssign();

        courseAssign.setC_id(course_spinner.getId());
        courseAssign.setS_id(student_spinner.getId());
        courseAssign.setT_id(teacher_spinner.getId());

        long id = courseAssignDao.insert(courseAssign);
        Toast.makeText(getApplicationContext(), "Data Inserted Succesfully", Toast.LENGTH_SHORT).show();

    }
//
}
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
        ArrayAdapter spinnerAdaptercourse = new ArrayAdapter(this, android.R.layout.simple_spinner_item,courselist);
        course_spinner.setAdapter(spinnerAdaptercourse);
        spinnerAdaptercourse.notifyDataSetChanged();


        UsersDao usersDao = daoSession.getUsersDao();

        List<Users> teacherlist = usersDao.queryBuilder().where(UsersDao.Properties.Status.eq(2)).orderAsc().list();
        ArrayAdapter spinnerAdapterteacher = new ArrayAdapter(this, android.R.layout.simple_spinner_item,teacherlist);
        teacher_spinner.setAdapter(spinnerAdapterteacher);
        spinnerAdapterteacher.notifyDataSetChanged();


      List<Users> studentlist = usersDao.queryBuilder().where(UsersDao.Properties.Status.eq(3)).orderAsc().list();

      //  List<Users> studentlist1 = usersDao.queryBuilder().where(UsersDao.Properties.Name.eq("Dennis Rufi")).orderAsc().list();
        ArrayAdapter spinnerAdapterstudent = new ArrayAdapter(this, android.R.layout.simple_spinner_item,studentlist);
        student_spinner.setAdapter(spinnerAdapterstudent);
        spinnerAdapterstudent.notifyDataSetChanged();






    }

}
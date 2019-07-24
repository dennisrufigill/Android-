package com.example.daonew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daonew.database.Course;
import com.example.daonew.database.CourseDao;
import com.example.daonew.database.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class CoursesActivity extends AppCompatActivity {

    String GETcoursename, GETcredithour, GETcoursemarks;



    EditText courseName, courseCreditHours, course_MaxMarks;
    Button addCourseButton;

    ListView listView;
    Spinner spinner;

    ArrayAdapter<Course> courseArrayAdapter;

    List<Course> courses = new ArrayList<>();
    private Course editCourse;

    DaoSession daoSession;
    CourseDao courseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        courseName = findViewById(R.id.et_course_Name);
        courseCreditHours = findViewById(R.id.et_course_credit_hour);
        course_MaxMarks = findViewById(R.id.et_course_max_marks);
        addCourseButton = findViewById(R.id.btn_addNewCourse);
        listView = findViewById(R.id.listView_courses);
        spinner = findViewById(R.id.spinner);

        daoSession = ((MyApplication) getApplication()).getDaoSession();


        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(getApplicationContext(),"Clicked", Toast.LENGTH_SHORT).show();
                if (editCourse == null) {
                    insetitem();
                }

                else{

                    updateItem();
                }
            }
        });

        setupListView();

        //

        CourseDao courseDao = daoSession.getCourseDao();
        List<Course> courseslist = courseDao.queryBuilder().orderAsc().list();

            ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,courseslist);
            spinner.setAdapter(spinnerAdapter);
            spinnerAdapter.notifyDataSetChanged();




        //
    }


    public void insetitem() {

        CourseDao courseDao = daoSession.getCourseDao();

        GETcoursename = courseName.getText().toString();
        GETcredithour = courseCreditHours.getText().toString();
        GETcoursemarks = course_MaxMarks.getText().toString();


        if (TextUtils.isEmpty(GETcoursename) && TextUtils.isEmpty(GETcredithour)) {

            Toast.makeText(getApplicationContext(), "Please fill info", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(GETcoursename)) {

            Toast.makeText(getApplicationContext(), "Please fill Course Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GETcredithour)) {

            Toast.makeText(getApplicationContext(), "Please fill Credit Hour", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(GETcoursemarks)) {

            Toast.makeText(getApplicationContext(), "Please fill Max Marks", Toast.LENGTH_SHORT).show();
        } else {

            Course course = new Course();
            course.setName(courseName.getText().toString());
            course.setCredit_hour(Double.parseDouble(courseCreditHours.getText().toString()));
            course.setMax_marks(Double.parseDouble(course_MaxMarks.getText().toString()));

            long id = courseDao.insert(course);

            Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();

            courseName.setText("");
            courseCreditHours.setText("");
            course_MaxMarks.setText("");


            courseDao.loadAll();
            courseArrayAdapter.notifyDataSetChanged();
            setupListView();
        }
    }

    private void setupListView() {

        courses = daoSession.getCourseDao().queryBuilder().orderDesc(CourseDao.Properties.Id).list();
        courseArrayAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, courses);
        listView.setAdapter(courseArrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                showOptions(i);

                return true;
            }
        });

    }


    public void showOptions(final int position) {

        AlertDialog.Builder alertdialogBuildder = new AlertDialog.Builder(this);
        alertdialogBuildder.setTitle("Please select");

        alertdialogBuildder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                CourseDao courseDao = daoSession.getCourseDao();

                Course courseClicked = courses.get(position);

                courseDao.delete(courseClicked);


                Toast.makeText(getApplicationContext(), "Deleted:  " + courseClicked.getName(), Toast.LENGTH_SHORT).show();

                courses.remove(position);
                courseArrayAdapter.notifyDataSetChanged();
            }
        });

        alertdialogBuildder.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

              //  Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_SHORT).show();

                setValues(position);
            }
        });

        alertdialogBuildder.show();

    }


    public void setValues(int position){

        addCourseButton.setText("Update");
        editCourse = this.courses.get(position);
        courseName.setText(editCourse.getName());
        courseCreditHours.setText("" +editCourse.getCredit_hour());
        course_MaxMarks.setText(""+editCourse.getMax_marks());

    }


    public void updateItem(){

        CourseDao courseDao = daoSession.getCourseDao();

        editCourse.setName(courseName.getText().toString());
        editCourse.setCredit_hour(Double.parseDouble(courseCreditHours.getText().toString()));
        editCourse.setMax_marks(Double.parseDouble(course_MaxMarks.getText().toString()));

        courseDao.saveInTx(editCourse);

        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

        editCourse=null;
        courseName.setText("");
        courseCreditHours.setText("");
        course_MaxMarks.setText("");

        addCourseButton.setText("Add");

        courseArrayAdapter.notifyDataSetChanged();
    }

}

package com.example.daonew.database;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

public class JoinTeacherwithCourses {

    @Entity
    public class Users {
        @Id
        private long u_id;


        @ToMany
        @JoinEntity(entity = JoinTeacherswithCourses.class, sourceProperty = "u_id",
                targetProperty = "c_id")

        private List<Course> coursewithThisTeacher;


    }


    @Entity
    public class JoinTeacherswithCourses{

        @Id private long id;

        private long u_id;
        private long c_id;

    }


    @Entity
    public class Course{

        @Id private long c_id;

    }
}

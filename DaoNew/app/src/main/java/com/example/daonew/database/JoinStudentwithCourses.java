package com.example.daonew.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

public class JoinStudentwithCourses {

    @Entity
    public class Users {

        private long u_id;

        @ToMany
        @JoinEntity(entity = JoinStudentswithCourses.class,
                sourceProperty = "u_id", targetProperty = "c_id")

        private List<Course> coursewithThisStudent;


    }

    @Entity

    public class JoinStudentswithCourses {

        @Id
        private long id;
        private long u_id;
        private long c_id;

    }

    @Entity
    public class Course {

        @Id
        private long c_id;

    }

}

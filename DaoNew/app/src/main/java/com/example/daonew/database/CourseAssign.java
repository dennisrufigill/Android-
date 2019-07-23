package com.example.daonew.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class CourseAssign {


    @Id(autoincrement = true)
    private long id;

    private long c_id;

    private long t_id;

    private long s_id;

    @ToOne(joinProperty = "c_id")
    Course course;

    @ToOne(joinProperty = "t_id")
    Users teacher;

    @ToOne(joinProperty = "s_id")
    Users student;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 771126857)
    private transient CourseAssignDao myDao;

    @Generated(hash = 1923138427)
    public CourseAssign(long id, long c_id, long t_id, long s_id) {
        this.id = id;
        this.c_id = c_id;
        this.t_id = t_id;
        this.s_id = s_id;
    }

    @Generated(hash = 1729150199)
    public CourseAssign() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getC_id() {
        return this.c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public long getT_id() {
        return this.t_id;
    }

    public void setT_id(long t_id) {
        this.t_id = t_id;
    }

    public long getS_id() {
        return this.s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    @Generated(hash = 13676306)
    private transient Long course__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 138684768)
    public Course getCourse() {
        long __key = this.c_id;
        if (course__resolvedKey == null || !course__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CourseDao targetDao = daoSession.getCourseDao();
            Course courseNew = targetDao.load(__key);
            synchronized (this) {
                course = courseNew;
                course__resolvedKey = __key;
            }
        }
        return course;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1857244342)
    public void setCourse(@NotNull Course course) {
        if (course == null) {
            throw new DaoException(
                    "To-one property 'c_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.course = course;
            c_id = course.getId();
            course__resolvedKey = c_id;
        }
    }

    @Generated(hash = 155140967)
    private transient Long teacher__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 208339216)
    public Users getTeacher() {
        long __key = this.t_id;
        if (teacher__resolvedKey == null || !teacher__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UsersDao targetDao = daoSession.getUsersDao();
            Users teacherNew = targetDao.load(__key);
            synchronized (this) {
                teacher = teacherNew;
                teacher__resolvedKey = __key;
            }
        }
        return teacher;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 900038733)
    public void setTeacher(@NotNull Users teacher) {
        if (teacher == null) {
            throw new DaoException(
                    "To-one property 't_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.teacher = teacher;
            t_id = teacher.getId();
            teacher__resolvedKey = t_id;
        }
    }

    @Generated(hash = 79695740)
    private transient Long student__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1203350039)
    public Users getStudent() {
        long __key = this.s_id;
        if (student__resolvedKey == null || !student__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UsersDao targetDao = daoSession.getUsersDao();
            Users studentNew = targetDao.load(__key);
            synchronized (this) {
                student = studentNew;
                student__resolvedKey = __key;
            }
        }
        return student;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1473800779)
    public void setStudent(@NotNull Users student) {
        if (student == null) {
            throw new DaoException(
                    "To-one property 's_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.student = student;
            s_id = student.getId();
            student__resolvedKey = s_id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 459469913)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCourseAssignDao() : null;
    }

}

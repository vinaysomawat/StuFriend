package com.vinaysomawat.studentfriend;

/**
 * Created by Vinay Somawat on 06-01-2018.
 */

public class Course {
    public static final String ID = "ID";
    public static final String TABLE_NAME = "Course";
    public static final String COURSE_NAME = "CourseName";
    public static final String BUNK_COUNT = "BunkCount";
    public static final String LEC_TIME = "LectTime";

    public int id;
    public String course_name;
    public int bunk_count;
    public int lec_time;

    public Course()
    {

    }

    public Course(int id,String course_name,int bunk_count,int lec_time)
    {
        this.id = id;
        this.course_name = course_name;
        this.bunk_count = bunk_count;
        this.lec_time = lec_time;
    }
}

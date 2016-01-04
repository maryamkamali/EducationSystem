package com.mahan.biz;

import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public class Student extends Person {
    private Long studentNo;
    private FieldsOfStudy fieldsOfStudy;
    private Degree degree;
    private ArrayList<Course> courses;

    public FieldsOfStudy getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setFieldsOfStudy(FieldsOfStudy fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}


package com.mahan.biz;

import java.util.Date;

/**
 * Created by 921227 on 11/24/2015.
 */
public class Student extends Person {
    private Long studentID;
    private FieldsOfStudy fieldsOfStudy;
    private Degree degree;


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

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

}


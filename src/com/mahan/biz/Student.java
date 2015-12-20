package com.mahan.biz;

/**
 * Created by 921227 on 11/24/2015.
 */
public class Student extends Person {
    private Long studentNo;
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

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

}


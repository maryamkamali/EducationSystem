package com.mahan.biz;

/**
 * Created by 921227 on 11/28/2015.
 */
public class Teacher extends Person{
    private Faculty faculty;
    private Position position;
    private Long teacherNo;
    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Long getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Long teacherNo) {
        this.teacherNo = teacherNo;
    }

    @Override
    public String toString() {
        return this.getLastname();
    }

}

package com.mahan.UI.Model;

/**
 * Created by 921227 on 11/28/2015.
 */
public class Teacher extends Person{

    private Position position;
    private Long teacherNo;

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

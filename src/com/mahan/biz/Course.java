package com.mahan.biz;

/**
 * Created by 921227 on 11/28/2015.
 */
public class Course {
    private Long courseNo;
    private int point;
    private String teacherName;
    private Teacher teacher;
    private Long dId;
    private String title;

    public Long getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Long courseNo) {
        this.courseNo = courseNo;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long id) {
        dId = id;
    }
}

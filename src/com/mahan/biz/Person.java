package com.mahan.biz;

/**
 * Created by 921227 on 11/11/2015.
 */
public class Person {
    private String firstname;
    private String lastname;
    private long nationalNo;
    private String birthDate;
    private String gender;
    private String email;
    private String tel;
    private String address;
private Long dId;
    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public long getNationalNo() {
        return nationalNo;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTel() {
        return tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNationalNo(long nationalNo) {
        this.nationalNo = nationalNo;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }
}

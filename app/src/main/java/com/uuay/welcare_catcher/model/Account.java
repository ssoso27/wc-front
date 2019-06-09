package com.uuay.welcare_catcher.model;

public class Account {
    private String nickname;
    private String profile_img;
    private String email;
    private String age_group;
    private String disability_type;
    private String disability_grade;

    public Account(String nickname, String profile_img, String email, String age_group, String disability_type, String disability_grade) {
        this.nickname = nickname;
        this.profile_img = profile_img;
        this.email = email;
        this.age_group = age_group;
        this.disability_type = disability_type;
        this.disability_grade = disability_grade;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public String getDisability_type() {
        return disability_type;
    }

    public void setDisability_type(String disability_type) {
        this.disability_type = disability_type;
    }

    public String getDisability_grade() {
        return disability_grade;
    }

    public void setDisability_grade(String disability_grade) {
        this.disability_grade = disability_grade;
    }
}

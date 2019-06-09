package com.uuay.welcare_catcher.model;

public class Account {
    private String nickname;
    private String profile_img;
    private String email;
    private String kakao_id;
    private String password;
    private String age_group;
    private String disability_type;
    private String disability_grade;

    public Account() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getKakao_id() {
        return kakao_id;
    }

    public void setKakao_id(String kakao_id) {
        this.kakao_id = kakao_id;
    }
}

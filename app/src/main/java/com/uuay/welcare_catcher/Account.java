package com.uuay.welcare_catcher;

import lombok.Data;

@Data
public class Account {
    private String nickname;
    private String profile_img;
    private String email;
    private String disability_type;
    private String disability_grade;

    public Account(String nickname, String profile_img, String email, String disability_type, String disability_grade) {
        this.nickname = nickname;
        this.email = email;
        this.profile_img = profile_img;
        this.disability_grade = disability_grade;
        this.disability_type = disability_type;
    }
}

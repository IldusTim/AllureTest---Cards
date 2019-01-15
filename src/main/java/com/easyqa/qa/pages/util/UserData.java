package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;

public class UserData {

    private String userEmail;
    private String userPassword;

    public UserData(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Step
    public String getUserEmail() {
        return this.userEmail;
    }

    @Step
    public String getUserPassword() {
        return this.userPassword;

    }
}
package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;


public class DashboardPage {

    @FindBy(xpath = "//a[@href='/user/edit']")
    public SelenideElement profileLink;

    @FindBy(xpath = " //a[@href='/projects']")
    public SelenideElement myProjectsLink;


    @Step
    public void checkUserAuthorized() {

        profileLink.shouldBe(Condition.visible);
    }

    @Step
    public  ProjectsPage openMyProjects(){
        myProjectsLink.click();
        return Selenide.page(ProjectsPage.class);
    }
}

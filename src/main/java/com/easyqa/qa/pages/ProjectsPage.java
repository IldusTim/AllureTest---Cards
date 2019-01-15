package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class ProjectsPage {
    @FindBy(xpath = "//h1[.='My Projects']")
    public SelenideElement projectsHeader;

    @FindBy(xpath = "//div[@class='name-block']")
    public SelenideElement projectName;

    @Step
    public void checkProjectsPage(){
        projectsHeader.shouldBe(Condition.visible);
    }

    @Step
    public ProjectDashboardPage openProject(){
        projectName.click();
        return page(ProjectDashboardPage.class);
    }
}

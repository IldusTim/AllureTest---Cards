package com.easyqa.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class IssuesPage {

    @FindBy(xpath = "//h2[.='Issues summary']")
    public SelenideElement issuesHeader;

    @FindBy(xpath = "//a[.='Add new issue']")
    public SelenideElement addNewIssueBtn;

    @FindBy(id = "issue_summary")
    public SelenideElement issueSummary;

    @FindBy(id = "issue_description")
    public SelenideElement issueDescription;

    @FindBy(id = "type-view")
    public SelenideElement issueTypeSelector;

    @FindBy(xpath = "//label[.='Bug']")
    public SelenideElement issueTypeBug;

    @FindBy(id = "issue_priority")
    public SelenideElement issuePrioritySelector;

    @FindBy(xpath = "//label[.='Critical']")
    public SelenideElement issuePriorityCritical;

    @FindBy(xpath = "//label[.='High']")
    public SelenideElement issuePriorityHigh;

    @FindBy(xpath = "//label[.='Medium']")
    public SelenideElement issuePriorityMedium;

    @FindBy(xpath = "//label[.='Loww']")
    public SelenideElement issuePriorityLow;

    @FindBy(name = "commit")
    public SelenideElement issueSaveBtn;

    @FindBy(xpath = "//div[@class='card_message']")
    public SelenideElement cardName;

    @Step
    public void checkIssuesPage() {
        issuesHeader.shouldBe(Condition.visible);
        addNewIssueBtn.shouldBe(Condition.visible);
    }

    @Step
    public void clickAddNewIssue() {
        addNewIssueBtn.click();
    }

    @Step
    public void setIssueTypeBug() {
        issueTypeSelector.click();
        issueTypeBug.click();
    }

    @Step
    public void setIssuePriority(String priority) {
        issuePrioritySelector.click();
        switch (priority) {
            case "Low":
                issuePriorityLow.click();
                break;
            case "Medium":
                issuePriorityMedium.click();
                break;
            case "High":
                issuePriorityHigh.click();
                break;
            case "Critical":
                issuePriorityCritical.click();
                break;
        }
    }

    @Step
    public void addNewIssue(String issueName, String issueDesc, String issuePriority) {
        issueSummary.click();
        issueSummary.sendKeys(issueName);
        issueDescription.click();
        issueDescription.sendKeys(issueDesc);
        setIssueTypeBug();
        setIssuePriority(issuePriority);
        issueSaveBtn.click();
    }

    @Step
    public void checkIssueAdded(String issueName) {
        cardName.shouldBe(Condition.text(issueName));
    }
}

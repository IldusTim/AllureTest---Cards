import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.easyqa.qa.pages.*;
import com.easyqa.qa.pages.util.CardData;
import com.easyqa.qa.pages.util.UserData;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class FirstTests {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        //Configuration.browserSize = "1600x1000";

    }

    @Test
    public void loginAsRegisteredUser() {

        UserData userData = new UserData("idustim@ya.ru","NK7050507");
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        loginPage.enterUser(userData.getUserEmail(), userData.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects() {
        UserData userData = new UserData("idustim@ya.ru","NK7050507");
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        loginPage.enterUser(userData.getUserEmail(), userData.getUserPassword());
        /*loginPage.enterLogin("idustim@ya.ru");
        loginPage.enterPassword("NK7050507");*/
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectPage = dashboardPage.openMyProjects();
        projectPage.checkProjectsPage();
    }

    @Test
    public void createCard() {
        CardData issue = new CardData("test2","test description", "Critical");
        UserData userData = new UserData("idustim@ya.ru","NK7050507");
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        loginPage.enterUser(userData.getUserEmail(), userData.getUserPassword());
        /*loginPage.enterLogin("idustim@ya.ru");
        loginPage.enterPassword("NK7050507");*/
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectPage = dashboardPage.openMyProjects();
        projectPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clickAddNewIssue();
        issuesPage.addNewIssue(issue.getCardName(), issue.getCardDescription(), issue.getCardPriority());
        issuesPage.checkIssueAdded(issue.getCardName());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        close();
    }
}

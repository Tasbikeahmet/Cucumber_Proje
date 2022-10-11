package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("User is on Login Page")
    public void userIsOnLoginPage() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    }

    @And("User filled the username and Password")
    public void userFilledTheUsernameAndPassword() {
        dc.findAndSend("email_SignIn", "akhmet@gmail.com");
        dc.findAndSend("password_SignIn", "Ahmet1234");
    }

    @When("User click the sign in button")
    public void userClickTheSignInButton() {
        dc.findAndClick("submitButton");
    }

    @Then("User should login")
    public void userShouldLogin() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/"));
        Assert.assertEquals("https://magento.softwaretestingboard.com/", GWD.driver.getCurrentUrl());
    }
}

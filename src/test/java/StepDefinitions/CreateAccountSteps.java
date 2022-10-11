package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class CreateAccountSteps {

    DialogContent dc = new DialogContent();
    @Given("User is on Create Account Page")
    public void userIsOnCreateAccountPage() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @And("User filled the information")
    public void userFilledTheInformation(DataTable elements) {
        List<List<String>> listElements = elements.asLists(String.class);

        for (List<String> listElement : listElements) {
            dc.findAndSend(listElement.get(0), listElement.get(1));
        }
    }

    @When("User click the Create an Account Button")
    public void userClickTheCreateAnAccountButton() {
        dc.findAndClick("submitButton");
    }

    @Then("Account should be created")
    public void accountShouldBeCreated() {
        dc.findAndContainsText("successMessage", "Thank you");
    }
}

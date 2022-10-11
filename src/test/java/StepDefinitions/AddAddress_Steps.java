package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class AddAddress_Steps {
    DialogContent dc = new DialogContent();

    @Given("User is on My Account Page")
    public void userIsOnMyAccountPage() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/customer/account/");
    }

    @And("User clicked Manage Addresses button")
    public void userClickedManageAddressesButton() {
        dc.findAndClick("manageAddresses");
    }

    @And("User clicked Add Address button")
    public void userClickedAddAddressButton() {
        dc.findAndClick("submitButton");
    }

    @And("User filled the form")
    public void userFilledTheForm(DataTable elements) {
        List<List<String>> listElements = elements.asLists(String.class);

        for (List<String> listElement : listElements) {
            if (listElement.get(0).equals("state")) {
                dc.findAndSelectWithVisibleText(listElement.get(0), listElement.get(1));
            } else if (listElement.get(0).equals("zipCode")) {
                dc.findAndSendWithoutClear(listElement.get(0), listElement.get(1));
            } else {
                dc.findAndSend(listElement.get(0), listElement.get(1));
            }
        }
    }

    @When("User click Save Address button")
    public void userClickSaveAddressButton() {
        dc.findAndClick("submitButton");
    }

    @Then("The address should be added")
    public void theAddressShouldBeAdded() {
        dc.findAndContainsText("successMessage", "You saved the address.");
    }
}

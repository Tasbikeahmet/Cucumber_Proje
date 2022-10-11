package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPurchase_Steps {
    DialogContent dc = new DialogContent();

    @Given("User clicked a product on HomePage")
    public void userClickedAProductOnHomePage() {
        dc.findAndClick("firstItem");
    }

    @And("User selected a size")
    public void userSelectedASize() {
        dc.findAndClick("sizeXS");
    }

    @And("User selected a color")
    public void userSelectedAColor() {
        dc.findAndClick("colorBlue");
    }

    @And("User clicked add to cart button")
    public void userClickedAddToCartButton() {
        dc.findAndClick("addToCart");
        dc.checkSuccessMessage();
    }

    @And("User navigated to checkout page")
    public void userNavigatedToCheckoutPage() {
        dc.findAndClick("cartIcon");
        dc.findAndClick("checkOut");
    }

    @When("User completed checkout")
    public void userCompletedCheckout() {
        dc.waitLoading();
        dc.findAndClick("nextButton");
        dc.waitLoading();
        dc.findAndClick("placeOrder");
    }

    @Then("User should see thank you message")
    public void userShouldSeeThankYouMessage() {
        dc.checkPurchaseMessage();
    }


}

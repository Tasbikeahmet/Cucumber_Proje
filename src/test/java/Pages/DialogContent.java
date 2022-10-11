package Pages;

import Utilities.GWD;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "firstname")
    private WebElement name;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPassword;

    @FindBy(css = ".actions-toolbar button")
    private WebElement submitButton;

    @FindBy(css = "[data-ui-id='message-success'] > div")
    private WebElement successMessage;

    @FindBy(id = "send2")
    private WebElement signIn;

    @FindBy(id = "email")
    private WebElement email_SignIn;

    @FindBy(id = "pass")
    private WebElement password_SignIn;

    @FindBy(css = "a[href*='customer/address/']")
    private WebElement manageAddresses;

    @FindBy(css = "[role='add-address']")
    private WebElement addAddress;

    @FindBy(id = "telephone")
    private WebElement phoneNumber;

    @FindBy(id = "street_1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "region_id")
    private WebElement state;

    @FindBy(id = "zip")
    private WebElement zipCode;

    @FindBy(css = "li.product-item")
    private WebElement firstItem;

    @FindBy(css = "button[title='Add to Cart']")
    private WebElement addToCart;

    @FindBy(css = "[option-label='XS']")
    private WebElement sizeXS;

    @FindBy(css = "[option-label='Blue']")
    private WebElement colorBlue;

    @FindBy(css = "a.showcart")
    private WebElement cartIcon;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkOut;

    @FindBy(css = "[data-role='opc-continue']")
    private WebElement nextButton;

    @FindBy(css = "[title='Place Order']")
    private WebElement placeOrder;

    @FindBy(css = "[data-ui-id='page-title-wrapper']")
    private WebElement purchaseMessage;

    @FindBy(css = "[data-ui-id='message-success']")
    private WebElement addedToCartMessage;

    @FindBy(className = "loading-mask")
    private WebElement loader;

    WebElement myElement;


    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "name":
                myElement = name;
                break;
            case "lastName":
                myElement = lastName;
                break;
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;
            case "confirmPassword":
                myElement = confirmPassword;
                break;
            case "email_SignIn":
                myElement = email_SignIn;
                break;
            case "password_SignIn":
                myElement = password_SignIn;
                break;
            case "phoneNumber":
                myElement = phoneNumber;
                break;
            case "address1":
                myElement = address1;
                break;
            case "city":
                myElement = city;
                break;
            case "state":
                myElement = state;
                break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndSendWithoutClear(String strElement, String value) {
        switch (strElement) {
            case "zipCode":
                myElement = zipCode;
                break;
        }
        SendKeysWithoutClearFunction(myElement, value);
    }

    public void findAndClick(String strElement) {  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "submitButton":
                myElement = submitButton;
                break;
            case "manageAddresses":
                myElement = manageAddresses;
                break;
            case "firstItem":
                myElement = firstItem;
                break;
            case "addToCart":
                myElement = addToCart;
                break;
            case "sizeXS":
                myElement = sizeXS;
                break;
            case "colorBlue":
                myElement = colorBlue;
                break;
            case "cartIcon":
                myElement = cartIcon;
                break;
            case "checkOut":
                myElement = checkOut;
                break;
            case "nextButton":
                myElement = nextButton;
                break;
            case "placeOrder":
                myElement = placeOrder;
                break;


        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "successMessage":
                myElement = successMessage;
                break;
            case "purchaseMessage":
                myElement = purchaseMessage;
                break;
            case "addedToCartMessage":
                myElement = addedToCartMessage;
                break;
        }
        verifyContainsText(myElement, text);
    }

    public void findAndSelectWithVisibleText(String element, String text) {
        switch (element) {
            case "state":
                myElement = state;
                break;
        }

        waitUntilClickable(myElement);
        Select select = new Select(myElement);
        select.selectByVisibleText(text);
    }

    public void checkSuccessMessage() {
        waitUntilVisible(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void checkPurchaseMessage() {
        waitUntilVisible(purchaseMessage);
        Assert.assertTrue(purchaseMessage.isDisplayed());
    }

    public void waitLoading() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

}

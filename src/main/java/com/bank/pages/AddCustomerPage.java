package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitCustomer;


    public void enterFirstName(String name) {
        CustomListeners.node.log(Status.PASS,"fist name");
        sendTextToElement(firstName, name);
        Reporter.log("Enter 'First Name' Button" + "<br>");
    }

    public void enterLastName(String last) {
        sendTextToElement(lastName, last);
        CustomListeners.node.log(Status.PASS, "Enter 'Last Name' Button");
        Reporter.log("Enter 'Last Name' Button" + "<br>");
    }

    public void enterPostCode(String code) {
        sendTextToElement(postCode, code);
//        CustomListeners.node.log(Status.PASS, "Enter 'PostCode' Button");
//        Reporter.log("Enter 'PostCode' Button" + "<br>");
    }

    public void clickOnSubmitCustomer() {
        clickOnElement(submitCustomer);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Customer added successfully"));
        acceptAlert();
//        CustomListeners.node.log(Status.PASS, "Click on 'Submit Customer' Button");
//        Reporter.log("Click on 'Submit Customer' Button" + "<br>");
    }
}

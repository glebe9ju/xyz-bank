package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
        public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLogin;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLogin;


    public void clickOnCustomerLogin(){
        clickOnElement(customerLogin);
        CustomListeners.node.log(Status.PASS, "Click on 'Add Customer' Button");
        Reporter.log("Click on 'Add Customer' Button" + "<br>");
    }
    public void clickOnBankLogin(){
        clickOnElement(bankManagerLogin);
    }
}

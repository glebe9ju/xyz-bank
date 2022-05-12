package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customersLog;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement logIn;
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logOut;




    public void clickOnCustomerLogIn(){
        clickOnElement(customersLog);
    }
    public void selectCustomerName(String name){
        sendTextToElement(searchCustomer,name);
    }
    public void clickOnLogInButton(){
        clickOnElement(logIn);
    }
    public void clickOnLogOut(){
        clickOnElement(logOut);
    }


}

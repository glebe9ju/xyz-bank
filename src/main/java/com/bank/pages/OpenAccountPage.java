package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement searchCurrency;
    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement process;

    public void clickOnOpenAccount(){
        clickOnElement(openAccount);
    }
    public void searchCustomerName(String cName){
        selectByVisibleTextFromDropDown(searchCustomer, cName);
    }
    public void setSearchCurrencyPenny(String cuPenny){
        selectByVisibleTextFromDropDown(searchCurrency,cuPenny);
    }
    public void clickOnProcess(){
        clickOnElement(process);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Account created successfully"));
        acceptAlert();
    }


}

package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement deposit;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement addAmount;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDeposit;
    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement depositMessage;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawl;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawAmount;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawSubmit;
    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement transactionSuccessful;



    public void clickOnDeposite(){
        clickOnElement(deposit);
    }
    public void enterAmount(String amount){
        sendTextToElement(addAmount,amount);
    }
    public void clickOnSubmitDeposit(){
        clickOnElement(submitDeposit);
    }
    public String verifyDepositMessage() {
        return getTextFromElement(depositMessage);
    }
    public void clickOnWithdraw(){
        clickOnElement(withdrawl);
    }
    public void enterWithDraw(String money){
        sendTextToElement(withdrawAmount,money);
    }
    public void clickOnWthdrawButton(){
        clickOnElement(withdrawSubmit);
    }
    public String verifyTransactionSuccessful(){
        return getTextFromElement(transactionSuccessful);
    }
}

package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();
       }
    @Test
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
// click On "Bank Manager Login" Tab
        homePage.clickOnBankLogin();
        Thread.sleep(2000);
//	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomer();
        Thread.sleep(2000);
//	enter FirstName
        addCustomerPage.enterFirstName("Mark");
        Thread.sleep(2000);
//	enter LastName
        addCustomerPage.enterLastName("Paul");
        Thread.sleep(2000);
//	enter PostCode
        addCustomerPage.enterPostCode("XY1 4ZX");
        Thread.sleep(2000);
//	click On "Add Customer" Button
        addCustomerPage.clickOnSubmitCustomer();

    }
    @Test
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankLogin();
        Thread.sleep(2000);
        //	click On "Open Account" Tab
        openAccountPage.clickOnOpenAccount();
        Thread.sleep(2000);
        //	Search customer that created in first test
        openAccountPage.searchCustomerName("Harry Potter");
        Thread.sleep(2000);
        //	Select currency "Pound"
        openAccountPage.setSearchCurrencyPenny("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcess();
        //	popup displayed
        Thread.sleep(2000);
        //	verify message "Account created successfully"
        //	click on "ok" button on popup.
    }
    @Test
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        Thread.sleep(2000);
        //click on "Customer Login" Tab
        customerLoginPage.clickOnCustomerLogIn();
        //	search customer that you created.
        customerLoginPage.selectCustomerName("Harry Potter");
        //	click on "Login" Button
        customerLoginPage.clickOnLogInButton();

    }

    @Test
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.clickOnCustomerLogIn();
        Thread.sleep(2000);
        //	search customer that you created.
        customerLoginPage.selectCustomerName("Harry Potter");
        //	click on "Login" Button
        customerLoginPage.clickOnLogInButton();
        //	click on "Deposit" Tab
        accountPage.clickOnDeposite();
        //	Enter amount 100
        accountPage.enterAmount("100");
        //	click on "Deposit" Button
        accountPage.clickOnSubmitDeposit();
        //	verify message "Deposit Successful"
        String expcted = "Deposit Successful";
        String actual = accountPage.verifyDepositMessage();
        Assert.assertEquals(actual,expcted,"not diplayed");
    }

    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.clickOnCustomerLogIn();
        //	search customer that you created.
        customerLoginPage.selectCustomerName("Harry Potter");
        //	click on "Login" Button
        customerLoginPage.clickOnLogInButton();
        //	click on "Deposit" Tab
        accountPage.clickOnDeposite();
        //	Enter amount 100
        accountPage.enterAmount("100");
        //	click on "Deposit" Button
        accountPage.clickOnSubmitDeposit();
        Thread.sleep(2000);
        //	click on "Withdrawl" Tab
        accountPage.clickOnWithdraw();
        Thread.sleep(2000);
        //	Enter amount 50
        accountPage.enterWithDraw("50");
        //	click on "Withdraw" Button
        accountPage.clickOnWthdrawButton();
        //	verify message "Transaction Successful"
        String expected = "Transaction successful";
        String acctual = accountPage.verifyTransactionSuccessful();
        System.out.println(acctual);
                Assert.assertEquals(acctual,expected,"not displayed");
    }
}

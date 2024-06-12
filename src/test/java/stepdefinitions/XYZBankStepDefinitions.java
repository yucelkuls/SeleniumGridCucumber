package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.XYZBankCustomerPage;
import pages.XYZBankHomePage;
import pages.XYZBankManagerPage;
import utilities.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class XYZBankStepDefinitions {

    XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
    XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
    XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();

    @When("click on Bank Manager Login")
    public void click_on_bank_manager_login() {
        xyzBankHomePage.bankManagerLoginButton.click();
    }

    @When("click on Add Customer")
    public void click_on_add_customer() {
        xyzBankManagerPage.addCustomerButton.click();
    }

    @When("enter firstname {string}, lastname {string}, postcode {string}")
    public void enter_firstname_lastname_postcode(String firstname, String lastname, String postcode) {
        xyzBankManagerPage.firstname.sendKeys(firstname);
        xyzBankManagerPage.lastname.sendKeys(lastname);
        xyzBankManagerPage.postCode.sendKeys(postcode);
    }

    @When("click on Add Customer Submit button")
    public void click_on_add_customer_submit_button() {
        xyzBankManagerPage.addCustomerSubmit.click();

        try {
            Driver.getDriver().switchTo().alert().accept();
        } catch (Exception ignored) {
        }

    }

    @When("click on Open Account")
    public void click_on_open_account() {
        xyzBankManagerPage.openAccountButton.click();
    }


    @And("select the customer and currency and submit")
    public void selectTheCustomerAndCurrencyAndSubmit() {

        for (int i = 6; i < 11; i++) {//5 kez çalışır

            new Select(xyzBankManagerPage.customerSelect).selectByIndex(i);
            new Select(xyzBankManagerPage.currency).selectByIndex(1);
            xyzBankManagerPage.process.click();
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }
        }
    }

    @When("click on Customer login")
    public void click_on_customer_login() {
        xyzBankHomePage.customerLoginButton.click();
    }

    @When("select the name")
    public void select_the_name() {
        new Select(xyzBankCustomerPage.yourNameSelect).selectByIndex(6);
    }

    @When("click on login")
    public void click_on_login() {
        xyzBankCustomerPage.loginButton.click();
    }

    @When("click on deposit")
    public void click_on_deposit() {
        xyzBankCustomerPage.depositButton.click();
    }

    @And("enter amount {string}")
    public void enterAmount(String amount) {
        xyzBankCustomerPage.amountInput.sendKeys(amount);
    }

    @When("click on deposit submit")
    public void click_on_deposit_submit() {
        xyzBankCustomerPage.depositSubmit.click();
    }

    @When("click on withdraw")
    public void click_on_withdraw() {
        xyzBankCustomerPage.withdrawButton.click();
    }

    @Then("click on withdraw submit")
    public void click_on_withdraw_submit() {
        xyzBankCustomerPage.withdrawSubmit.click();
    }


    @And("enter withdraw amount")
    public void enterWithdrawAmount() {
        xyzBankCustomerPage.withdrawSubmit.click();
        xyzBankCustomerPage.amountWithdrawInput.sendKeys("100");
    }

    @And("assert Transaction successful")
    public void assertTransactionSuccessful() {
        assertEquals("Transaction successful", xyzBankCustomerPage.transactionSuccessful.getText());
    }

    @And("click on customers button")
    public void clickOnCustomersButton() {
        xyzBankManagerPage.customersButton.click();
    }

    @Then("delete users you created")
    public void deleteUsersYouCreated() throws InterruptedException {
        List<WebElement> deletes = xyzBankManagerPage.deleteButtons;
        System.out.println("Size: " + deletes.size());

        for (int i = deletes.size() - 1; i > 4; i--) {
            Thread.sleep(1000);
            deletes.get(i).click();
        }
    }

    @And("assert number of users is five")
    public void assertNumberOfUsersIsFive() {
        assertEquals(5, xyzBankManagerPage.deleteButtons.size());
    }

    @Given("user goes to url {string}")
    public void userGoesToUrl(String url) {
        Driver.getDriver().get(url);
    }

    @And("user closes the browser")
    public void userClosesTheBrowser() {
        Driver.closeDriver();
    }
}

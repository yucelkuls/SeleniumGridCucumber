package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class XYZBankCustomerPage {

    public XYZBankCustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "userSelect")
    public WebElement yourNameSelect;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amountWithdrawInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement depositSubmit;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    public WebElement withdrawButton;

    @FindBy(xpath = "//button[.='Withdraw']")
    public WebElement withdrawSubmit;

    @FindBy(xpath = "//span[.='Transaction successful']")
    public WebElement transactionSuccessful;


}

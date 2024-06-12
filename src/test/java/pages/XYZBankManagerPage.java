package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class XYZBankManagerPage {

    public XYZBankManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCustomerSubmit;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    public WebElement openAccountButton;

    @FindBy(id = "userSelect")
    public WebElement customerSelect;

    @FindBy(id = "currency")
    public WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    public WebElement process;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement customersButton;

    @FindBy(xpath = "//button[.='Delete']")
    public List<WebElement> deleteButtons;


}

@XYZBank
Feature: XYZ Bank

  Background: Go to homepage
    Given user goes to url "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"

  #Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created.
  @AddCustomer
  Scenario Outline: Add Customer
    When click on Bank Manager Login
    And click on Add Customer
    And enter firstname "<firstname>", lastname "<lastname>", postcode "<postcode>"
    And click on Add Customer Submit button
    Examples:
      | firstname | lastname | postcode |
      | John      | Doe      | 12345    |
      | Can       | Kaya     | 45677    |
      | Ali       | Can      | 34576    |
      | Veli      | Yan      | 98761    |
      | Fatma     | Tan      | 56782    |

  @OpenAccount
  Scenario: Open Account
    When click on Bank Manager Login
    And click on Open Account
    And select the customer and currency and submit

  Scenario: Deposit and Withdraw
    When click on Customer login
    And select the name
    And click on login
    And click on deposit
    And enter amount "100"
    And click on deposit submit
    When click on withdraw
    And enter withdraw amount
    Then click on withdraw submit
    And assert Transaction successful

  Scenario: Delete users
    When click on Bank Manager Login
    And click on customers button
    Then delete users you created
    And assert number of users is five
    And user closes the browser






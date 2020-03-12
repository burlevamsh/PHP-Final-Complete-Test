package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferingSelectors {
	WebDriver driver;
	public String actual = "";

	public ReferingSelectors(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(xpath = "//div[@class='dropdown dropdown-currency']//a[@id='dropdownCurrency']")
	WebElement dropdown;

	@FindBy(linkText = "EUR")
	WebElement currency;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm btn-wide mt-20 btn-block']")
	WebElement offers;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/section/div/div/div[2]/div/div/div[7]/div/div[2]/div/div[3]/div/div/a")
	WebElement summerVacationBtn;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement nameOfTraveller;

	@FindBy(xpath = "//input[@placeholder='Phone']")
	WebElement phone;

	@FindBy(xpath = "//textarea[@placeholder='Message']")
	WebElement message;

	@FindBy(xpath = "//input[@class='btn btn-success btn-success btn-block btn-lg']")
	WebElement contactBtn;

	@FindBy(xpath = "//div[@class='alert alert-success successMsg']")
	WebElement alertMessage;

	public void dropdownSelector() {
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).click().build().perform();
		action.moveToElement(currency).click().build().perform();

	}

	public void goToOffer() {
		offers.click();
	}

	public void goToSummerVacationPage() {
		summerVacationBtn.click();
	}

	public void details(String name) {
		nameOfTraveller.sendKeys(name);
	}

	public void phone(String phoneNumber) {
		phone.sendKeys(phoneNumber.substring(4, 13));
	}

	public void message(String messageTyped) {
		message.sendKeys(messageTyped);
	}

	public void contactClick() {
		contactBtn.click();
	}

	public void alert() {
		Actions action = new Actions(driver);
		action.moveToElement(alertMessage).build().perform();
		actual = alertMessage.getText();
	}

}

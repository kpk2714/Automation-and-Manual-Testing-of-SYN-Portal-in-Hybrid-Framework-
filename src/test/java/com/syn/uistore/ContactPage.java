package com.syn.uistore;

import org.openqa.selenium.By;

public class ContactPage {

	public By name = By.name("name");
	public By email = By.name("email");
	public By content = By.name("address");
	public By sendMessage = By.xpath("//button[contains(text(),'Send Message')]");
	public By verifyMessage = By.xpath("//h5[@class='text-red-700 mb-3 ng-star-inserted']");
}

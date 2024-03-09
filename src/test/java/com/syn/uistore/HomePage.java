package com.syn.uistore;

import org.openqa.selenium.By;

public class HomePage {

	public By name = By.xpath("//h1[contains(text(),'Search Your Name')]");
	public By userName = By.name("username");
	public By mobile = By.name("mobile");
	public By pin = By.name("pin");
	public By findName = By.xpath("//div[starts-with(@class,'mt-5')]/descendant::h3/child::strong");
	public By register = By.xpath("//a[contains(text(),'Register')]");
	public By login = By.xpath("//a[contains(text(),'Login')]");
	public By contact = By.xpath("//a[contains(text(),'Contact')]");
}

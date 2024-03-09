package com.syn.uistore;

import org.openqa.selenium.By;

public class LoginPage {

	public By username = By.name("username");
	public By password = By.name("password");
	public By submit = By.xpath("//button[contains(text(),'Submit')]");
	
	public By forgot = By.xpath("//a[contains(text(),'Forgot Password ?')]");
}

package com.syn.uistore;

import org.openqa.selenium.By;

public class ChangePasswordPage {

	public By password = By.xpath("//input[@placeholder='Enter Your Password ...']");
	public By confirmPassword = By.name("repassword");
	
	public By submit = By.xpath("//button[contains(text(),'Submit')]");
}

package com.syn.uistore;

import org.openqa.selenium.By;

public class ForgotPasswordPage {

	public By emailId = By.name("email");
	public By sendOtp = By.xpath("//button[contains(text(),'Send OTP')][1]");
	
	public By enterOtp = By.name("emailotp");
	public By resendOtp = By.xpath("//button[contains(text(),'Send OTP')][2]");
	public By submit = By.xpath("//button[contains(text(),'Submit')]");
}

package com.syn.uistore;

import org.openqa.selenium.By;

public class RegisterPage {

	public By name = By.name("name");
	
	public By email = By.name("email");
	public By emailSendOtp = By.xpath("//div[@class='inline ml-2 pl-1 w-2/12']/child::button");
	public By emailResendOtp = By.xpath("//button[contains(text(),' Re-Send ')]");
	public By enterEmailOtp = By.name("emailotp");
	public By emailSubmit = By.xpath("//button[starts-with(@class,'bg-green-700') and contains(text(),'Submit')]");
	public By verifyEmail = By.xpath("//div[@class='ml-1 pl-5 w-2/12 inline']/child::strong");
	
	public By mobile = By.name("number");
	public By mobileSendOtp = By.xpath("//button[@class='bg-green-700 text-white font-bold rounded-3xl fontsize pl-2 pr-3 pt-0.5 pb-0.5']");
	public By mobileResendOtp = By.xpath("//button[@class='bg-green-700 text-white font-bold rounded-xl fontsize pl-2.5 pr-3 pt-0.5 pb-0.5 ng-star-inserted']");
	public By enterMobileOtp = By.name("mobileotp");
	public By mobileSubmit = By.xpath("//button[@class='bg-green-700 text-white font-bold rounded-xl fontsize pl-5 pr-5 pt-0.5 pb-0.5']");
	public By verifyMobile = By.xpath("//div[@class='ml-1 pl-5 w-2/12 inline']/child::strong");
	
	public By dob = By.name("dob");
	
	public By state = By.name("state");
	public By university = By.name("university");
	public By institution = By.name("institution");
	public By department = By.name("department");
	public By degree = By.name("degree");
	public By yos = By.name("year");
	public By semester = By.name("semester");
	public By registrationNo = By.name("registration");
	public By rollNo = By.name("roll");
	
	public By district = By.name("district");
	public By policeStation = By.name("policeStation");
	public By postOffice = By.name("post");
	public By pinCode = By.name("pin");
	public By address = By.name("address");
	public By username = By.name("username");
	public By password = By.name("password");
	public By repassword = By.name("repassword");
	public By checkBox = By.name("checkbox");
	
	public By clear = By.xpath("//button[contains(text(),'Clear')]");
	public By submit = By.xpath("//button[@class='text-white font-bold bg-blue-700 w-full h-12 mb-7']");
}

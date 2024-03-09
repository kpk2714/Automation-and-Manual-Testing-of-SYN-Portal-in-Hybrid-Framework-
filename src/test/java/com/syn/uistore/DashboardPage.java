package com.syn.uistore;

import org.openqa.selenium.By;

public class DashboardPage {

	public By dashboard = By.xpath("//h1[contains(text(),'Dash-Board')]");
	public By logout = By.xpath("//button[@class='float-right mr-10 bg-gray-400 w-20 rounded-3xl font-extrabold']");
	
	public By synId = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[1]/child::h3[2]");
	public By name = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[2]/child::h3[2]");
	public By email = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[3]/child::h3[2]");
	public By mobile = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[4]/child::h3[2]");
	public By dob = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[5]/child::h3[2]");
	public By university = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[6]/child::h3[2]");
	public By institution = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[7]/child::h3[2]");
	public By degree = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[8]/child::h3[2]");
	public By department = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[9]/child::h3[2]");
	public By semester = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[10]/child::h3[2]");
	public By registrationNo = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[11]/child::h3[2]");
	public By rollNo = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[12]/child::h3[2]");
	public By state = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[13]/child::h3[2]");
	public By district = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[14]/child::h3[2]");
	public By policeStation = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[15]/child::h3[2]");
	public By pinCode = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[16]/child::h3[2]");
	public By address = By.xpath("//div[@class='mt-3']/child::div[1]/child::div[17]/child::h3[2]");
}

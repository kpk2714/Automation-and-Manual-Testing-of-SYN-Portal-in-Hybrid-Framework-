package com.syn.utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyReader {
	
	static String twilioPath = System.getProperty("user.dir")+"/Config/browser.properties";
	static Properties twilioProp = new Properties();

	public static Properties getTwilioProperties() {
		try {
			FileInputStream fr = new FileInputStream(twilioPath);
			twilioProp.load(fr);
		}
		catch(Exception e) {
			System.out.println("Twilio properties not found");
		}
		return twilioProp;
	}
	
	static String dotclickPath = System.getProperty("user.dir")+"/Config/demo.properties";
	static Properties dotclickProp = new Properties();

	public static Properties getDotClickProperties() {
		try {
			FileInputStream fr = new FileInputStream(dotclickPath);
			dotclickProp.load(fr);
		}
		catch(Exception e) {
			System.out.println("Dot Click properties not found");
		}
		return dotclickProp;
	}
}

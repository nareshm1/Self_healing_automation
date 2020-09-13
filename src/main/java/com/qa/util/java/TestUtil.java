package com.qa.util.java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import one.last.time.healing.Base;

public class TestUtil extends Base {

	
	/***************************************************************************************
	 * Method for taking screenshot of the error and store it in the folder named screenshots
	 ****************************************************************************************/
	public static void takeScreenshotAtEndOfTest() throws IOException {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
		
	}

	
}

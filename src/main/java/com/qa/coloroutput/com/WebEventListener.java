package com.qa.coloroutput.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.epam.healenium.SelfHealingDriver;
import com.qa.util.java.TestUtil;

import one.last.time.healing.Base;

public abstract class WebEventListener extends Base implements WebDriverEventListener {
	
	Colorme concol;
	
	public void beforeNavigateTo(String url, SelfHealingDriver tldriver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Before navigating to: '" + url + "'"+concol.RESET);
	}

	public void afterNavigateTo(String url, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigated to:'" + url + "'"+concol.RESET);
	}

	public void beforeChangeValueOf(WebElement element, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Value of the:" + element.toString() + " before any changes made"+concol.RESET);
	}

	public void afterChangeValueOf(WebElement element, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Element value changed to: " + element.toString()+concol.RESET);
	}

	public void beforeClickOn(WebElement element, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Trying to click on: " + element.toString()+concol.RESET);
	}

	public void afterClickOn(WebElement element, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Clicked on: " + element.toString()+concol.RESET);
	}

	public void beforeNavigateBack(SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigating back to previous page"+concol.RESET);
	}

	public void afterNavigateBack(SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigated back to previous page"+concol.RESET);
	}

	public void beforeNavigateForward(SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigating forward to next page"+concol.RESET);
	}

	public void afterNavigateForward(SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Navigated forward to next page"+concol.RESET);
	}

	public void onException(Throwable error, SelfHealingDriver driver) {
		System.out.println(concol.RED_BOLD_BRIGHT+"Exception occured: " + error+concol.RESET);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			System.out.println(concol.RED_BOLD_BRIGHT+"Took Screenshot of error  "+concol.RESET);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void MovetoElement(By by, WebElement element, SelfHealingDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Trying to find Element By : " + by.toString()+concol.RESET);
	}


	public void beforeFindBy(By by, WebElement element, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Trying to find Element By : " + by.toString()+concol.RESET);
	}

	public void afterFindBy(By by, WebElement element, SelfHealingDriver driver) {
		System.out.println(concol.PURPLE_BOLD_BRIGHT+"Found Element By : " + by.toString()+concol.RESET);
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, SelfHealingDriver driver) {
	}

	public void afterScript(String script, SelfHealingDriver driver) {
	}

	public void beforeAlertAccept(SelfHealingDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(SelfHealingDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(SelfHealingDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(SelfHealingDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(SelfHealingDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(SelfHealingDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, SelfHealingDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, SelfHealingDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, SelfHealingDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, SelfHealingDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, SelfHealingDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, SelfHealingDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void MoveToElemet(String windowName, SelfHealingDriver driver) {
		 /**
		   * This action will be performed each time after  {@link org.openqa.selenium.SelfHealingDriver.TargetLocator#window(java.lang.String)}
		   *
		   * @param driver SelfHealingDriver
		   */

	}

	
	

}

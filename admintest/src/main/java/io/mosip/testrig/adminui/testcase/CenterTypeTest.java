package io.mosip.testrig.adminui.testcase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.mosip.testrig.adminui.utility.BaseClass;
import io.mosip.testrig.adminui.utility.Commons;
public class CenterTypeTest extends BaseClass{
   @Test(groups = "CT")
  public void centerTypeCRUD() {
	   test=extent.createTest("DeviceTest", "verify Login");
	  String idCenterTypeCard="admin/masterdata/center-type/view";
   
    Commons.click(test,driver,By.xpath("//a[@href='#/admin/masterdata']"));
   
    Commons.click(test,driver,By.id(idCenterTypeCard));
    Commons.click(test,driver,By.id("Create"));
    test.log(Status.INFO, "Click on Create");
 
    
    Commons.enter(test,driver,By.id("code"),data);
    Commons.enter(test,driver,By.id("name"),data);
    Commons.enter(test,driver,By.id("descr"),data);
    test.log(Status.INFO, "Enters Description");
        
	Commons.create(test,driver);
	Commons.filter(test,driver, By.id("name"), data);
	

	Commons.edit(test,driver,data+1,By.id("name"));
	Commons.filter(test,driver, By.id("name"), data+1);
	
	Commons.activate(test,driver);
	test.log(Status.INFO, "Click on Active");
	Commons.edit(test,driver,data+2,By.id("name"));
	Commons.filter(test,driver, By.id("name"), data+2);
	Commons.deactivate(test,driver);
	test.log(Status.INFO, "Click on Deactive");

    }
}

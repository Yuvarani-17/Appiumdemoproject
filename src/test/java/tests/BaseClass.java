package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	static AndroidDriver<AndroidElement> driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
				
		File appDir = new File("src/test/resources/apps");
		File app = new File(appDir, "ApiDemos-debug.apk");		
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "yuvaemulator");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);	
	System.out.println("Setting up your app");
	}
	
	@Test
	public void scrl() 
	
	{
		//AndroidDriver driver = new AndroidDriver(capabilitites);
		
	AndroidElement vw = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
	vw.click();
	AndroidElement scrl = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"));");
	scrl.click();
	AndroidElement txt = driver.findElement(By.id("[@text=TextFields"));
	}
	
	
//	public void endup()
//	{
//		System.out.println("Your application is done");
//	}
//	
	
	@AfterClass
	public static void screenshot() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		//File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
		Thread.sleep(3000);
		TakesScreenshot tk=(TakesScreenshot)driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		File to=new File("C:\\eclipse-workspace\\Appiumdemoproject\\src\\test\\resources\\Screenshot\\defectss.png");
		FileUtils.copyFile(from, to);
	}
	
}

package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class B1 {
	AndroidDriver<AndroidElement> driver;



	@BeforeClass
	private void beforeclass() throws Exception {



	File apir = new File("src/test/resources");
	File app = new File(ClassLoader.getSystemResource("ApiDemos-debug.apk").getFile());



	DesiredCapabilities cap = new DesiredCapabilities();



	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");



	driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("Beforeclass");


	}


	@BeforeMethod
	private void beforemethod() {
	//Date d = new Date();
	//System.out.println("starting time" + d);
	System.out.println("Beforemethod");


	}

	@Test
	private void test() {
	AndroidElement viewbtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
	viewbtn.click();
	AndroidElement gg = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"));");
	gg.click();


	// new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView3\"));");
	System.out.println("Test");

	}

	@AfterMethod
	private void aftermethod() {
	//Date d = new Date();
	//System.out.println("Ending time" + d);
	System.out.println("Aftermethod");

	}

	@AfterClass
	private void afterclass() {
	// driver.quit();
	System.out.println("Afterclass");

	}
}


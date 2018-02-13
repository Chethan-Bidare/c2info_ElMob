package c2info_ElMob.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static AndroidDriver<WebElement> driver ;
	
	
	
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public void DeviceCapabilities() throws MalformedURLException{
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"ANDROID");
		capabilities.setCapability(CapabilityType.VERSION,"5.1");
		capabilities.setCapability("deviceName","ZX1D64CPT2");
		capabilities.setCapability("platformName","ANDROID");
		capabilities.setCapability("appPackage","com.c2info.ecolite");
		capabilities.setCapability("appActivity","com.c2info.ecolite.ui.activity.SplashScreenActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//return new LoginPage();
		
		
	}
	
	public void hideKeyboard(){
		driver.hideKeyboard();
	}

}

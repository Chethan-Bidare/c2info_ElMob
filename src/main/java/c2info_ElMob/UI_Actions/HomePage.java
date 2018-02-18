package c2info_ElMob.UI_Actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import c2info_ElMob.TestBase.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath=".//*[@class='android.support.v7.app.ActionBar$Tab' and @index='0']")
	WebElement SalesTab ;
	
	@FindBy(xpath=".//*[@class='android.support.v7.app.ActionBar$Tab' and @index='1']")
	WebElement PurchaseTab ;
	
	@FindBy(xpath=".//*[@class='android.support.v7.app.ActionBar$Tab' and @index='2']")
	WebElement MyStoreTab ;
	
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale_return")
	WebElement salesReturnCheckbox ;
	
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox ;
	
	@FindBy(xpath=".//*[@id='com.c2info.ecolite:id/btnReports' and contains(text(),'Sales Reports')]")
	WebElement salesreportButton ;
	
	@FindBy(id="com.c2info.ecolite:id/autocomplete_customer")
	WebElement customerName ;
	
	@FindBy(id="com.c2info.ecolite:id/btnStartBilling")
	WebElement startButton ;
	
	/*@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox*/
	
	public HomePage(AndroidDriver<WebElement> driver){
		PageFactory.initElements(driver, this);
	}
	
	public void tapOnPurchaseTab(){
		PurchaseTab.click();
	}
	
	public void tapOnSalesTab(){
		SalesTab.click();
	}
	
	public void tapOnMyStoreTab(){
		MyStoreTab.click();
	}
	
	public void selectSalesreturnCheckbox(){
		salesReturnCheckbox.click();
	}
	
	public void selectSalesCheckbox(){
		salescheckbox.click();
	}
	
	public void enterCustomerName(String custName) throws InterruptedException{
		customerName.clear();
		customerName.sendKeys(custName);
		customerName.clear();
		customerName.sendKeys(custName);
		Thread.sleep(5000);
		int x = customerName.getLocation().getX();
		int y = customerName.getLocation().getY();
		TouchAction action = new TouchAction(driver).tap(x+100, y+100).release();
		action.perform();
		
		
	}
	
	public void tapOnSalesReports(){
		salesreportButton.click();
	}
	
	public void tapOnStartButton(){
		startButton.click();
	}
	
	
}

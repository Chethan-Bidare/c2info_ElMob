package c2info_ElMob.UI_Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import c2info_ElMob.TestBase.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Sales extends TestBase{

	
	public Sales(AndroidDriver<WebElement> driver){
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="com.c2info.ecolite:id/etGlobalSearch")
	WebElement itemSearch ;
	
	@FindBy(xpath="")
	WebElement batchNo ;
	
	/*@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox
	@FindBy(id="com.c2info.ecolite:id/radio_new_sale")
	WebElement salescheckbox*/
	
	public ArrayList<String> getItemName(){
	List<WebElement> items = driver.findElementsById("com.c2info.ecolite:id/textview_itemname");
	ArrayList<String> itemNames = new ArrayList<String>();
	for(WebElement we : items){
		String itemName = we.getText().toString().trim();
		itemNames.add(itemName);
		
	}
	System.out.println(itemNames);
	return itemNames ;
	}
	
	public HashMap<String, Float> getItemNamesWithPrice(){
		List<WebElement> itemrates = driver.findElementsById("com.c2info.ecolite:id/textview_rate");
		HashMap<String, Float> itemNamesWithPrice = new HashMap<String, Float>();
		ArrayList<Float> rates = new ArrayList<Float>();
		for(WebElement we : itemrates){
			String itemrate = we.getText().toString().trim();
			//itemrate = itemrate.substring(1);
			itemrate = itemrate.replace("\u20B9", "");
			float itemRate = Float.parseFloat(itemrate);
			rates.add(itemRate);
		}
		System.out.println(rates);
		ArrayList<String> itemNames = getItemName();
		itemNames.remove(itemNames.size()-1);
		System.out.println(itemNames);
		for(int i=0; i<itemNames.size();i++){
			itemNamesWithPrice.put(itemNames.get(i), rates.get(i));
		}
		System.out.println(itemNamesWithPrice);
		return itemNamesWithPrice ;
		
		
	}
	
	public HashMap<String, Integer> getItemNamesWithStock(){
		List<WebElement> itemStk = driver.findElementsById("com.c2info.ecolite:id/textview_itemcount");
		HashMap<String,Integer> itemStock = new HashMap<String, Integer>();
		ArrayList<String> itemNames = getItemName();
		itemNames.remove(itemNames.size()-1);
		System.out.println(itemNames);
		int index = 0;
		for(WebElement we : itemStk){
			String val = we.getText().toString();
			val = val.substring(1);
			int value = Integer.parseInt(val);
			itemStock.put(itemNames.get(index), value);
			index=index+1;
		}
		System.out.println(itemStock);
		return itemStock ;
	}
	
	public void tapOnTabOptionsInSales(String options){
		if(options.equalsIgnoreCase("favourites")){
			driver.findElementByXPath(".//*[@class='android.support.v7.app.ActionBar$Tab' and @index=1]").click();
		}
		else if(options.equalsIgnoreCase("Old Invoice")){
			driver.findElementByXPath(".//*[@class='android.support.v7.app.ActionBar$Tab' and @index=2]").click();
		}
		else if(options.equalsIgnoreCase("Priority")){
			driver.findElementByXPath(".//*[@class='android.support.v7.app.ActionBar$Tab' and @index=0]").click();
		}
	}
	
	public void searchByItemName(String itemName){
		itemSearch.clear();
		itemSearch.sendKeys(itemName);
		
	}
	
	public void selectBatchByName(String batchNo){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(driver.findElement(By.xpath(".//android.widget.TextView[@text='"+batchNo+"')]")));
		//@id='com.c2info.ecolite:id/text_Batch_No' and 
		touchAction.perform();
	}
	
	public void selectItemByName(String itemName){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(driver.findElement(By.xpath(".//android.widget.TextView[@text='"+itemName+"')]")));
		//@id='com.c2info.ecolite:id/textview_itemname' and 
		touchAction.perform();
	}
	
}

package c2info_ElMob.UI_Actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import c2info_ElMob.TestBase.TestBase;

public class Sales extends TestBase{

	
	

	/*@FindBy(id="com.c2info.ecolite:id/textview_itemname")
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
	
}

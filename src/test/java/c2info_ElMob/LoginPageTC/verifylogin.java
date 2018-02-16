package c2info_ElMob.LoginPageTC;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import c2info_ElMob.TestBase.TestBase;
import c2info_ElMob.UI_Actions.HomePage;
import c2info_ElMob.UI_Actions.LoginPage;
import c2info_ElMob.UI_Actions.Sales;

public class verifylogin extends TestBase{

	@BeforeClass
	public void openAPP() throws MalformedURLException{
		DeviceCapabilities();
	}
	
	@Test(priority=0)
	public void login() throws InterruptedException{
		LoginPage lp = new LoginPage();
		lp.doLogin("8147519664", "224488");
		Assert.assertEquals(lp.getHomepageTitle(), "Home");
	}
	
	@Test(priority=1)
	public void tabcheck() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		//hp.tapOnPurchaseTab();
		//hp.tapOnMyStoreTab();
		//hp.tapOnSalesTab();
		//hp.selectSalesreturnCheckbox();
		//hp.selectSalesCheckbox();
		//hp.enterCustomerName("v");
		hp.tapOnStartButton();
		hideKeyboard();
		Thread.sleep(2000);
		Sales sales = new Sales(driver);
		//sales.tapOnTabOptionsInSales("Old invoice");
		sales.searchByItemName("A Gen 5 D data");
		Thread.sleep(2000);
		sales.clickOnSearchedItem();
		hideKeyboard();
		/*Thread.sleep(3000);
		sales.increaseQty(4);
		hideKeyboard();*/
		swipeUpInBatchList();
		System.out.println(sales.getBatchesWithPrice());
	}
	
}

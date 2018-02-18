package c2info_ElMob.LoginPageTC;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import c2info_ElMob.TestBase.TestBase;
import c2info_ElMob.UI_Actions.HomePage;
import c2info_ElMob.UI_Actions.LoginPage;
import c2info_ElMob.UI_Actions.Sales;
import c2info_ElMob.UI_Actions.SalesCartPage;

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
		Sales sales = new Sales(driver);
		SalesCartPage salesCart = new SalesCartPage(driver); 
		//hp.tapOnPurchaseTab();
		//hp.tapOnMyStoreTab();
		//hp.tapOnSalesTab();
		//hp.selectSalesreturnCheckbox();
		//hp.selectSalesCheckbox();
		//hp.enterCustomerName("v");
		hp.tapOnStartButton();
		hideKeyboard();
		Thread.sleep(2000);
		
		//sales.tapOnTabOptionsInSales("Old invoice");
		salesCart.clickOnCustIconInCartPage();
		sales.searchByCustomerName("veena");
		Thread.sleep(3000);
		sales.clickOnSearchedCustomer();
		Thread.sleep(3000);
		sales.searchByItemName("A Gen 5 D data");
		Thread.sleep(2000);
		sales.clickOnSearchedItem();
		hideKeyboard();
		sales.clickOnAddButton();
		sales.searchByItemName("ajith");
		Thread.sleep(2000);
		sales.clickOnSearchedItem();
		hideKeyboard();
		sales.clickOnAddButton();
		Thread.sleep(2000);
		int noOfItems = salesCart.getCountOfItemsAddedToCart();
		System.out.println(noOfItems);
		System.out.println(salesCart.getCartTotal());
		salesCart.clickOnCartPage();
		//HashMap<String,Float> batchWithPrice = sales.getBatchesWithPrice();
		/*Thread.sleep(3000);
		sales.increaseQty(4);
		hideKeyboard();*/
		/*batchWithPrice.putAll(sales.getBatchesWithPrice());
		swipeUpInBatchList();
		batchWithPrice.putAll(sales.getBatchesWithPrice());
		swipeUpInBatchList();
		batchWithPrice.putAll(sales.getBatchesWithPrice());
		System.out.println(batchWithPrice);*/
		System.out.println(salesCart.getCalculatedItemWiseTotalWithItemName());
		salesCart.clickOnAddNewItemFromCartPage();
		sales.searchByItemName("321321");
		Thread.sleep(2000);
		sales.clickOnSearchedItem();
		hideKeyboard();
		sales.clickOnAddButton();
		Thread.sleep(2000);
		salesCart.clickOnGetPayment();
	}
	
}

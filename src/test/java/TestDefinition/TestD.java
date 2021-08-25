package TestDefinition;

//import java.awt.List;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.base;
import ObjectRepository.Object;
import java.util.List;


public class TestD extends base<java.lang.Object> {
	
	
	
	
	
	
	
        @Given("I add four different products to my wish list")
		public void i_add_four_different_products_to_my_wish_list() throws IOException {
        	
        	driver=initializeDriver();
	        driver.get("https://testscriptdemo.com/");
			System.out.println("The Webpage Title is "+ driver.getTitle());
			Object rd=new Object(driver);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.manage().window().maximize();
			
			
			
			rd.PopUp().click();
			
			rd.FirstProduct().click();
			rd.SecondProduct().click();
			
			WebElement element = rd.ThirdProduct(); 
			Actions actions =new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			
			rd.ThirdProduct().click();
			rd.FourthProduct().click();
			System.out.println("All the products are added to the wishlist");
		
			
		}

		@When("I view my wishlist table")
		public void i_view_my_wishlist_table() {
			Object rf =new Object(driver);
			rf.ClickWishList().click();
			System.out.println("wishlist is clicked");
		}
		
		@Then("I find total four selected items in my wishlist")
		public void i_find_total_four_selected_items_in_my_wishlist() throws InterruptedException {
			Object rz=new Object(driver);
			List<WebElement> myList = rz.returnsizeofproducts();
            System.out.println("Total Number of items in the wishlist is " + myList.size());
			
	 
		}

		@When("I search for lowest price product")
		public void i_search_for_lowest_price_product() throws InterruptedException  {
			
			Object ra=new Object(driver);
			int minPrice = ra.MinimumPrice();
			System.out.println("Lowest price is"+ " " + minPrice + " " + "Pounds from the above list");
		}
	
		@And("I am able to add the lowest price item to my cart")
	
			public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws InterruptedException {
			Object rs=new Object(driver);
			rs.AddtoCart();
			
		}			
	
		@Then("I am able to verify the item in my cart")
		public void i_am_able_to_verify_the_item_in_my_cart() throws InterruptedException {
			
			Object rh =new Object(driver);
			rh.ClickVerifyCart().click();
			String finalproduct = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/div/form/table/tbody/tr[1]/td[3]/a")).getText();
			System.out.println("The Selected product is " + " " + finalproduct + " " + " And it is verified in the cart");
			
		}
}	
			
		
		    
		
		

	



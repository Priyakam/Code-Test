package ObjectRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Object {

	
		
		WebDriver driver;
		
		public Object(WebDriver driver) 
		{
			this.driver=driver;
		}
		
		By popup=By.xpath("//*[@id=\'cc-window\']/div[5]/a[1]");
		By firstProduct=By.xpath("/html/body/div[3]/div[3]/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[2]/div/div[2]/div/div/a/i");
		By SecondProduct=By.xpath("/html/body/div[3]/div[3]/div/div/div/div/section[4]/div/div/div/div/div/div/div/ul/li[3]/div/div[2]/div/div/a/i");
		By ThirdProduct=By.xpath("/html/body/div[3]/div[3]/div/div/div/div/section[6]/div/div/div/div/div/div/div[2]/div[2]/div/ul/li[1]/div/div[2]/div/div/a/i");
		By MenCloth =By.xpath("/html/body/div[3]/div[3]/div/div/div/div/section[6]/div/div/div/div/div/div/div[1]/div[2]");
		By FourthProduct=By.xpath("/html/body/div[3]/div[3]/div/div/div/div/section[6]/div/div/div/div/div/div/div[2]/div[4]/div/ul/li[3]/div/div[2]/div/div/a/i");
		By WishList =By.xpath("/html/body/div[3]/div[1]/div/div/div[3]/div[3]/a/i");
		By AddtoCart= By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr[2]/td[6]/a");
		By VerifyCart = By.xpath("/html/body/div[2]/div[1]/div/div/div[3]/div[1]/div/div/a/i");

		
		
		public WebElement PopUp()
		{
			return driver.findElement(popup);
		}
		public WebElement FirstProduct()
		{
			return driver.findElement(firstProduct);
		}
		
		public WebElement SecondProduct()
		{
			return driver.findElement(SecondProduct);
		}

		public WebElement ThirdProduct()
		{
			return driver.findElement(ThirdProduct);
		}

		public WebElement FourthProduct()
		{
			driver.findElement(MenCloth).click();
			return driver.findElement(FourthProduct);
		}

		public WebElement ClickWishList()
		{
			return driver.findElement(WishList);
		}
		
		
		
		public WebElement ClickAddCart()
		{
			return driver.findElement(AddtoCart);
		}
		
		

		public WebElement ClickVerifyCart()
		{
			
			return driver.findElement(VerifyCart);
		}
		
		public List<WebElement> returnsizeofproducts()
		{
			List<WebElement> myList = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr[*]/td[4]/ins/span/bdi"));
		    return myList;
		    
		}

		public int MinimumPrice()
		{
			
			List<WebElement> myList = returnsizeofproducts();        
				 ArrayList<Integer> priceList = new ArrayList<Integer>();
				 for(int i=0;i<myList.size();i++) 
				 {
					 String value = myList.get(i).getText();
					 value = value.replace("£", "").replace(".00", "");
					 Integer priceInt = Integer.valueOf(value);
					 priceList.add(priceInt);
				 }
				 Integer minPrice = Collections.min(priceList);	
				 return minPrice;
		}
		
		public void AddtoCart() throws InterruptedException
		{
			int minPrice = MinimumPrice();
			List<WebElement> myList = returnsizeofproducts();
	
	            List<WebElement> addToCart =driver.findElements(By.xpath("/html/body/div[2]/div[3]/div/div/article/div/div/div[1]/form/table/tbody/tr[*]/td[6]/a"));
				Thread.sleep(3000);
				for (int i=0;i<myList.size();i++) 
				{
					
					String value1 = myList.get(i).getText();
					 value1 = value1.replace("£", "").replace(".00", "");
					 Integer priceInt1 = Integer.valueOf(value1);
					 if(priceInt1.equals(minPrice) )
						{
							addToCart.get(i).click();
							System.out.println("Lowest priced product is added to the cart succesfully");
						    break;
						}
					 
				}	 
				
				if(driver.getPageSource().contains("Product added to cart successfully"))
				{
					System.out.println("The Text : Product added to cart Succesfully is verified");
				}	
				Thread.sleep(3000);
				
		}
}
			    
				
				
				
				
				
				
			
				
		    
	


	


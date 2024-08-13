package sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllCode {
	@Test
	public void codes() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver. get("https://www.ajio.com/");
		String parentWin= driver.getWindowHandle();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//////////
		
		Actions act = new Actions(driver);
		WebElement menSec=driver.findElement(By.xpath("//span[text()='MEN']"));
		WebElement menShirt=driver.findElement(By.xpath("//a[text()='Shirts'][1]"));
		act.moveToElement(menSec).perform();
		menShirt.click();
		/////
		WebElement genderSel= driver.findElement(By.cssSelector("[class*='-genderfilter facet-linkname-Men']"));
		genderSel.click();		
		WebElement brand=driver.findElement(By.cssSelector("[aria-label='brands']"));
		brand.click();
		
		//not used in pom++++++++++++++++++++++++++++++++
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(brand));
		//+++++++++++++++++++++++++++
		
		WebElement brandMore=driver.findElement(By.xpath("//strong[text()='MORE']"));
		brandMore.click();
		//////////////////////////////////
		
		
		///++++++++++++++++++++++
		List<WebElement> allBrand =driver.findElements(By.xpath("//div[@class='facet-filter-modal__search-alp-container'] //button[@class='rilrtl-button'] /div"));
		for (WebElement particularBrand : allBrand) {
			if ( particularBrand.getText().equalsIgnoreCase("T")){
				WebElement a=driver.findElement(By.xpath("//label[@for='modal-TOMMY HILFIGER']"));
				a.click();}
			if ( particularBrand.getText().equalsIgnoreCase("I")){
				WebElement i=driver.findElement(By.xpath("//label[@for='modal-INDIAN TERRAIN']"));
				i.click();}
			if ( particularBrand.getText().equalsIgnoreCase("G"))	{
				WebElement n=driver.findElement(By.xpath("//label[@for='modal-Gant']"));
				n.click();}
			if ( particularBrand.getText().equalsIgnoreCase("S"))	{
				WebElement s=driver.findElement(By.xpath("//label[@for='modal-SIN']"));
				s.click();}
			if ( particularBrand.getText().equalsIgnoreCase("U"))	{
				WebElement u=driver.findElement(By.xpath("//label[@for='modal-UNITED COLORS OF BENETTON']"));
				u.click();	}	}
		//++++++++++++++++++++++++++
		//////////////////
		WebElement brandApply=driver.findElement(By.cssSelector("[aria-label='Apply']"));
		brandApply.click();
		Thread.sleep(2400);
		WebElement collar=driver.findElement(By.xpath("//div[@class='facet-advanced-filter-block']/ul/li[5]"));
////1		wait.until(ExpectedConditions.visibilityOf(collar));
		collar.click();
		WebElement bandCollar=driver.findElement(By.xpath("//div[@class='facet-linkhead']//label[@for='Band']"));
		bandCollar.click();
		
		Thread.sleep(5400);
		
		WebElement sort=driver.findElement(By.id("sortBy"));
//////////////////
		//++++++++
		Select s = new Select(sort);
		s.selectByVisibleText("Price (highest first)");
		Thread.sleep(2000);
		//++++++++++++++
		List<WebElement> allShirts= driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer'] //a"));
		for (WebElement aShirt : allShirts) {	
			String url =aShirt.getAttribute("href");
			if(url.contains("/tommy-hilfiger-tjm-mao-striped-linen-blend-shirt/p/469587300_blue"))
			{aShirt.click();
			driver.switchTo().window(parentWin);}	
			
			if(url.contains("/gas-mohr-checked-slim-fit-shirt/p/410244691_ck25"))
			{aShirt.click();
			driver.switchTo().window(parentWin);}
			}
		Thread.sleep(2000);
		
		Set <String>handles= driver.getWindowHandles();
		List<String> l= new ArrayList<String>(handles);
		driver.switchTo().window(l.get(1));
		WebElement firstShirtSize=driver.findElement(By.xpath("//span[text()='L']"));
		firstShirtSize.click();
		WebElement addToBag1=driver.findElement(By.xpath("//*[text()='ADD TO BAG']"));
		addToBag1.click();
		
		driver.switchTo().window(l.get(2));
		WebElement secShirtSize=driver.findElement(By.xpath("//span[text()='M']"));
		secShirtSize.click();
		WebElement addToBag2=driver.findElement(By.xpath("//*[text()='ADD TO BAG']"));
		addToBag2.click();
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
		WebElement cart=driver.findElement(By.cssSelector("[aria-label='cart icon']"));
		cart.click();
		
		WebElement items=driver.findElement(By.cssSelector("span[aria-label='items']"));
		String orderValue= items.getText();
		System.out.println(orderValue);
		char cartValue=	orderValue.split("items")[0].trim().charAt(1);
	//	int cartValueInt= (int)cartValue;
		System.out.println(cartValue);
		WebElement shipping=driver.findElement(By.cssSelector("[aria-label='Proceed to shipping']"));
		shipping.click();
		}
	}

	


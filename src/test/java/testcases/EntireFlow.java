package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pom.Buying;
import pom.Filtering;
import pom.MensSection;

public class EntireFlow extends BaseTestCases {
	
	@Test
	public void part1() throws InterruptedException{

		MensSection mensSection = new MensSection(driver);
		mensSection.shirtSelection();
		Filtering filtering= new Filtering(driver);
		filtering.genderSel();
		filtering.brand();
		filtering.brandMore();
		filtering.brandSelect();
		filtering.brandApply();
		filtering.occasion();
		filtering.occasionType();
		filtering.sortProcess();	
	}
	@Test(dependsOnMethods = "part1")
	public void part2() throws InterruptedException {
		Buying buying = new Buying(driver);
		for (WebElement aShirt : buying.allShirts()) {	
			String url =aShirt.getAttribute("href");
			if(url.contains(prop.getProperty("shirt1")))
			{aShirt.click();
			parentWindow();}	
			
			if(url.contains(prop.getProperty("shirt2")))
			{aShirt.click();
			parentWindow();}
			}
		Thread.sleep(2000);
		gettingWinHand();
		otherWindow(1);
		buying.shirtSize();
		buying.addToBag();
		otherWindow(2);
		buying.shirtSize();
		buying.addToBag();
		parentWindow();
		buying.cart();
		buying.items();
		buying.shipping();
	}
}

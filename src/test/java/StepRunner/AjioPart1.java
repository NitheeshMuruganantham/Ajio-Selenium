package StepRunner;


	import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Buying;
	import pom.Filtering;
	import pom.MensSection;
	import testcases.BaseTestCases;

	public class AjioPart1 extends BaseTestCases{

		MensSection mensSection;
		Filtering filtering ;
		Buying buying;

		
		
		@Given("selecting the mens section, gender, brands, Sorting")
		public void selecting_the_mens_section_gender_brands_sorting() throws IOException, InterruptedException {
			opening();
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

		@Given("Choosing two shirts")
		public void choosing_shirts(Integer int1) throws InterruptedException {
		    buying = new Buying(driver);
			for (WebElement aShirt : buying.allShirts()) {	
				String url =aShirt.getAttribute("href");
				if(url.contains(prop.getProperty("shirt1")))
				{aShirt.click();
				parentWindow();}	
				
				if(url.contains(prop.getProperty("shirt2")))
				{aShirt.click();
				parentWindow();}
				}
			
		}

		@When("Placing the order")
		public void placing_the_order() throws InterruptedException {
			
			Thread.sleep(2000);
			gettingWinHand();
			otherWindow(1);
			Thread.sleep(500);
			buying.shirtSize();
			buying.addToBag();
			otherWindow(2);
			Thread.sleep(500);
			buying.shirtSize();
			buying.addToBag();
			parentWindow();
			
		}

		@Then("Proceed shipping and Checkings its asking Mobile Number")
		public void check_its_asking_mobile_number() throws InterruptedException {
			buying.cart();
			buying.items();
			buying.shipping();
			Assert.assertEquals(buying.mobNum(), "Enter Mobile Number *");
			closing();
		}


	}


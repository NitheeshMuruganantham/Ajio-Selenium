package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buying extends BasePom {

	WebDriver driver;
	public Buying(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='ReactVirtualized__Grid__innerScrollContainer'] //a")
	List<WebElement> allShirtsSel;
	@FindBy(xpath="//span[text()='S']")
	WebElement shirtSizeBut;
	@FindBy(xpath="//*[text()='ADD TO BAG']")
	WebElement addToBagBut1;
	@FindBy(css="[aria-label='cart icon']")
	WebElement cartBut;
	@FindBy(css="span[aria-label='items']")
	WebElement itemsBut;
	@FindBy(css="[aria-label='Proceed to shipping']")
	WebElement shippingBut;
	@FindBy(xpath="//label[text()='Enter Mobile Number *']")
	WebElement conMobnum;
	
	
	
	public List<WebElement> allShirts() throws InterruptedException {
		Thread.sleep(2000);
		return allShirtsSel;
	}	
	public void shirtSize() {
		shirtSizeBut.click();
	}
	public void addToBag() {
		 addToBagBut1.click();
	}
	public void cart() throws InterruptedException {
		Thread.sleep(2000);
		//waitElement(cartBut);
		cartBut.click();
	}
	public void items() {
		String itemsValue= itemsBut.getText();
		System.out.println(itemsValue);
	}
	public void shipping() {
		shippingBut.click();
	}	
	
	public String mobNum() {
		String monNUMValue= conMobnum.getText();
		return monNUMValue;
		
	}
	
	
}
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensSection extends BasePom {

	WebDriver driver;
	public MensSection(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//span[text()='MEN']")
	WebElement menSec;
	
	@FindBy(xpath="//a[text()='Shirts'][1]")
	WebElement menShirt;

	public void  shirtSelection() {
		Actions act = new Actions(driver);
		act.moveToElement(menSec).perform();
		menShirt.click();
		
	}
	
	
	
}

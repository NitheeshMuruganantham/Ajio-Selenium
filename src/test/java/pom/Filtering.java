package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filtering extends BasePom{

	WebDriver driver;
	public Filtering(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="[class*='-genderfilter facet-linkname-Men']")
	WebElement gender;
	@FindBy(css="[aria-label='brands']")
	WebElement brandbutton;
	@FindBy(xpath="//strong[text()='MORE']")
	WebElement brandMorebutton;
	
	@FindBy(xpath="//div[@class='facet-filter-modal__search-alp-container'] //button[@class='rilrtl-button'] /div")
	List<WebElement> allBrandbut;
	@FindBy(xpath="//label[@for='modal-TOMMY HILFIGER']")
	WebElement tombut;
	@FindBy(xpath="//label[@for='modal-INDIAN TERRAIN']")
	WebElement inBut;
	@FindBy(xpath="//label[@for='modal-Gant']")
	WebElement gaBut;
	@FindBy(xpath="//label[@for='modal-SIN']")
	WebElement siBut;
	@FindBy(xpath="//label[@for='modal-UNITED COLORS OF BENETTON']")
	WebElement ucbBut;
	
	@FindBy(css="[aria-label='Apply']")
	WebElement brandApplyBut;
	@FindBy(xpath="//span[text()='occasion']")
	WebElement occBut;
	@FindBy(xpath="//label[@for='Casual']")
	WebElement occTypeBut;
	@FindBy(id="sortBy")
	WebElement sortBut;

	
	
	
	
	public void genderSel() {
		gender.click();
	}

	public void brand() throws InterruptedException {
		Thread.sleep(2000);
		brandbutton.click();
	}
	public void brandMore() throws InterruptedException {
		Thread.sleep(2000);
		brandMorebutton.click();
	}
	public List<WebElement> allBrand() {

		return allBrandbut;
	}
	public void tommy() {
		tombut.click();
	}
	public void indianTer() {
		inBut.click();
	}
	public void gant() {
		gaBut.click();
	}
	public void sin() {
		siBut.click();
	}
	public void ucb() {
		ucbBut.click();
	}

	
	public void brandSelect() {
		for( WebElement particularBrand:allBrand() ) {
			if ( particularBrand.getText().equalsIgnoreCase("T")){
				tombut.click();}
			if ( particularBrand.getText().equalsIgnoreCase("I")){		
				inBut.click();}
			if ( particularBrand.getText().equalsIgnoreCase("G"))	{
				gaBut.click();}
			if ( particularBrand.getText().equalsIgnoreCase("S"))	{
				siBut.click();}
			if ( particularBrand.getText().equalsIgnoreCase("U"))	{
				ucbBut.click();}
		}
	}
	public void brandApply() {
		brandApplyBut.click();
	}
	
	public void occasion() throws InterruptedException {

		Thread.sleep(3000);
		occBut.click();
	}
	public void occasionType() throws InterruptedException {
		//waitElement(bandCollarBut);
		Thread.sleep(2000);
		occTypeBut.click();
	}
	
	public void sortProcess() throws InterruptedException {
		Thread.sleep(2000);
		Select s = new Select(sortBut);
		s.selectByVisibleText("Price (highest first)");
	
	}
	
	
}

package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestCases {

	
public WebDriver driver;
public String parentWin;
public List<String> l;
public Properties prop;


	public void driverPick() throws IOException {
		 prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}
		driver. get(prop.getProperty("url"));
		parentWin= driver.getWindowHandle();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	@BeforeClass
	public void opening() throws IOException {
		driverPick();
	}
	
	public void parentWindow()
	{
		driver.switchTo().window(parentWin);
	}
	public void otherWindow(int i)
	{
		driver.switchTo().window(l.get(i));
	}
	
	public List<String> gettingWinHand() {
		Set <String>handles= driver.getWindowHandles();
		l= new ArrayList<String>(handles);
		return l;
	}
	
	@AfterClass
	public void closing() throws InterruptedException {
		Thread.sleep(2000);;
		driver.quit();
		
		
}
	
	
	
	
	
	
	
	
	
	
}

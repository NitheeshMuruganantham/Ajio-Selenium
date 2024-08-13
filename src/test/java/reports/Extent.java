package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent {

	public static ExtentReports getExtent() {
	String path= System.getProperty("user.dir")+ "//extreports//index.html";
	ExtentSparkReporter extentspark = new ExtentSparkReporter(path);
	extentspark.config().setDocumentTitle("AjioReport");

	ExtentReports ex = new ExtentReports();
	ex.attachReporter(extentspark);
	return ex;
	
	}

	
	
	
	
	
	
	
	
	
	
	
}

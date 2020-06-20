package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager
{
public static ExtentReports report;  //This will actually create the report 
	
	
	public static ExtentReports getReportInstance()
	{
		if(report == null)                            //Check if report already is there. If yes -> return report else create new Report
		{
			String reportName = "TestOutput_" + DateUtils.getTimeStamp() +".html";
			
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/" +reportName);
		   
			 report = new ExtentReports();
			 report.attachReporter(htmlReporter);
			 
			 //You can also define here system level  properties 
			 report.setSystemInfo("OS", "MAC");
			 report.setSystemInfo("Browser","Chrome, Firefox");
			 report.setSystemInfo("Enviornment","UAT");

			 htmlReporter.config().setDocumentTitle("Test results");
			 htmlReporter.config().setReportName("The Bug Slayers");
			 
			 
		}
		return report;
	}
}


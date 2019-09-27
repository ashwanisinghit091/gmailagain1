package Base_Pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Base {
public 	static 	WebDriver Driver;
public 	static String Browser;
public 	static Properties pr;
	@BeforeClass
	public static void Invoke_Browser() throws IOException {
		
		pr=new Properties();
		//File f=new File("");
		FileInputStream fs=new 	FileInputStream("D:\\workspace11\\Naukkri\\Resources\\Data.properties");
		pr.load(fs);
		System.out.println(pr.getProperty("Browser"));
		Browser=pr.getProperty("Browser");
		System.out.println(Browser);
	
		if(Browser.contains("chrome")) {
	System.out.println("abc");
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		 Driver=new ChromeDriver();
		
		Driver.get("https://www.naukri.com");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		}
		
		else if(Browser.contains("Firefox")){
		
		//System.setProperty("weriver.driver.geckodriver", "D://geckodriver.exe");
		 Driver=new FirefoxDriver();
		
		Driver.get("https://www.naukri.com");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);}	
		
	
else {
		
		System.setProperty("webdriver.InternetExplorer.Driver.", "D://IEDriverServer.exe");
		 Driver=new InternetExplorerDriver();
		
		Driver.get("https://www.naukri.com");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);}

}
	
	public static void screen() throws IOException {
		
		
		File src=(( TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://screen1.png"));
		
		
	}
}

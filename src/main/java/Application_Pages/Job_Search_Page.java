





package Application_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Job_Search_Page {
public static WebDriver Driver;
	

	public Job_Search_Page(WebDriver Driver){
		this.Driver=Driver;
	}
	
	
	
	By Job_Search= By.cssSelector(".sugInp");
	
	public WebElement Job_Search() {
	return	Driver.findElement(Job_Search);
	}
	
}



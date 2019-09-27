package Application_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Landing_Page {
	
	public static WebDriver Driver;
	
public Landing_Page(WebDriver Driver){
	this.Driver=Driver;
}

	
	By Login=By.cssSelector("#login_Layer");
	
	
	
	public WebElement Login() {
		return Driver.findElement(Login);
	}

}




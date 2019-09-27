package Application_Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

	
	public static WebDriver Driver;
	
public Login_Page(WebDriver Driver){
	this.Driver=Driver;
	
}
	By Username= By.cssSelector("#eLoginNew");
	By Password=By.cssSelector("#pLogin");
	By Button=By.cssSelector("#lgnFrmNew  button:nth-child(1)");
	By Jobs=By.className("mTxt");
	
	
	public WebElement Jobs() {
		return Driver.findElement(Jobs);
	}
	
	public WebElement Username() {
		return Driver.findElement(Username);
	}
	
	public WebElement Password() {
		return Driver.findElement(Password);
	}


	public WebElement Button() {
		return Driver.findElement(Button);
	}
	
	
}

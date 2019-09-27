package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
public static void screen(WebDriver Driver) throws IOException {
	
	
	File src=(( TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D://screen.png"));
	
	
}


}

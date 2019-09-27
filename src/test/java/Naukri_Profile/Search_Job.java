package Naukri_Profile;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import Application_Pages.Job_Search_Page;
import Application_Pages.Landing_Page;
import Application_Pages.Login_Page;
import Base_Pack.Base;
import Utility.Listeners;
import Utility.Screenshot;

import org.apache.logging.log4j.*;


public class Search_Job extends Base {
                      
	  private static   Logger log  = LogManager.getLogger(Search_Job.class.getName())   ;  
	
	
	@Test
	public static void SearchForJob() throws IOException {
		

		Landing_Page lp=new Landing_Page(Driver);
		

		
		lp.Login().click();
		Login_Page lop=new Login_Page(Driver);
		lop.Username().sendKeys(pr.getProperty("username"));
		lop.Password().sendKeys(pr.getProperty("password"));
		lop.Button().click();
		log.info("successfully login");
		lop.Jobs().click();
		log.info("successfully clicked on job");
		
	Set<String> WindowIds=	Driver.getWindowHandles();
	
	Iterator<String> it=WindowIds.iterator();
	String ParentWindow=it.next();
	String ChildWindow=it.next();
	System.out.println(ChildWindow);
	Screenshot.screen(Driver);
	Driver.switchTo().window(ChildWindow);
	System.out.println(Driver.getTitle());
	Assert.assertEquals(Driver.getTitle(), "Browse Jobs by Company, Location, Skills, Designation & Industry - Naukri.com");
	log.info("Title is validated successfully");
	
	Job_Search_Page jsp=new Job_Search_Page(Driver);
	jsp.Job_Search().click();
	
	jsp.Job_Search().sendKeys(pr.getProperty("Skills"));
	jsp.Job_Search().sendKeys(Keys.ENTER);
	log.info("Results appear successfully");
	
	
	
	
		
		
		
		
		
	}

}

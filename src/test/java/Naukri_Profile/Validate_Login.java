package Naukri_Profile;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Application_Pages.Landing_Page;
import Application_Pages.Login_Page;
import Base_Pack.Base;
import Utility.Read;

public class Validate_Login extends Base{
	
	  private static   Logger log  = LogManager.getLogger(Search_Job.class.getName())   ; 
@Test
	public static void Validate_UserLogin() throws InterruptedException, IOException {
	
	Driver.close();
	
	
	for(int k=1;k<9;k++) {
		Base.Invoke_Browser();
Landing_Page lp=new Landing_Page(Driver);
System.out.println("dfg");

lp.Login().click();
log.info("successfully clicked on login option");
System.out.println("kl");	
//Thread.sleep(4000);
//lp.Login().click();
Login_Page lop=new Login_Page(Driver);
//lop.Username().click();
//lop.Username().sendKeys("ashwani");

Read.ReadFile(lop,Driver,k,log);
}
	
}
}

package Utility;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Application_Pages.Landing_Page;
import Application_Pages.Login_Page;
import Base_Pack.Base;
import Naukri_Profile.Validate_Login;

public class Read extends Base{
static int j1;
static int j2;
static int j3;
static   int Cellnumber;
static int Rownumber;
	
	
	public static void ReadFile(Login_Page lop,WebDriver Driver,int Rownumber1,Logger log) throws IOException, InterruptedException {
		System.out.println(Rownumber1);
		File f=new File("D://acb.xlsx");
		FileInputStream fs=new FileInputStream(f);
		
		XSSFWorkbook xsf=new XSSFWorkbook(fs);
	int Sheetnumber=	xsf.getNumberOfSheets();
	    Sheet s= xsf.getSheet("TestData");
	    
	     Rownumber=s.getPhysicalNumberOfRows();
	    
	    for(int i=0;i<1;i++) {
	    Row r=s.getRow(i);
	    Cellnumber=r.getPhysicalNumberOfCells();
	    for(int j=0;j<Cellnumber;j++) {
	    	Cell c=r.getCell(j);
	    int 	Cell_Type=c.getCellType();
	    	
	    	if(Cell_Type==0) {
	    		
	    		
	    		if(HSSFDateUtil.isCellDateFormatted(c)) {
	    		
	    			//System.out.println(c.getDateCellValue());
	    			
	    			
	    		}
	    		else
	    		{//System.out.println(c.getNumericCellValue());
	    		
	    		}
	    		
	    	}
	    
	    	
	    	else {
	    		//System.out.println(c.getStringCellValue());
	    		String ColumnName=c.getStringCellValue();
	    		if(ColumnName.equalsIgnoreCase("TestType")) {
	    			j1=j;
	    		}
	    			
if(ColumnName.equalsIgnoreCase("Username")) {
	
	j2=j;
	
	    			
	    		}	
	    			

if(ColumnName.equalsIgnoreCase("Password")) {
	
	j3=j;

}
	    	}
	    	
	    }
	    
		
		
		
	    }
		
	    
	    for(int x=Rownumber1;x<Rownumber;x++) {
	    	  Row r=s.getRow(x);
	    	  Cell c=r.getCell(j1);
	    	 // System.out.println(c.getStringCellValue());
	    	  String cellvalue=c.getStringCellValue();
	    	  if(cellvalue.equalsIgnoreCase("ValidUser")) {
	    		  System.out.println("ha bhai");

	    	 Cell c0=r.getCell(j2);
	    	 System.out.println(c0.getStringCellValue());
	    	 lop.Username().sendKeys(c0.getStringCellValue());
	    	
	    	 Cell c1=r.getCell(j3);
	    	 lop.Password().sendKeys(c1.getStringCellValue());
	    	 System.out.println(c1.getStringCellValue());
	    	 lop.Button().click();
	    	 
	    	 if(Driver.findElements(By.xpath("//div[@title='Ashwani Singh']")).size()>0) 
	    	 { System.out.println("Successfully login"+c0.getStringCellValue());
	    	 Thread.sleep(2000);
	    	 Driver.close();
	    	 break;
	    	 }	    	
	    	 else {System.out.println("Failed"+c0.getStringCellValue());
	    	 break;
	    	 }
	    
	}
	    	  else {
	    		  Row r1=s.getRow(x);
		    	  Cell c1=r1.getCell(j1);
		    	 // System.out.println(c.getStringCellValue());
		    	  String cellvalue1=c1.getStringCellValue();
		    	  if(cellvalue1.equalsIgnoreCase("InvalidaUser")) {
		    		  System.out.println("ha bhai");

		    	 Cell c01=r.getCell(j2);
		    	 System.out.println(c01.getStringCellValue());
		    	 lop.Username().sendKeys(c01.getStringCellValue());
		    	 log.info("username entered successfully");
		    	
		    	 Cell c11=r.getCell(j3);
		    	 lop.Password().sendKeys(c11.getStringCellValue());
		    	 log.info("password entered successfully");
		    	 System.out.println(c11.getStringCellValue());
		    	 
		    	 lop.Button().click();
		    	 log.info("clicked on login button");
		    	
		    	System.out.println(Driver.findElements(By.xpath("//div[@title='Ashwani Singh']")).size());
		    	  if(Driver.findElements(By.xpath("//div[@title='Ashwani Singh']")).size()==0)  {
		    		  log.info("successfully switched to next page");
		    		 System.out.println("login testcase pass"+c01.getStringCellValue());
		    		 Thread.sleep(2000);
			    	 Driver.close();
			    	 break;
		    	 }
		    	 
		    	 
		    	 else {System.out.println("failed");
		    	 log.info("Login failed");
		    	 }
		    	
	    		  
	    	  }
	    	 
	    }
	    

	}
	
	}
	
}

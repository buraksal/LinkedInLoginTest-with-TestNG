package LoginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelRead.ExcelDataConfig;

public class LoginTextExcelTest {
	
	//Creating New WebDriver for Chrome
	WebDriver driver;
	
	/**
	 * 
	 * @param username E-Mail that is taken from Excel
	 * @param password Password that is taken from Excel
	 * @throws InterruptedException
	 */
	@Test(dataProvider="LinkedInData")
	public void loginTofacebook(String username, String password) throws InterruptedException {
		
		//Path For Last version of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\Desktop\\Chrome_Driver\\chromedriver.exe");
		//Creating New Chrome Driver
		driver = new ChromeDriver();
		//Maximazing the window that is opened
		driver.manage().window().maximize();
		//20 Secs wait time to timeout if nothing happens
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Declaring which site to enter
		driver.get("https://www.linkedin.com/");
		//ID is gotten from Right Click+Inspect on e-mail section on website
		driver.findElement(By.id("login-email")).sendKeys(username);
		//ID is gotten from Right Click+Inspect on password section on website
	    driver.findElement(By.id("login-password")).sendKeys(password);
	    //ID is gotten from Right Click+Inspect on Login button on website
	    driver.findElement(By.xpath(".//*[@id='login-submit']")).click();
	    //Waiting 5 secs just in case
		Thread.sleep(5000);
	  
		

	    
	}
	//To Close Chrome after Testing Completed
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	//Reading Data From Excel and Storing It
	//Data Provider provides the data to @Test since we declared the dataProvider there
	@DataProvider(name="LinkedInData")
	public Object[][] passData(){
		  
		 ExcelDataConfig config= new ExcelDataConfig("C:\\Users\\...\\Desktop\\LinkedIn\\LinkedInLoginTestIDPass.xlsx");

		 
		 int rows= config.getRowCount(0);
		 
		 Object[][] data= new Object[rows][2];
		 for(int i=1;i<rows;i++) {
			 
			 data[i][0]= config.getData(0, i, 0);
			 
			 data[i][1]= config.getData(0, i, 1);
			 
		 }
		  
		 return data;
		 
	  }
}

package Training.Practice;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.util.TestData;

public class Login {
	
static WebDriver driver;
	
	@BeforeMethod
	public void launchSite() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gcrit.com/build3/admin/");
	}
	
	@DataProvider 
	public Iterator<Object[]> getExcelData() {
		ArrayList<Object[]> testdata = TestData.getDataFromexcel();
		return testdata.iterator();
	}
	
	
	@Test(dataProvider = "getExcelData")
	public void loginPage(String username, String password) throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}

package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.LensKartPage;

public class LensKartTest {
	WebDriver driver;
	@BeforeTest
	public void setup() 
	{

		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwjPm8Wu5JuEAxU1B4MDHZ_eBQAYABAAGgJzZg&ase=2&gclid=CjwKCAiAlJKuBhAdEiwAnZb7lRB7E4S8LqM7V01JuyJYSwUuUS0dCBoPauRDMJJCmQ0LDlsuwcwr7BoC5jsQAvD_BwE&ohost=www.google.com&cid=CAESUuD2uOkFBlXwOxHyIRJB-Hx4ASwfdpI8yRWKqRdn7Qt2bEjBxpukj4l1IxPdbrkk_yeZEDCXiaP5HA-z6qbBzNBT4qJ9xIHaaeiFGfo-JSqNkbA&sig=AOD64_06UpZuXSLyo7L1Rw6gZ8nwKRry8A&q&nis=4&adurl&ved=2ahUKEwjDi72u5JuEAxVhUGwGHbdQBRIQ0Qx6BAgGEAE");
		
	}
	@Test
	public void test1() throws InterruptedException
	{
		LensKartPage ob=new LensKartPage(driver);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[3]/div[2]/span[2]")).click();
		ob.setvalues("LINSHA RACHEL", "SHABU", "9188839175", "linsharachel@gmail.com", "linsha@1998");
		ob.register();
		
		
//Content Verification
		String content=driver.getPageSource();
		if(content.contains("Cart"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
		@Test
		public void test2()
		{

//Search product
			WebElement search=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div/form/input"));
			search.sendKeys("Women glasses");
//Actions Class
			Actions act=new Actions(driver);
			act.keyDown(search,Keys.RETURN).perform();
			
			driver.findElement(By.xpath("//*[@id=\"c2c_frame_shape_uFilter\"]/div[2]/div/div[3]/label/span")).click();
//Scroll Down
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,300)", " ");
			driver.findElement(By.xpath("//*[@id=\"149966\"]/a/div[3]")).click();
			
//Window Handling
			String parentWindow=driver.getWindowHandle();
			Set<String>allwindowhandles=driver.getWindowHandles();
			for(String handle:allwindowhandles)
			{
				System.out.println(handle);
				if(!handle.equalsIgnoreCase(parentWindow))
				{
					driver.switchTo().window(handle);
					driver.findElement(By.xpath("//*[@id=\"product-swatch\"]/a[3]/span")).click();
					driver.close();
				}
				
				driver.switchTo().window(parentWindow);
				//Logo Verification
				Boolean logo=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[1]/a/img")).isDisplayed();
			}
		}
//Data Driven Testing
					
				@Test
				public void test3() throws IOException
				{
					
					driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[3]/div[2]/span[1]")).click();
					
				File f=new File("D:\\LensKart.xlsx");
				FileInputStream fi=new FileInputStream(f);
				XSSFWorkbook wb=new XSSFWorkbook(fi);
				XSSFSheet sh=wb.getSheet("Sheet1");
				System.out.println(sh.getLastRowNum());
				
				for(int i=1;i<=sh.getLastRowNum();i++)
				{
					
					
					String email=sh.getRow(i).getCell(0).getStringCellValue();
					System.out.println("Email="+email);
				
				
			//LOGIN VALIDATION
					
					
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(email);
			        driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(email);
				    driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(email);
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(email);
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(email);
					
					//driver.findElement(By.xpath("//*[@id=\"remove-button\"]")).click();
				}
					
					
					
}
				
				
				@Test
				public void test4() throws InterruptedException
				{
					
	//Sign-In to your account
					
					
					driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[3]/div[2]/span[1]")).click();
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[2]/div[1]/input")).sendKeys("linsharachel@gmail.com");
					driver.findElement(By.xpath("//*[@id=\"remove-button\"]")).click();
					
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/div/div[2]/div[3]/div[1]/input")).sendKeys("linsha@1998");
					driver.findElement(By.xpath("//*[@id=\"remove-button\"]")).click();
					
					
				//Open new TAB
					
					WebDriver driver1=driver.switchTo().newWindow(WindowType.TAB);
					driver1.get("https://www.google.com");
					
	//Title Verification
					
					String actualtitle=driver.getTitle();
					System.out.println(actualtitle);
					String exp="Google";
					if(actualtitle.equals(exp))
					{
						System.out.println("PASS");
					}
					else
					{
						System.out.println("FAIL");
					}
						
					driver1.close();
				}
					
					
					
					
				}
				

					
					
					
					
				
				
				
					

				
			
		

				
			
			
	
		
	
	
		
	



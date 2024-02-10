package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LensKartPage {
	WebDriver driver;

	By fname=By.name("firstName");
	By lname=By.name("lastName");
	By mobile=By.name("mobile");
	By email=By.name("email");
	By passwrd=By.name("password");
	By register=By.xpath("//*[@id=\"remove-button\"]");
	
	public LensKartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setvalues(String fnames,String lnames,String mob,String mail,String psd)
	{
		driver.findElement(fname).sendKeys(fnames);
		driver.findElement(lname).sendKeys(lnames);
		driver.findElement(mobile).sendKeys(mob);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(passwrd).sendKeys(psd);
		
	}
	public void register()
	{
		driver.findElement(register).click();
	}

}

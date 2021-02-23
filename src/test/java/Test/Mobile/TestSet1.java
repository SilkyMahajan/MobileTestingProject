package Test.Mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSet1 {
	
public AndroidDriver driver;
String ExpectedProduct;
String ExpectedProductshoe;
	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Silky");
        capability.setCapability(MobileCapabilityType.APPLICATION_NAME,"Android");
        capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:\\Silky\\SeleniumTraining\\Mobile testing\\chromedriver.exe");
        driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        driver.get("http://demowebshop.tricentis.com/login");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test (priority=0)
	public void login()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("mobileTesting777@gmail.com");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("mobile@123");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	       String expected="mobileTesting777@gmail.com";
	       String actual = driver.findElement(By.xpath("//a[text()='mobileTesting777@gmail.com']")).getText();
	       Assert.assertEquals(actual, expected);
	}
	
	@Test (priority=1)
	public void TestSorting()
	{
        driver.findElement(By.xpath("//span[@class='icon']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Computers')]//following-sibling::span")).click();
        driver.findElement(By.xpath("//li[@class='active']//ul//a[contains(text(),'Notebooks')]")).click();
        
        WebElement divElement = driver.findElement(By.xpath("//div[@class= 'page-title']//h1"));
        String ExpectedHeader= divElement.getText();
        String ActualHeader="Notebooks";
        System.out.println(ExpectedHeader);
        Assert.assertEquals(ActualHeader, ExpectedHeader);
        
        WebElement ddl= driver.findElement(By.xpath("//*[@id='products-orderby']"));
        Select selectvalue = new Select(ddl);
        selectvalue.selectByVisibleText("Created on");
        
        WebElement idElement = driver.findElement(By.xpath("//*[@id='products-orderby']/option[@selected]"));
        String ExpectedoptionSelected=idElement.getText();
        System.out.println(ExpectedoptionSelected);
        String ActualoptionSelected="Created on";
        Assert.assertEquals(ExpectedoptionSelected, ActualoptionSelected);
        
        WebElement hrefElement = driver.findElement(By.xpath("//h2[@class= 'product-title']/a"));
        ExpectedProduct=hrefElement.getText();
        System.out.println(ExpectedProduct);
        String ActualProduct ="14.1-inch Laptop";
        System.out.println(ExpectedProduct);
        Assert.assertEquals(ExpectedProduct, ActualProduct);
        
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
             
	}
	
	@Test(priority=2)
	public void AddItemToCart()
	{
		driver.findElement(By.xpath("//span[@class='icon']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Computers')]//following-sibling::span")).click();
		driver.findElement(By.xpath("//li[@class='active']//ul//a[contains(text(),'Accessories')]")).click();
                		
		WebElement divElement = driver.findElement(By.xpath("//div[@class= 'page-title']//h1"));
        String ExpectedHeader= divElement.getText();
        String ActualHeader="Accessories";
        System.out.println(ExpectedHeader);
        Assert.assertEquals(ActualHeader, ExpectedHeader);
        
        driver.findElement(By.xpath("//ul[@class='price-range-selector']//li[2]//a")).click();
        WebElement hrefElement = driver.findElement(By.xpath("//h2[@class= 'product-title']/a"));
        String ExpectedProduct=hrefElement.getText();
        System.out.println(ExpectedProduct);
        String ActualProduct ="TCP Coaching day";
        System.out.println(ExpectedProduct);
        Assert.assertEquals(ExpectedProduct, ActualProduct);
        
        driver.findElement(By.xpath("//span[@class='icon']")).click();
        driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//li[4]//a")).click();
        WebElement hrefElement1 = driver.findElement(By.xpath("//div[2][@class= 'item-box']//div[2]//a"));
        ExpectedProductshoe=hrefElement1.getText();
        System.out.println(ExpectedProductshoe);
        String ActualProduct1 ="Blue and green Sneaker";
        System.out.println(ExpectedProductshoe);
        Assert.assertEquals(ExpectedProductshoe, ActualProduct1);
        driver.findElement(By.xpath("//div[2][@class= 'item-box']//a")).click();
        
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
	}
	
	@Test(priority=3)
	public void ShoppingCart()
	{
		WebElement button=driver.findElement(By.xpath("//span[@class='cart-label']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
		WebElement finalfElement1 = driver.findElement(By.xpath("//tr[1][@class='cart-item-row']//a"));
        ExpectedProductshoe=finalfElement1.getText();
        System.out.println(ExpectedProductshoe);
        String ActualProductadd1 =ExpectedProduct;
        System.out.println(ExpectedProductshoe);
        Assert.assertEquals(ExpectedProductshoe, ActualProductadd1);
        
        WebElement finalElement2 = driver.findElement(By.xpath("//tr[2][@class='cart-item-row']//a"));
        ExpectedProductshoe=finalElement2.getText();
        System.out.println(ExpectedProductshoe);
        String ActualProductadd2 ="Blue and green Sneaker";
        System.out.println(ExpectedProductshoe);
        Assert.assertEquals(ExpectedProductshoe, ActualProductadd2);
		driver.findElement(By.xpath("//input[@name='termsofservice']")).click();
		driver.findElement(By.xpath("//*[@id='checkout']")).click();
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.findElement(By.xpath("//div[@class='header-links']//li[2]//a")).click();
		driver.close();
	}

}

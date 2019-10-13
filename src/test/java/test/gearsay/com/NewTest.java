package test.gearsay.com;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	public static WebDriver driver;
	private static final String CHROMEDERIVER = "webdriver.chrome.driver";
	private static final String PATH= "F:\\Mrunal\\chromedriver\\chromedriver_2.46\\chromedriver.exe";
	private static final String GearSayDev= "http://dev.gearsay.com";
	private static final String GearSayDevInvitedLink = "http://dev.gearsay.com/join/NDA/rowing-essentials-kit";
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	static SecureRandom secureRnd = new SecureRandom();

	@BeforeTest
	public static void URL() throws InterruptedException, AWTException {
		System.setProperty(CHROMEDERIVER, PATH);
		driver = new ChromeDriver();
		
		/*String expectedText = driver.findElement(By.xpath("//*[@id=\"AddUserViaLink\"]/div/div/div[2]/div[1]/h4/span")).getText();
		System.out.println(expectedText);*/
		
		driver.manage().window().maximize();
		Thread.sleep(1000);
}
	@Test(enabled = true, priority = 2 )
	public void SignupLoginFunctionality() throws InterruptedException {
	driver.get(GearSayDev);
	Thread.sleep(5000);
	WebElement clickLogin = driver.findElement(By.xpath("//*[@id=\"kitNav\"]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/a"));
	clickLogin.click();
	Thread.sleep(3000);
	Actions act = new Actions(driver);
	WebElement enterEmail = driver.findElement(By.id("inputGroupSuccess3"));
	act.moveToElement(enterEmail);
	enterEmail.sendKeys("gearsaydevops@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.id("pass")).sendKeys("Password$99");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"commanLoginPopup\"]/div/div/div[2]/div[4]/div[8]/h1/span[1]/a/strong")).click();
    Thread.sleep(3000);
    WebElement clickLogin1 = driver.findElement(By.xpath("//*[@id=\"commanLoginPopup\"]/div/div/div[2]/div[4]/div[1]/div"));
    act.moveToElement(clickLogin1);
    clickLogin1.click();
    Thread.sleep(3000);
	}
	
	@Test(enabled = false, priority = 3 )
	public void JointeamFunctionality() throws InterruptedException, AWTException{
	
	driver.get(GearSayDevInvitedLink);
	Thread.sleep(3000);
	driver.manage().window().maximize();
	WebElement enterFirstname = driver.findElement(By.xpath("//*[@id=\"joinerFirstName\"]"));
	enterFirstname.sendKeys("testxyz");
	Thread.sleep(3000);
	WebElement enterlastname = driver.findElement(By.xpath("//*[@id=\"joinerLastName\"]"));
	enterlastname.sendKeys("test");
	Thread.sleep(3000);
	Actions act = new Actions(driver);	
	WebElement enterEmailJoin = driver.findElement(By.name("email"));
	act.moveToElement(enterEmailJoin);
	Thread.sleep(3000);	
	act.sendKeys("testxyz@yopmail.com");
	Thread.sleep(3000);
	/*Robot r = new Robot();
	r.keyPress(KeyEvent.VK_TAB);	
	Thread.sleep(3000);
	Actions act = new Actions(driver);
	act.sendKeys("testcxyz@yopmail.com");*/
	WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"joinerPassword\"]"));
	enterPassword.sendKeys("xxxx@xxx");
	WebElement clickJoin = driver.findElement(By.xpath("//*[@id=\"joinBtn\"]"));
	clickJoin.click();
	Thread.sleep(3000);
	}

	@Test(enabled = true,priority = 2 )
	public void editTeamBrandCard() throws InterruptedException {
		
	WebElement clickConnect = driver.findElement(By.xpath("//*[@id=\"kitNav\"]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/button"));
	clickConnect.click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
	WebElement clickCricketKit = driver.findElement(By.xpath("//*[@id=\"userAddedKits\"]/div[1]/div[1]/div[3]/div[8]/div[1]/div[2]"));
	clickCricketKit.click();
	Thread.sleep(3000);
	WebElement clickEdit = driver.findElement(By.xpath("//*[@id=\"tableTemplate\"]/div[3]/div[3]/div/a[2]/div/img"));
	clickEdit.click();
	Thread.sleep(5000);
	
	WebElement teamName = driver.findElement(By.xpath("//*[@id=\"teamSettings\"]/div[3]/div[1]/div/div[6]/div/input"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", teamName);
	Thread.sleep(3000); 
	teamName.clear();
	Thread.sleep(3000);
	teamName.sendKeys(generateRandomString());
	Thread.sleep(3000);
	
	WebElement description = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
	description.sendKeys("test");
	Thread.sleep(2000);
	
	WebElement clickSaveChanges = driver.findElement(By.xpath("//*[@id=\"teamSettings\"]/div[4]/div/button[1]"));
	clickSaveChanges.click();
	Thread.sleep(3000);
	
	WebElement clickViewTeamPage = driver.findElement(By.xpath("//*[@id=\"teamSettings\"]/div[4]/div/a"));
	clickViewTeamPage.click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,1000)");
	WebElement clickprofilePictureIcon = driver.findElement(By.xpath("//*[@id=\"kitNav\"]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/span[1]/span/img"));
	clickprofilePictureIcon.click();
	Thread.sleep(5000);
	
	/*WebElement clickLocker = driver.findElement(By.xpath("//*[@id=\"updatePanel\"]/div[4]/div[2]/ul/li[3]/a/span/span"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickLocker);
	Thread.sleep(3000); 
	clickLocker.click();
	Thread.sleep(3000);*/
	
	/* ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	 driver.switchTo().window(tabs.get(1));
	
	 driver.navigate().to("dev.gearsay.com/user/1725?lockerId=5664");
	Thread.sleep(3000);*/
	js.executeScript("window.scrollBy(0,3500)");
}
	public String generateRandomString(){

	    StringBuffer randStr = new StringBuffer();
	    String s = randomString(10);
	    return s;
	}
	//for letters
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
		sb.append(CHAR_LIST.charAt(secureRnd.nextInt(CHAR_LIST.length())));
		return sb.toString();
		}
	
}

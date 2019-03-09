package emailTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class seleniumScript {
    private static WebDriver driver;
    final static String SEND_EMAIL_URL = "https://mail.google.com/mail/u/0/#inbox?compose=new";


    
    //Given("^I am logged in on a new email page$")
    public static void givenOnSendEmailPage() throws Throwable {


		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		//login
		//   -get on login page
		driver.get(SEND_EMAIL_URL);
		//   -enter email and click next
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("jiaweini0@gmail.com");
		WebElement nextBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("identifierNext")));
        nextBtn.click();
        Thread.sleep(500);
    	//   -enter password and click
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123123");
        Thread.sleep(500);
        WebElement signInBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        signInBtn.click();
        
        //   -go to send email page
        //driver.get(SEND_EMAIL_URL);
        WebElement composeBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div")));
        composeBtn.click();
        Thread.sleep(8000);
        
        
        return;
     
    }
    
    
    
    //Given("^When I fill an email address under “To”$")
    public static void whenFillTo() throws Throwable {

    	driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("jiaweini@live.com");
    	return;
    }
    
    
    
    
    
	public static void main(String[] args) throws Throwable{
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    	driver= new ChromeDriver();
		givenOnSendEmailPage();

		whenFillTo();

		
	}
}


 

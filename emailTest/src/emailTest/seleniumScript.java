package emailTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.HttpChannelState.Action;


public class seleniumScript {
    private static WebDriver driver;

    private final static String SEND_EMAIL_URL = "https://mail.google.com/mail/u/0/#inbox?compose=new";
    private final String SEND_BTN = "send";

    
    //Given("^I am logged in on a new email page$")
    public static void givenOnSendEmailPage() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//login
		//   -get on login page
		driver.get(SEND_EMAIL_URL);
		//   -enter email and click next
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("jiaweini0@gmail.com");
		WebElement nextBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("identifierNext")));
        nextBtn.click();
    	//   -enter password and click
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123414124142142");
        WebElement signInBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        signInBtn.click();
        
        //   -go to send email page
        //driver.get(SEND_EMAIL_URL);
        WebElement composeBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div")));
        composeBtn.click();
    }
    
    
    //Given("^When I fill an email address under “To”$")
    public static void whenFillTo() throws Throwable {
    	
    	Actions builder = new Actions(driver);
    	org.openqa.selenium.interactions.Action seriesOfActions = builder
    		.sendKeys("jiawei.ni@live.com")
    		.build();
    		
    	seriesOfActions.perform() ;
    	driver.findElement(By.className("wA")).sendKeys("jiaweini@live.com");
    	//ms-BasePicker-input pickerInput_269bfa71
    	
    	
    	
    	
    	
    	
    	//WebElement sendBtn = (new WebDriverWait(driver, 10))
        //        .until(ExpectedConditions.elementToBeClickable(By.name("Attach")));
        //sendBtn.click();
    	
    	
    }
    
    
    
    
    
	public static void main(String[] args) throws Throwable{
		givenOnSendEmailPage();
		whenFillTo();
		
		/*
		WebElement btn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("send")));
        System.out.print("Found!\n");
        btn.click();
        System.out.println("Clicking Add to Cart button");
		*/
	}
}


 

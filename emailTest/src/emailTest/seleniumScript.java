package emailTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class seleniumScript {
    private WebDriver driver;

    private final static String SEND_EMAIL_URL = "https://outlook.office.com/mail/deeplink/compose?popoutv2=1";
    private final String SEND_BTN = "send";

    
    //Given("^I am logged in on a new email page$")
    public static void givenOnSendEmailPage() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//login
		//   -get on login page
		driver.get(SEND_EMAIL_URL);
		//   -enter email and click next
		driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("jiawei.ni@mail.mcgill.ca");
		WebElement nextBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        nextBtn.click();
    	//   -enter password and click
        driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("123456");
        WebElement signInBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
        signInBtn.click();
        //   -stay signed in? yes
        WebElement staySignInBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        staySignInBtn.click();
        
    }
    
    
    
    
    
    
    
	public static void main(String[] args) throws Throwable{
		givenOnSendEmailPage();
		/*
		WebElement btn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("send")));
        System.out.print("Found!\n");
        btn.click();
        System.out.println("Clicking Add to Cart button");
		*/
	}
}


 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginTest {
    public void LoginWithValidData() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        // WebElement accountLink= driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        //accountLink.click();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("robert.kerekes@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("ParolaTestSeleniumMagento");
        driver.findElement(By.id("send2")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("body > div > div.page > div" +
                ".main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));

        String expectedText= "Hello, Robert Kerekes!";
        String actualText= welcomeTextElement.getText();

        if (actualText.equals(expectedText)){
            System.out.println("S-a logat cu succes!");
        }else
            System.out.println("Nu s-a logat!");

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[5]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement optionFromDropdown = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[5]/ul/li[5]/a"));
        optionFromDropdown.click();




        Thread.sleep(3);
       // driver.close();



    }
}

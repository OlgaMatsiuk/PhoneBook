package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    //WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        //wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
    public void setUp(){
     app.init();
    }

    @AfterSuite
//    public void tearDown() {
//        wd.quit();
//    }
    public void stop(){
        app.tearDown();
    }

//    public void click(By locator) {
//        wd.findElement(locator).click();
//    }

//    public void openLoginRegistrationForm() {
//
//        click(By.xpath("//*[text()='LOGIN']"));
//    }

//    public void type(By locator, String text) {
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//    public void fillLoginRegistrationForm(String email, String password) {
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//
//    }
//    public void submitLogin() {
//        click(By.xpath("//button[1]"));
//    }
//    public void submitRegistration() {
//        click(By.xpath("//button[2]"));
//    }

//    public boolean isElementPresent(By locator) {
//
//        return wd.findElements(locator).size() > 0;
//    }

//    public void pause(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public boolean isLogged() {
//        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
//    }
//    public void logout() {
//        click(By.xpath("//*[text()='Sign Out']"));
//    }

}

package web_ilcaro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class login {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wd.navigate().to("http://ilcarro.web.app/");


    }

    @Test
    public void positiveLoginTest() {
        click(By.xpath("//a[.='Log in']"));
        type(By.id("email"),"matsiuk2015@gmail.com");

//        wd.findElement(By.id("password")).click();
//        wd.findElement(By.id("password")).clear();
//        wd.findElement(By.id("password")).sendKeys("");
        type(By.id("password"),"Aravaavara0$");

       // wd.findElement(By.xpath("//button[@type='submit']")).click();

        click(By.xpath("//button[@type='submit']"));
       // Thread.sleep(5000);
        pause(3000);
        Assert.assertTrue(isElementDisplayed(By.xpath("//h2[normalize-space()='Logged is success']")));
        





    }




    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    //=============================================================

    private void click(By locator) {
        wd.findElement(locator).click();

    }
    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);

    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isElementDisplayed(By locator) {
        return wd.findElement(locator).isDisplayed();
    }


}

package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {
    WebDriver wd;
    Select select;
    @Test
    public void dropDownTest() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://the-internet.herokuapp.com/dropdown");
       // wd.findElement(By.id("dropdown")).click();
        WebElement ddown = wd.findElement(By.id("dropdown"));
        select = new Select(ddown);
        select.selectByValue("2");
        //Thread.sleep(3000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}

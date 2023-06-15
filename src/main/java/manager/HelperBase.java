package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void openLoginRegistrationForm() {

        click(By.xpath("//*[text()='LOGIN']"));
    }
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public boolean isElementPresent(By locator) {

        return wd.findElements(locator).size() > 0;
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

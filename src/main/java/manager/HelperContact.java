package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    public void openContactForm() {
        System.out.println("EEEEEEEEEEEEEEEEEEEEE");
        //pause(5000);
        click(By.cssSelector("a[href='/add']"));
        pause(5000);
    }

    public boolean isContactFormPresent() {
        pause(5000);
//        return new WebDriverWait(wd, 10)
//                .until(ExpectedConditions
//                        .presenceOfElementLocated(By.xpath("//b[normalize-space()='Save']")));
        return isElementPresent(By.xpath("//b[normalize-space()='Save']"));

    }

    public void fillContactForm(Contacts contacts) {

        if(isContactFormPresent() == false) return;
        type(By.xpath("input[placeholder='Name']"), contacts.getName());
        type(By.xpath("input[placeholder='Last Name']"), contacts.getLastName());
        type(By.xpath("input[placeholder='Phone']"), contacts.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contacts.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contacts.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contacts.getDescription());

    }

}

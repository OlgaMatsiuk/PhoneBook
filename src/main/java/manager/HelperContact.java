package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public void openContactForm() {
        //pause(5000);
        click(By.cssSelector("a[href='/add']"));
        pause(1000);
    }

    public boolean isContactFormPresent() {
        pause(3000);
//        return new WebDriverWait(wd, 10)
//                .until(ExpectedConditions
//                        .presenceOfElementLocated(By.xpath("//b[normalize-space()='Save']")));
        return isElementPresent(By.cssSelector("div[class='add_form__2rsm2'] button b"));

    }

    public void fillContactForm(Contacts contacts) {

        if(isContactFormPresent() == false) return;

        type(By.xpath("//input[@placeholder='Name']"), contacts.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contacts.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contacts.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contacts.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contacts.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contacts.getDescription());

    }

    public void submitContactForm(){
        click(By.cssSelector("div[class='add_form__2rsm2'] button b"));
    }
    public int removeOneContact(){
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is" + countBefore);
        String phone=wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).getText();
        logger.info("The deleted phone number is " + phone);
        click(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]"));
        click(By.xpath("//button[normalize-space()='Remove']"));
        pause(5000);
        int countAfter = countOfContacts();
        logger.info("Number of contacts after is" + countAfter);

        return countAfter - countBefore;

    }
    public int countOfContacts(){
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();

    }

    public void removeAllContacts() {
        while (wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size() != 0){
            removeOneContact();
        }
    }

}

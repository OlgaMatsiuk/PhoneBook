package tests;

import manager.ProviderData;
import models.Contacts;
import models.User;
import net.bytebuddy.agent.builder.LambdaFactory;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class AddNewContacts extends TestBase{
    Logger logger = LoggerFactory.getLogger(AddNewContacts.class);

    @BeforeMethod(alwaysRun = true)

    public void precondition(){
        if(app.getUser().isLogged() == false){
            app.getUser()
                    .login(new User()
                            .withEmail("matsiuk2015@gmail.com")
                            .withPassword("Aravaavara0$"));

        }

    }

    @Test(invocationCount = 1,groups = {"sanity"})

    public void addNewContactsPositive() {
        int i = (int)System.currentTimeMillis()/1000%3600;
        System.out.println(i);
        Contacts contact = Contacts.builder()
                .name("Rembo")
                .lastName("Nir")
                .phone("0535268"+i)
                .email("rembo" + i + "@gmail.com")
                .address("Israel")
                .description("friend")
                .build();
        logger.info("Phone number is " + contact.getPhone());
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();

        Assert.assertTrue(
                app.getUser()
                        .getText(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3"))
                        .equals(contact.getPhone())
        );

    }

    @Test(dataProvider = "contactModelListDTO_CSV", dataProviderClass = ProviderData.class)

    public void addNewContactsPositive1(Contacts contacts) {
        //int i = (int)System.currentTimeMillis()/1000%3600;
//        Contacts contact = Contacts.builder()
//                .name("Rembo")
//                .lastName("Nir")
//                .phone("0535268"+i)
//                .email("rembo" + i + "@gmail.com")
//                .address("Israel")
//                .description("friend")
//                .build();
        logger.info("Phone number is " + contacts.getPhone() + "provided");
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contacts);
        app.getContact().submitContactForm();

    }

}

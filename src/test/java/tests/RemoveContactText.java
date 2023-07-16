package tests;

import models.User;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class RemoveContactText extends TestBase {
    Logger logger = LoggerFactory.getLogger(RemoveContactText.class);

    @BeforeMethod(alwaysRun = true)


    public void precondition(){
        //logger.info("Precond");


        if(!app.getUser().isLogged()){


            app.getUser()
                    .login(new User()
                            .withEmail("matsiuk2015@gmail.com")
                            .withPassword("Aravaavara0$"));

        }

    }



    @Test
    public void removeOneContact(){

        int res = app.getContact().removeOneContact();
        Assert.assertEquals(-1, res);


    }
    @Test
    public void removeAllContacts(){
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isElementPresent(By.xpath("")));
    }

}

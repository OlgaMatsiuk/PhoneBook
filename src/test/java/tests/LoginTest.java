package tests;

import manager.NgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)

public class LoginTest extends TestBase {

    @BeforeMethod(alwaysRun = true)

    public void precondition(){
        if(app.getUser().isLogged()){

            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTestCorrectMailAndPassword(){
        String email = "matsiuk2015@gmail.com",password="Aravaavara0$";


        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm( email, password);
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }
    @Test(groups = {"smokeGroup","sanityGroup","regressionGroup"})
    public void loginPositiveUser(){
        String email = "matsiuk2015@gmail.com",password="Aravaavara0$";

       // User user = new User().withEmail(email).withPassword(password);
        User user = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }


    @Test
    public void loginNegativeTestWrongEmail(){
        String email = "matsiuk2015gmail.com",password="Aravaavara0$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[normalize-space()='LOGIN']")));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

    }

}

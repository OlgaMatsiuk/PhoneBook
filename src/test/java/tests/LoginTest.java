package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod

    public void precondition(){
        if(app.getUser().isLogged()){

            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTestCorrectMailAndPassword(){
        String email = "matsiuk2015@gmail.com",password="Aravaavara0$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
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

    @AfterMethod
    public void tearDown(){

    }
}

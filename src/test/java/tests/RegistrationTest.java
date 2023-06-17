package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod

    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        String email = "matsiuk2015" + i + "@gmail.com",password="Aravaavara0$#";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();

       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @Test
    public void registationNegativeTestWithExistingEmail(){
        String email = "matsiuk2015@gmail.com",password="Aravaavara0$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @Test
    public void registationNegativeTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "matsiuk2015" + i + "gmail.com",password="Aravaavara0$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @AfterMethod
    public void tearDown(){

    }

}

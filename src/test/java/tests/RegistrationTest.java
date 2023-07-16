package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    @BeforeMethod(alwaysRun = true)

    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }


//    @BeforeMethod
//    public void precondition() {
//        if(app.getUser().isLogged()==false){
//
//            app.getUser()
//                    .login(new User()
//                            .withEmail("matsiuk2015@gmail.com")
//                            .withPassword("Aravaavara0#"))
//            ;
//        }
//
//    }

    @Test(groups = {"sanityGroup","regressionGroup"})
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        String email = "matsiuk2015" + i + "@gmail.com",password="Aravaavara0$#";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();

       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @Test(dataProvider = "userModelListDTO_CSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveTest_CSV(User user){
       // int i = (int)(System.currentTimeMillis()/1000)%3600;

       // String email = "matsiuk2015" + i + "@gmail.com",password="Aravaavara0$#";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();

       //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

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
        Assert.assertTrue(app.getUser().isErrorMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
        //Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

    }

}

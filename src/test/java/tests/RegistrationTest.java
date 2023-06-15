package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

   // WebDriver wd;

    @BeforeMethod
//    public void init(){
////        wd=new ChromeDriver();
////        wd.navigate().to("https://telranedu.web.app/home");
////        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//    }
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }


    @Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        //open login form
        //wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        String email = "matsiuk2015" + i + "@gmail.com",password="Aravaavara0$";



        // fill login form
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("matsiuk2015" + i + "@gmail.com");

//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Aravaavara0$");

       // wd.findElement(By.xpath("//button[2]")).click();

       // wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));


        //Assert
        // List<WebElement> btnSignOut = wd.findElements(By.xpath("//*[text()='Sign Out']"));

        //int size = btnSignOut.size();
        //Assert.assertEquals(size, 1);


       // Assert.assertTrue(wd.findElements(By.xpath("//a[@href='/add']")).size() > 0);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));



    }

    @Test
    public void registationNegativeTestWithExistingEmail(){
        String email = "matsiuk2015@gmail.com",password="Aravaavara0$";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        Assert.assertFalse(isElementPresent(By.xpath("//*[text()='Sign Out']")));

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

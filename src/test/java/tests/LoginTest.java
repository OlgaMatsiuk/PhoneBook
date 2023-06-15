package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

   // WebDriver wd;

    @BeforeMethod

    public void precondition(){
        if(app.getUser().isLogged()){

            app.getUser().logout();
        }
    }
//    public void init(){
//        wd=new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//
//    }


    @Test
    public void loginPositiveTestCorrectMailAndPassword(){
        String email = "matsiuk2015@gmail.com",password="Aravaavara0$";
        //open login form
       // wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitLogin();



        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("matsiuk2015@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Aravaavara0$");

       //wd.findElement(By.xpath("//button[1]")).click();

        //wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));




        //Assert
       // List<WebElement> btnSignOut = wd.findElements(By.xpath("//*[text()='Sign Out']"));

        //int size = btnSignOut.size();
        //Assert.assertEquals(size, 1);


        //Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }

    @Test
    public void loginNegativeTestWrongEmail(){
        String email = "matsiuk2015gmail.com",password="Aravaavara0$";
        //open login form
       // wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        app.getUser().openLoginRegistrationForm();
        // fill login form
        app.getUser().fillLoginRegistrationForm(email,password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("matsiuk2015gmail.com");

//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Aravaavara0$");

        //wd.findElement(By.xpath("//button[1]")).click();
        //wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));


        //Assert
        // List<WebElement> btnSignOut = wd.findElements(By.xpath("//*[text()='Sign Out']"));

        //int size = btnSignOut.size();
        //Assert.assertEquals(size, 1);


       // Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
        //pause(3000);
       // Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
        app.getUser().submitLogin();
    }


    @AfterMethod
    public void tearDown(){

    }

}

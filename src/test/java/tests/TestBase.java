package tests;

import manager.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

    //WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite

    public void setUp(){
     app.init();
    }

    @AfterSuite

    public void stop(){
        app.tearDown();
    }

}

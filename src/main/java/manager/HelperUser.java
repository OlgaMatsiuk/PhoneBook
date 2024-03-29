package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.jws.soap.SOAPBinding;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }
    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }
    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());

    }
        public void openLoginRegistrationForm() {

        click(By.xpath("//*[text()='LOGIN']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }
    public void logout() {
        click(By.xpath("//*[text()='Sign Out']"));
    }

    public void login(User user){
    openLoginRegistrationForm();
    fillLoginRegistrationForm(user.getEmail(), user.getPassword());
    pause(3000);
    submitLogin();
    pause(2000);


    }

    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        } else {
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            return true;
        }

    }

    public boolean isErrorMessageFormat(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password format");
    }



}

package tests;

import models.Contacts;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContacts extends TestBase{

    @BeforeMethod

    public void precondition(){
        if(app.getUser().isLogged() == false){
            app.getUser()
                    .login(new User()
                            .withEmail("matsiuk2015@gmail.com")
                            .withPassword("Aravaavara0$"));

        }

    }

    @Test

    public void addNewContacts() {
        int i = (int)System.currentTimeMillis()/1000%3600;
        Contacts contact = Contacts.builder()
                .name("Rembo")
                .lastName("Nir")
                .phone("0536897425")
                .email("rembo" + i + "@gmail.com")
                .address("Israel")
                .description("friend")
                .build();
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);



    }

}

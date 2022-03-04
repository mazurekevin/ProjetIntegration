package User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;
    private User user2;

    @Before
    public void init(){
        this.user = new User( "test@yopmail.fr", "TEST", "Bla", "24", "blablabla");
        this.user2 = new User( "user.testgmail.com", "test", "bla", "12", "bla");

    }

    @Test
    public void isValidTest(){
        Assert.assertTrue(this.user.isValid());
        Assert.assertFalse(this.user2.isValid());

    }

    @Test
    public void isValidFirstname(){
        Assert.assertTrue(this.user.isFirstnameValid(this.user.getFirstname()));
    }

    @Test
    public void isValidLastname(){
        Assert.assertTrue(this.user.isLastnameValid(this.user.getLastname()));
    }

    @Test
    public void isValidMail(){
        Assert.assertTrue(this.user.isEmailValid(this.user.getMail()));
    }

    @Test
    public void isValidPassword() {
        Assert.assertTrue(this.user.isPasswordValid(this.user.getPassword()));
    }

    @Test
    public void isNoValidFirstname(){
        Assert.assertFalse(this.user2.isFirstnameValid(this.user2.getFirstname()));
    }

    @Test
    public void isNoValidLastname(){
        Assert.assertFalse(this.user2.isLastnameValid(this.user2.getLastname()));
    }

    @Test
    public void isNoValidMail(){
        Assert.assertFalse(this.user2.isEmailValid(this.user2.getMail()));
    }

    @Test
    public void isNoValidPassword() {
        Assert.assertFalse(this.user2.isPasswordValid(this.user2.getPassword()));
    }
}

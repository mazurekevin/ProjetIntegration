package User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private final String mail;
    private final String lastname;
    private final String firstname;
    private final String birthday;
    private final String password;

    public User(String mail, String lastname, String firstname, String birthday, String password) {
        this.mail = mail;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isPasswordValid(String password) {
        return password.length() > 8 && password.length() < 40;
    }

    public boolean isFirstnameValid(String firstname) {
        String regex = "[A-Z][a-z]*";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(firstname);

        return matcher.matches();
    }

    public boolean isLastnameValid(String lastname) {
        String regex = "[A-Z]*";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(lastname);

        return matcher.matches();
    }

    public boolean isEmailValid(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    public boolean isValid(){
        if((isFirstnameValid(this.firstname)== true)&&(isLastnameValid(this.lastname)==true)&&(isEmailValid(this.mail)==true)&&(isPasswordValid(this.password)==true)) {
            return this.isEmailValid(this.mail) && this.isPasswordValid(this.password) && Integer.parseInt(this.birthday) >= 13;
        }
        return false;
    }

}
package com.apiSpring.apiSpring.controller;

import com.User.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    Response res = new Response();
    ConnectDB connectDB = new ConnectDB();

    @GetMapping(value = "/getAll")
    public String getAll() {
        return connectDB.connectDB("SELECT * FROM user", "SELECT");
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody User user) {
        connectDB.connectDB("INSERT INTO user(firstname, lastname, mail, birthday, password) VALUES ('"+
                user.getFirstname()+ "','" +
                user.getLastname() + "','" +
                user.getMail() + "','" +
                user.getBirthday() + "','" +
                user.getPassword() + "')", "INSERT");
        return res.created("L'utilisateur "+user.getFirstname()+" "+user.getLastname());
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody User user) {
        connectDB.connectDB("UPDATE user SET firstname='"+
                user.getFirstname()+ "', lastname='" +
                user.getLastname() + "', birthday='" +
                user.getBirthday() + "', password='" +
                user.getPassword() + "' WHERE mail='"+
                user.getMail() + "'", "UPDATE");
        return res.updated("L'utilisateur "+user.getFirstname()+" "+user.getLastname());
    }

    @DeleteMapping(value = "/delete")
    public String delete(@RequestParam String mail) {
        connectDB.connectDB("DELETE FROM user WHERE mail='"+
                mail + "'", "DELETE");
        return res.deleted("L'utilisateur ayant le mail : "+mail);
    }

    @GetMapping(value = "/getMail")
    public String getByMail(@RequestParam String mail) {
        String response = connectDB.connectDB("SELECT * FROM user WHERE mail = '" + mail + "'", "SELECT");
        if(response != "") return response;
        res.notFound(mail);
        return "";
    }

    @GetMapping(value = "/getPasswordByMail")
    public String getPasswordByMail(@RequestParam String mail) {
        String response = connectDB.connectDB("SELECT password FROM user WHERE mail = '" + mail + "'", "PASSWORD");
        if(response != "") return response;
        res.notFound(mail);
        return "";
    }
}

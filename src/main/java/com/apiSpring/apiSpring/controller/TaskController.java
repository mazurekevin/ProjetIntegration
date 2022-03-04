package com.apiSpring.apiSpring.controller;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    Response res = new Response();
    ConnectDB connectDB = new ConnectDB();

    @GetMapping(value = "/getAll")
    public String getAll() {
        return connectDB.connectDB("SELECT * FROM task", "SELECT");
    }

    @PostMapping(value = "/create")
    public String create(@RequestBody Task.Task task) {
        LocalDateTime today = LocalDateTime.now();
        today.toString();
        connectDB.connectDB("INSERT INTO task(name, content, createDate) VALUES ('"+
                task.getName()+ "','" +
                task.getContent() + "','" +
                today + "')", "INSERT");
        return res.created("La tache "+task.getName());
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody Task.Task task) {
        connectDB.connectDB("UPDATE task SET name='"+
                task.getName()+ "', content='" +
                task.getContent() + "' WHERE id='"+
                task.getId()+"'", "UPDATE");
        return res.updated("La tache "+ task.getName());
    }

    @DeleteMapping(value = "/delete")
    public String delete(@RequestParam String id) {
        connectDB.connectDB("DELETE FROM task WHERE id='"+
                id + "'", "DELETE");
        return res.deleted("La tache ayant l'id : "+id);
    }

    @GetMapping(value = "/getById")
    public String getById(@RequestParam Integer id) {
        String response = connectDB.connectDB("SELECT * FROM task WHERE id = '" + id + "'", "SELECT");
        if(response != "") return response;

        return res.notFound(id.toString());
    }
    @GetMapping(value = "/getDateById")
    public String getDateById(@RequestParam Integer id) {
        String response = connectDB.connectDB("SELECT createDate FROM task WHERE id = '" + id + "'", "ID");
        if(response != "") return response;
        res.notFound(id.toString());
        return "";
    }

    @GetMapping(value = "/getMaxId")
    public String getMaxId() {
        String response = connectDB.connectDB("SELECT MAX(id) FROM task", "ID");
        if(response != "") return response;
        return "";
    }


}

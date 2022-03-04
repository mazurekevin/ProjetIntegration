package com.Interface;

import com.Interface.CreateTask;
import com.apiSpring.apiSpring.controller.TaskController;
import com.apiSpring.apiSpring.controller.UserController;

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ContentTask extends JFrame implements ActionListener{
    private CreateTask createTask;
    private JTextArea texteTitre = new JTextArea();
    private JTextArea texte = new JTextArea();
    private JFrame f4 = new JFrame("TO DO LIST");

    public ContentTask(){

        JPanel pannel = new JPanel();

        JLabel Mail = new JLabel("Titre de la tache:");
        Mail.setBounds(20, 50, 150, 20);
        f4.add(Mail);


        texteTitre.setBounds(120, 50, 150, 20);
        f4.add(texteTitre);


        texte.setBounds(20, 80, 350, 300);
        f4.add(texte);

        JButton valid = new JButton("Validez");
        valid.setBounds(120, 400, 150, 20);
        f4.add(valid);
        valid.addActionListener(this);

        f4.setSize(400, 500);
        f4.getContentPane().add(pannel);
        f4.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String response;
        String number;
        TaskController taskController = new TaskController() ;
        boolean test = true;
        number = taskController.getMaxId();
        int i = Integer.parseInt(number);
        response = taskController.getDateById(i);
        LocalDateTime dateTime = LocalDateTime.parse(response);
        Task.Task task = new Task.Task(texteTitre.getText(),texte.getText(), LocalDateTime.now());
        test = task.isThirtyMinutesOver(dateTime);
        if(!test){
            JOptionPane.showMessageDialog(this, "Il faut bien attendre 30 minutes",
                    "avertissement",
                    JOptionPane.WARNING_MESSAGE);
        }else{
            taskController.create(task);
            this.dispose();
            createTask = new CreateTask();
            f4.dispose();
        }
    }
}

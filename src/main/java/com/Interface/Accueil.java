package com.Interface;

import com.apiSpring.apiSpring.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Accueil extends JFrame implements ActionListener {
    private Formulaire formulaire;
    private CreateTask createTask;
    private JButton valid = new JButton("Validez");
    private JButton inscrire = new JButton("inscrivez-vous");
    private JTextArea texte = new JTextArea();
    private JTextArea passwordField1 = new JTextArea();
    private JFrame f = new JFrame("TO DO LIST");
    public Accueil() {
        super("TO DO LIST");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);


        JPanel pannel = new JPanel();
        JLabel jLabel1 = new JLabel("Bienvenue dans votre To Do List");
        pannel.add(jLabel1);

        JLabel identi = new JLabel("Identifiant:");
        identi.setBounds(50, 100, 150, 20);
        f.add(identi);


        texte.setBounds(115, 100, 150, 20);
        f.add(texte);

        JLabel Password = new JLabel("Mot de passe:");
        Password.setBounds(50, 130, 150, 20);
        f.add(Password);


        //passwordField1.setPreferredSize(new Dimension(100, 20));
        passwordField1.setBounds(135, 130, 150, 20);
        f.add(passwordField1);

        valid.setBounds(120, 200, 150, 20);
        f.add(valid);
        valid.addActionListener(this);

        inscrire.setBounds(120, 250, 150, 20);
        f.add(inscrire);
        inscrire.addActionListener(this);

        f.setSize(400, 500);
        f.getContentPane().add(pannel);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();
        if  (source==valid){
            String reponse;
            UserController mail = new UserController();
            reponse = mail.getPasswordByMail(texte.getText());
            if(reponse.equals(passwordField1.getText())){
                System.out.println("Vous avez réussi votre connexion");
                this.dispose();
                createTask = new CreateTask();
                f.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Mauvais login",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }

        }else if (source==inscrire){
            this.dispose();
            formulaire = new Formulaire();
            f.dispose();
        }
    }
}
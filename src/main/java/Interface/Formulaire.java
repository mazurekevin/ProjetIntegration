package Interface;

import User.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulaire extends JFrame implements ActionListener {
private CreateTask createTask;
    private JTextArea texteMail = new JTextArea();
    private JTextArea texteLast = new JTextArea();
    private JTextArea texteFirstname = new JTextArea();
    private JTextArea textebirthday = new JTextArea();
    private JTextArea textepassword = new JTextArea();
    public Formulaire() {
        JFrame f2 = new JFrame("TO DO LIST");
        JPanel pannel = new JPanel();

        JLabel Mail = new JLabel("Mail:");
        Mail.setBounds(50, 100, 150, 20);
        f2.add(Mail);


        texteMail.setBounds(115, 100, 150, 20);
        f2.add(texteMail);

        JLabel lastname = new JLabel("Lastname:");
        lastname.setBounds(50, 130, 150, 20);
        f2.add(lastname);


        texteLast.setBounds(115, 130, 150, 20);
        f2.add(texteLast);

        JLabel Firstname = new JLabel("Firstname:");
        Firstname.setBounds(50, 160, 150, 20);
        f2.add(Firstname);


        texteFirstname.setBounds(115, 160, 150, 20);
        f2.add(texteFirstname);

        JLabel birthday = new JLabel("birthday:");
        birthday.setBounds(50, 190, 150, 20);
        f2.add(birthday);


        textebirthday.setBounds(115, 190, 150, 20);
        f2.add(textebirthday);

        JLabel password = new JLabel("password:");
        password.setBounds(50, 220, 150, 20);
        f2.add(password);


        textepassword.setBounds(115, 220, 150, 20);
        f2.add(textepassword);

        JButton valid = new JButton("Validez");
        valid.setBounds(120, 290, 150, 20);
        f2.add(valid);
        valid.addActionListener(this);

        
        f2.setSize(400, 500);
        f2.getContentPane().add(pannel);
        f2.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        boolean test = false;
        User user = new User(texteMail.getText(),texteLast.getText(),texteFirstname.getText(), textebirthday.getText(),textepassword.getText());
        test = user.isValid();
        System.out.println(user);
        if(!test){
            System.out.println("Compte invalide");
        }else{
            System.out.println("Votre compte est valide");
            this.dispose();
            createTask = new CreateTask();
        }
    }
}

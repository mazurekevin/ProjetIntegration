package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentTask extends JFrame implements ActionListener{
    private CreateTask createTask;
    public ContentTask(){
        JFrame f4 = new JFrame("TO DO LIST");
        JPanel pannel = new JPanel();

        JLabel Mail = new JLabel("Titre de la tache:");
        Mail.setBounds(20, 50, 150, 20);
        f4.add(Mail);

        JTextArea texteTitre = new JTextArea();
        texteTitre.setBounds(120, 50, 150, 20);
        f4.add(texteTitre);

        JTextArea texte = new JTextArea();
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
        this.dispose();
        createTask = new CreateTask();
    }
}

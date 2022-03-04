package Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTask extends JFrame implements ActionListener{
    private ContentTask contentTask;
    private JButton valid = new JButton("Créer une tache");
    private JButton quitter = new JButton("Quitter");

    public CreateTask(){
        JFrame f3 = new JFrame("TO DO LIST");
        JPanel pannel = new JPanel();

        valid.setBounds(120, 200, 150, 20);
        f3.add(valid);
        valid.addActionListener(this);

        quitter.setBounds(120, 230, 150, 20);
        f3.add(quitter);
        quitter.addActionListener(this);

        f3.setSize(400, 500);
        f3.getContentPane().add(pannel);
        f3.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();
        if  (source==valid){
            this.dispose();
            contentTask = new ContentTask();
        }else if (source==quitter){
            System.exit(0);
        }
    }
}

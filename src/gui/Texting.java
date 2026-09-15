package gui;

import javax.swing.*;
import java.awt.*;

public class Texting extends JFrame {
    public Texting(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 200);
        setLayout(new FlowLayout());

        JTextField textField = new JTextField("19");
        //textField.setSize(300, 700);
        textField.setPreferredSize(new Dimension(300, 70));
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
        //textField.setBackground(Color.yellow);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        //textField.setEnabled(false);

        JButton button = new JButton("Print");
        button.setSize(140, 70);
        button.addActionListener(e -> {
            try {
                int x = Integer.parseInt(textField.getText());
                new GridPane(x).setVisible(true);

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Invalid input", "Titulek", JOptionPane.OK_CANCEL_OPTION);
                System.out.println("INVALID INPUT");;
            }
        });

        add(textField);
        add(button);
        pack();
    }
    public static void main(String[] args) {
        new Texting().setVisible(true);
    }
}

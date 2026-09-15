package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class RadioButton extends JFrame {
    public RadioButton(){
        setSize(500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new FlowLayout()), centerPanel = new JPanel();


        JRadioButton rbRed = new JRadioButton("Red");
        JRadioButton rbGreen = new JRadioButton("Green");
        JRadioButton rbBlue = new JRadioButton("Blue");
        ButtonGroup group = new ButtonGroup();

        JCheckBox cbRed = new JCheckBox("Border");
        JButton button = new JButton("Paint");

        button.addActionListener(e -> {
            if (rbRed.isSelected()){
                centerPanel.setBackground(Color.red);
            }
            if (rbGreen.isSelected()){
                centerPanel.setBackground(Color.green);
            }
            if (rbBlue.isSelected()){
                centerPanel.setBackground(Color.blue);
            }
            if (cbRed.isSelected()){
                centerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 20));
            }else {
                centerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 0));
            }
        });

        group.add(rbRed);
        group.add(rbGreen);
        group.add(rbBlue);

        northPanel.add(rbRed);
        northPanel.add(rbGreen);
        northPanel.add(rbBlue);
        northPanel.add(cbRed);
        northPanel.add(button);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new RadioButton().setVisible(true);
    }
}

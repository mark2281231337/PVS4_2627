package gui.avatars;

import javax.swing.*;
import java.awt.*;

public class CardMenu extends JFrame {
    JLabel fullName, salary, shoeSize;
    ImageIcon avatar;
    JPanel lowerMenu;
    JButton next, previous, first, last;

    int current = 0;


    CardMenu(int value){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,400);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        lowerMenu = new JPanel();
        lowerMenu.setLayout(new FlowLayout());


        fullName = new JLabel();
        salary = new JLabel();
        shoeSize = new JLabel();

        fullName.setFont(new Font("MV Boli", Font.BOLD, 18));
        salary.setFont(new Font("MV Boli", Font.BOLD, 18));
        shoeSize.setFont(new Font("MV Boli", Font.BOLD, 18));

//        avatar = MainMenu.personData.get(0).avatar;//zaciname na prvnim
        showAvatar(0);

        fullName.setIcon(avatar);
        fullName.setHorizontalTextPosition(JLabel.CENTER);
        fullName.setVerticalTextPosition(JLabel.TOP);
        fullName.setIconTextGap(5);
        fullName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.add(fullName, BorderLayout.CENTER);

        previous = new JButton("Previous");
        next = new JButton("Next");
        first = new JButton("First");
        last = new JButton("Last");
        //previous.setEnabled(false);

        previous.addActionListener(e -> showPrevious(value));
        next.addActionListener(e -> showNext(value));
        first.addActionListener(e -> showFirst());
        last.addActionListener(e -> showLast(value));

        lowerMenu.add(first);
        lowerMenu.add(previous);
        lowerMenu.add(shoeSize);
        lowerMenu.add(salary);
        lowerMenu.add(next);
        lowerMenu.add(last);

        this.add(lowerMenu, BorderLayout.SOUTH);
        this.pack();
    }

    private void showLast(int max) {
        current = max;
//        next.setEnabled(false);
//        previous.setEnabled(true);
        showAvatar(current);
    }

    private void showFirst() {
        current = 0;
//        previous.setEnabled(false);
//        next.setEnabled(true);
        showAvatar(current);
    }

    private void showPrevious(int max) {
//        if (current == 0){
//            previous.setEnabled(false);
//        }else {
//            previous.setEnabled(true);
//        }
//        next.setEnabled(true);
        if (current == 0){
            current = max+1;
        }
        showAvatar(--current);
    }

    private void showNext(int max) {
//        if (current == 62){
//            next.setEnabled(false);
//        }else {
//            previous.setEnabled(true);
//        }
//        next.setEnabled(true);
        if (current == max){
            current = -1;
        }
        showAvatar(++current);
    }

    void showAvatar(int index){
        avatar = new ImageIcon(MainMenu.personData.get(index).avatar.getImage().getScaledInstance(500,450, Image.SCALE_DEFAULT));
        fullName.setIcon(avatar);
        fullName.setText("Full name: " + MainMenu.personData.get(index).name + " " + MainMenu.personData.get(index).surname);
        shoeSize.setText("Shoe size: " + MainMenu.personData.get(index).shoeSize);
        salary.setText("Salary: " + MainMenu.personData.get(index).salary);
    }

}

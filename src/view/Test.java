package view;

import model.Field;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test extends JFrame {

    private List<JButton> buttons = new ArrayList<>();
    Field field = new Field();


    public Test() {
        field.erstelleKarten();
        System.out.println(field.getCardVector());

        System.out.println(0%2 == 0);
        setSize(500, 500);
        for (int i = 1; i <= 36; i++) {
            buttons.add(new JButton());
        }

        this.setLayout(new GridLayout(6, 6));
        for (JButton button : buttons) {
            this.add(button);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        Test test = new Test();
    }

}

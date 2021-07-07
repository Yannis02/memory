package view;

import control.Logik;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpielFertig {

    private JTextArea contentArea;
    private String gewinner;
    private Logik logik;
    private String test;
    private boolean Dojoker;
    private boolean Dotimer;

    public SpielFertig(int punkteSpieler1, int punkteSpieler2, boolean joker, boolean timer) {
        Dojoker = joker;
        Dotimer = timer;
        JDialog ende = new JDialog();
        JPanel buttonPanel = new JPanel();
        JPanel view = new JPanel();
        JButton startGUI = new JButton("Startmenü");
        JButton startNew = new JButton("Neues Spiel");
        JButton finish = new JButton("Beenden");

        ende.setTitle("Runde fertig");
        ende.setSize(820, 500);
        ende.setBackground(new Color(21, 76, 121));
        ende.setModal(true);

        if (punkteSpieler1 > punkteSpieler2) {
            gewinner = "1. Spieler";
        }
        if (punkteSpieler1 < punkteSpieler2) {
            gewinner = "2. Spieler";
        }
        if (punkteSpieler1 == punkteSpieler2) {
            gewinner = "Unentschieden";
        }
        if (punkteSpieler1 != punkteSpieler2) {
            contentArea = new JTextArea("Gratuliere, " + gewinner + ", Sie haben gewonnen, wollen Sie das Spiel" +
                    " beenden?\n\n Dann klicken Sie auf den Beenden Button!\n\n" +
                    "Wollen Sie jedoch ein neues Spiel starten,\nso drücken Sie auf den Neues Spiel Button:\n\n" +
                    "Wollen Sie wieder zurück ins Startmenü so drücken Sie Startmenü");
        }else {
            contentArea = new JTextArea(gewinner + " , wollen Sie das Spiel" +
                    " beenden?\n\n Dann klicken Sie auf den Beenden Button!\n\n" +
                    "Wollen Sie jedoch ein neues Spiel starten,\nso drücken Sie auf den Neues Spiel Button:\n\n" +
                    "Wollen Sie wieder zurück ins Startmenü so drücken Sie Startmenü");
        }
        contentArea.setFont(new Font("Impact", Font.PLAIN, 20));
        contentArea.setBackground(new Color(21, 76, 121));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50, 50, 50, 50));

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(finish, BorderLayout.EAST);
        buttonPanel.add(startNew, BorderLayout.CENTER);
        buttonPanel.add(startGUI, BorderLayout.WEST);
        buttonPanel.setBackground(new Color(21, 76, 121));

        view.setBackground(new Color(21, 76, 121));

        ende.add(contentArea, BorderLayout.NORTH);
        ende.add(buttonPanel, BorderLayout.SOUTH);
        ende.add(view, BorderLayout.CENTER);
        ende.setBackground(new Color(21, 76, 121));

        ende.setLocationRelativeTo(null);

        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Danke fürs Spielen!");
                System.exit(0);
            }
        });

        startNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ende.setVisible(false);
                newGameGUI newGameGUI = new newGameGUI(punkteSpieler1, punkteSpieler2, Dojoker, Dotimer);
            }
        });

        startGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ende.setVisible(false);
                App app = new App();
            }
        });
        ende.setVisible(true);

    }

}

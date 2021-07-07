package view;

import control.Logik;
import model.Spieler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newGameGUI {

    private JTextArea contentArea;
    private Logik logik;
    private Spieler spieler1;
    private Spieler spieler2;
    private int punkteSpieler1;
    private int punkteSpieler2;
    private boolean doJoker;
    private boolean doTimer;


    public newGameGUI(int punkte1, int punkte2, boolean joker, boolean timer) {
        doJoker = joker;
        doTimer = timer;
        punkteSpieler1 = punkte1;
        punkteSpieler2 = punkte2;
        JDialog ende = new JDialog();
        JPanel buttonPanel = new JPanel();
        JPanel view = new JPanel();
        JButton withScore = new JButton("Punkte übernehmen");
        JButton withoutScore = new JButton("Punkte nicht übernehmen");

        ende.setTitle("neues Spiel");
        ende.setSize(820, 500);
        ende.setBackground(new Color(21, 76, 121));
        ende.setModal(true);

        contentArea = new JTextArea("Hier haben Sie die Wahl, ob Sie die Punkte übernehmen wollen oder nicht!");
        contentArea.setFont(new Font("Impact", Font.PLAIN, 20));
        contentArea.setBackground(new Color(21, 76, 121));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50, 50, 50, 50));

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(withoutScore, BorderLayout.EAST);
        buttonPanel.add(withScore, BorderLayout.WEST);
        buttonPanel.setBackground(new Color(21, 76, 121));

        view.setBackground(new Color(21, 76, 121));

        ende.add(contentArea, BorderLayout.NORTH);
        ende.add(buttonPanel, BorderLayout.SOUTH);
        ende.add(view, BorderLayout.CENTER);
        ende.setBackground(new Color(21, 76, 121));

        ende.setLocationRelativeTo(null);

        withoutScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler spieler1 = new Spieler("1. Spieler");
                Spieler spieler2 = new Spieler("2. Spieler");
                Spiel spiel = new Spiel(spieler1, spieler2, doTimer, doJoker);
                ende.setVisible(false);
            }
        });

        withScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Spieler spieler1 = new Spieler("1. Spieler");
                Spieler spieler2 = new Spieler("2. Spieler");
                spieler1.setPunkte(punkteSpieler1);
                spieler2.setPunkte(punkteSpieler2);
                Spiel spiel = new Spiel(spieler1, spieler2, doTimer, doJoker);
                ende.setVisible(false);
            }
        });

        ende.setVisible(true);

    }

}

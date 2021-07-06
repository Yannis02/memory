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

    public newGameGUI() {
        JDialog ende = new JDialog();
        JPanel buttonPanel = new JPanel();
        JPanel view = new JPanel();
        JButton withScore = new JButton("Punkte nicht übernehmen");
        JButton withoutScore = new JButton("Punkte übernehmen");

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
                Spiel spiel = new Spiel(spieler1, spieler2);
            }
        });

        withScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spiel spiel = new Spiel(spieler1, spieler2);
            }
        });

        ende.setVisible(true);

    }

    public static void main(String[] args) {
        newGameGUI gui = new newGameGUI();
    }
}

package view;

import control.Logik;
import model.Spieler;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 * Klasse die ein GUI erstellt, welches für das Starten einer neuen Spielrunde zuständig ist
 */

public class newGameGUI {
    private JTextArea contentArea;
    private int punkteSpieler1;
    private int punkteSpieler2;
    private boolean doJoker;
    private boolean doTimer;

    /**
     * Konstruktor, dem die Punktzahlen der Vorrunde, und die Einstellungen ob
     * Joker und ob Stoppuhr gebraucht werden übergeben werden
     * @param punkte1
     * @param punkte2
     * @param joker
     * @param timer
     */
    public newGameGUI(int punkte1, int punkte2, boolean joker, boolean timer) {
        doJoker = joker;
        doTimer = timer;
        punkteSpieler1 = punkte1;
        punkteSpieler2 = punkte2;

        //Neuer Dialog
        JDialog dialog = new JDialog();
        JPanel buttonPanel = new JPanel();
        JPanel view = new JPanel();
        JButton withScore = new JButton("Punkte übernehmen");
        JButton withoutScore = new JButton("Punkte nicht übernehmen");

        //Einstellungen am Dialog
        dialog.setTitle("neues Spiel");
        dialog.setSize(820, 500);
        dialog.setBackground(new Color(21, 76, 121));
        dialog.setModal(true);

        //Textfeld
        contentArea = new JTextArea("Hier haben Sie die Wahl, ob Sie die Punkte übernehmen wollen oder nicht!");
        contentArea.setFont(new Font("Impact", Font.PLAIN, 20));
        contentArea.setBackground(new Color(21, 76, 121));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50, 50, 50, 50));

        //Buttons werden einem Panel hinzugefügt
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(withoutScore, BorderLayout.EAST);
        buttonPanel.add(withScore, BorderLayout.WEST);
        buttonPanel.setBackground(new Color(21, 76, 121));

        view.setBackground(new Color(21, 76, 121));

        //Dem Dialog werden die Komponenten hinzugefügt
        dialog.add(contentArea, BorderLayout.NORTH);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.add(view, BorderLayout.CENTER);
        dialog.setBackground(new Color(21, 76, 121));
        dialog.setLocationRelativeTo(null);

        //ActionListener um neue Spielrunde zu starten
        withoutScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler spieler1 = new Spieler("1. Spieler");
                Spieler spieler2 = new Spieler("2. Spieler");
                Spiel spiel = new Spiel(spieler1, spieler2, doTimer, doJoker);
                dialog.setVisible(false);
            }
        });

        //ActionListener um neue Spielrunde zu starten und Punkte zu übernehmen
        withScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Spieler spieler1 = new Spieler("1. Spieler");
                Spieler spieler2 = new Spieler("2. Spieler");
                spieler1.setPunkte(punkteSpieler1);
                spieler2.setPunkte(punkteSpieler2);
                Spiel spiel = new Spiel(spieler1, spieler2, doTimer, doJoker);
                dialog.setVisible(false);
            }
        });
        dialog.setVisible(true);
    }
}

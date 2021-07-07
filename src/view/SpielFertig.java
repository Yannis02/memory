package view;

import control.Logik;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 * Klasse, die das GUI erstellt, welches erscheint nachdem eine Spielrunde zu Ende ist
 */

public class SpielFertig {
    private JTextArea contentArea;
    private String gewinner;
    private boolean Dojoker;
    private boolean Dotimer;
    private long zeit;

    /**
     * Konstruktor, dem die Stoppuhr, die Punktzahlen der Vorrunde und die Einstellungen übergeben werden
     * @param time
     * @param punkteSpieler1
     * @param punkteSpieler2
     * @param joker
     * @param timer
     */
    public SpielFertig(long time, int punkteSpieler1, int punkteSpieler2, boolean joker, boolean timer) {
        Dojoker = joker;
        Dotimer = timer;
        zeit = time;

        //Neuer Dialog
        JDialog dialog = new JDialog();
        JPanel buttonPanel = new JPanel();
        JPanel view = new JPanel();
        JButton startGUI = new JButton("Startmenü");
        JButton startNew = new JButton("Neues Spiel");
        JButton finish = new JButton("Beenden");

        //Einstellungen am Dialog
        dialog.setTitle("Runde fertig");
        dialog.setSize(820, 500);
        dialog.setBackground(new Color(21, 76, 121));
        dialog.setModal(true);

        if (punkteSpieler1 > punkteSpieler2) {
            gewinner = "1. Spieler";
        }
        if (punkteSpieler1 < punkteSpieler2) {
            gewinner = "2. Spieler";
        }
        if (punkteSpieler1 == punkteSpieler2) {
            gewinner = "Unentschieden";
        }
        //Message falls die Stoppuhr nicht aktiviert wurde
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
        //Message falls die Stoppuhr aktiviert wurde
    if (timer == true) {
        if (punkteSpieler1 != punkteSpieler2) {
            contentArea = new JTextArea("Gratuliere, " + gewinner + ", Sie haben gewonnen,\n" +
                    "mit einer Zeit von: " + zeit + " Sekunden\nwollen Sie das Spiel" +
                    " beenden?\n\n Dann klicken Sie auf den Beenden Button!\n\n" +
                    "Wollen Sie jedoch ein neues Spiel starten,\nso drücken Sie auf den Neues Spiel Button:\n\n" +
                    "Wollen Sie wieder zurück ins Startmenü so drücken Sie Startmenü");
        } else {
            contentArea = new JTextArea(gewinner + " , wollen Sie das Spiel" +
                    " beenden?\n\n Dann klicken Sie auf den Beenden Button!\n\n" +
                    "Wollen Sie jedoch ein neues Spiel starten,\nso drücken Sie auf den Neues Spiel Button:\n\n" +
                    "Wollen Sie wieder zurück ins Startmenü so drücken Sie Startmenü");
        }
    }

        //Textfeld
        contentArea.setFont(new Font("Impact", Font.PLAIN, 20));
        contentArea.setBackground(new Color(21, 76, 121));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50, 50, 50, 50));

        //Buttons dem Buttonpanel hinzufügen
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(finish, BorderLayout.EAST);
        buttonPanel.add(startNew, BorderLayout.CENTER);
        buttonPanel.add(startGUI, BorderLayout.WEST);
        buttonPanel.setBackground(new Color(21, 76, 121));

        view.setBackground(new Color(21, 76, 121));

        dialog.add(contentArea, BorderLayout.NORTH);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.add(view, BorderLayout.CENTER);
        dialog.setBackground(new Color(21, 76, 121));

        dialog.setLocationRelativeTo(null);

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
                dialog.setVisible(false);
                newGameGUI newGameGUI = new newGameGUI(punkteSpieler1, punkteSpieler2, Dojoker, Dotimer);
            }
        });

        startGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                App app = new App();
            }
        });
        dialog.setVisible(true);
    }
}

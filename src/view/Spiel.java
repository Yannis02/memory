package view;

import control.Logik;
import control.Stoppuhr;
import model.Field;
import model.Spieler;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 * Diese Klasse erstellt das GUI, in welchem das Memory gespielt wird
 */

public class Spiel extends JFrame {
    Logik logik = new Logik();
    Field field;
    public boolean joker2 = false;
    public boolean timer2 = false ;
    private JButton firstOpenedCard = new JButton();
    private JButton secondOpenedCard = new JButton();

    private List<JButton> buttons = new ArrayList<>();

    private JLabel title;
    private JLabel points1;
    private JLabel points2;
    private JLabel name1;
    private JLabel name2;

    private JButton settings;
    private JButton beenden;

    private JPanel cardPanel;
    private JPanel buttonPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;

    private DecimalFormat decimalFormatPoints = new DecimalFormat("00");
    Stoppuhr stoppuhr = new Stoppuhr();

    /**
     * Konstrukot dem 2 Spieler und die Einstellungen übergeben werden
     * @param spieler1
     * @param spieler2
     * @param istimer
     * @param isjoker
     */
    public Spiel(Spieler spieler1, Spieler spieler2, Boolean istimer, boolean isjoker) {
        field = new Field(isjoker);
        timer2 = istimer;
        joker2 = isjoker;
        if (timer2== true){
            stoppuhr.start();
        }

        //Design
        setTitle("Memory");
        getContentPane().setBackground(new Color(21,76,121));
        setLayout(new BorderLayout(100, 0));

        //Einstellungen am GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);

        //Titel
        title = new JLabel("Memory", SwingConstants.CENTER);
        title.setFont(new Font("Impact", Font.PLAIN, 65));
        EmptyBorder emptyBorder = new EmptyBorder(80, 0, 100, 0);
        title.setBorder(emptyBorder);

        //Namens Ausgaben der beiden Spieler
        name1 = new JLabel(spieler1.getName());
        name2 = new JLabel(spieler2.getName());
        name1.setFont(new Font("Impact", Font.PLAIN, 35));
        name2.setFont(new Font("Impact", Font.PLAIN, 35));
        name1.setBackground(new Color(21,76,121));
        name2.setBackground(new Color(21,76,121));
        name1.setOpaque(true);
        name2.setOpaque(true);
        name1.setAlignmentX(Component.CENTER_ALIGNMENT);
        name2.setAlignmentX(Component.CENTER_ALIGNMENT);
        name1.setBorder(new LineBorder(new Color(21,76,121), 2));
        name2.setBorder(new LineBorder(new Color(21,76,121), 2));

        //Punkteausgaben der beiden Spieler
        points1 = new JLabel(decimalFormatPoints.format(spieler1.getPunkte()));
        points2 = new JLabel(decimalFormatPoints.format(spieler2.getPunkte()));
        points1.setFont(new Font("Impact", Font.PLAIN, 35));
        points2.setFont(new Font("Impact", Font.PLAIN, 35));
        points1.setBackground(new Color(21,76,121));
        points1.setOpaque(true);
        points2.setBackground(new Color(21,76,121));
        points2.setOpaque(true);
        points1.setBorder(new LineBorder(new Color(21,76,121), 2));
        points2.setBorder(new LineBorder(new Color(21,76,121), 2));
        points1.setAlignmentX(Component.CENTER_ALIGNMENT);
        points2.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Buttons
        settings = new JButton("Settings");
        beenden = new JButton("Beenden");


        //Buttons mit Karten Objekten erstellen
        for (int i = 0; i < 36; i++) {
            JButton button = new JButton(String.valueOf(field.getKarten().get(i).getWert()));
            button.setBackground(field.getKarten().get(i).getBackground());
            button.setText("");
            button.setBorder(new LineBorder(Color.black, 4));
            button.setOpaque(false);
            button.addActionListener(new kartenListener());
            buttons.add(button);

        }


        //Panel für die Karten mit den Buttons
        cardPanel = new JPanel(new GridLayout(6, 6, 40, 30));
        for (JButton button : buttons) {
            cardPanel.add(button);
        }

        //Design dieses Panels
        cardPanel.setBackground(new Color(21,76,121));
        cardPanel.setBorder(new EmptyBorder(0, 0, 100, 0));


        //Panel für die Buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(settings);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(beenden);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.setBackground(new Color(21,76,121));
        buttonPanel.setBorder(new EmptyBorder(100, 0, 30, 30));

        //Panel für die Spieler
        player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.PAGE_AXIS));
        player1Panel.add(name1);
        player1Panel.add(Box.createRigidArea(new Dimension(0, 45)));
        player1Panel.add(points1);
        player1Panel.setOpaque(false);
        player1Panel.setBorder(new EmptyBorder(0, 30, 0, 0));

        player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.PAGE_AXIS));
        player2Panel.add(name2);
        player2Panel.add(Box.createRigidArea(new Dimension(0, 45)));
        player2Panel.add(points2);
        player2Panel.setOpaque(false);
        player2Panel.setBorder(new EmptyBorder(0, 0, 0, 30));

        //Komponente werden dem GUI hinzugefügt
        getContentPane().add(title, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(player1Panel, BorderLayout.WEST);
        getContentPane().add(player2Panel, BorderLayout.EAST);
        setVisible(true);

        //ActionListener für den Settings Button
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Konfiguration config = new Konfiguration();
            }
        });

        //ActionListener für den Beenden Button
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                App app = new App();
            }
        });
        setVisible(true);
    }

    //ActionListener für die einzelnen Karten
    class kartenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (logik.getGedrehteKarten() == 0) {
                if (logik.isSpieler1IstAmZug()) {
                    name1.setBackground(new Color(21,76,121));
                    points1.setBackground(new Color(21,76,121));
                    name2.setBackground(Color.red);
                    points2.setBackground(Color.red);
                } else {
                    name1.setBackground(Color.red);
                    points1.setBackground(Color.red);
                    name2.setBackground(new Color(21,76,121));
                    points2.setBackground(new Color(21,76,121));
                }
                logik.setSourceCard1(String.valueOf(e.getSource()));
            } else {
                logik.setSourceCard2(String.valueOf(e.getSource()));
            }

            JButton sender = (JButton) e.getSource();
            sender.setEnabled(false);

            if (logik.isSpielerWechseln()) {
                twoTurnedNotEqual(firstOpenedCard, secondOpenedCard);
                logik.setSpielerWechseln(false);
            }
            sender.setForeground(Color.black);
            sender.setOpaque(true);
            logik.setGedrehteKarten(logik.getGedrehteKarten() + 1);

                //Falls die Karten identisch sind
            if (logik.checkgedrehteKarten() == true) {
                if (logik.compare(firstOpenedCard.getBackground(), sender.getBackground()) == true) {
                    twoTurnedEqual(firstOpenedCard, sender);
                }
                //Falls die Karten nicht identisch sind
                else {
                    logik.setSpielerWechseln(true);
                }
            } else {
                firstOpenedCard = sender;
            }
            secondOpenedCard = sender;
        }

        /**
         * 2 Karten sind umgedreht die nicht identisch sind
         * @param card1
         * @param card2
         */
        public void twoTurnedNotEqual(JButton card1, JButton card2) {
            card1.setOpaque(false);
            card1.setForeground(new Color(21,76,121));
            card2.setOpaque(false);
            card2.setForeground(new Color(21,76,121));
            card1.setEnabled(true);
            card2.setEnabled(true);
        }

        /**
         * 2 Karten sind umgedreht die identisch sind
         * @param card1
         * @param card2
         */
        public void twoTurnedEqual(JButton card1, JButton card2) {
            Color colorJoker = new Color(235,64,52);

            //Falls der 1. Spieler am Zug ist
            if (logik.isSpieler1IstAmZug() == true) {
                if (card2.getBackground().getRGB() == colorJoker.getRGB()){
                    points2.setText(String.valueOf(decimalFormatPoints.format(Integer.parseInt(points2.getText()) + 2)));
                }else {
                    points2.setText(String.valueOf(decimalFormatPoints.format(Integer.parseInt(points2.getText()) + 1)));
                }
            }

            //Falls der 2. Spieler am Zug ist
            else {
                if (card2.getBackground().getRGB() == colorJoker.getRGB()) {
                    points1.setText(String.valueOf(decimalFormatPoints.format(Integer.parseInt(points1.getText()) + 2)));

                } else {
                    points1.setText(String.valueOf(decimalFormatPoints.format(Integer.parseInt(points1.getText()) + 1)));
                }
            }

            //Einstellungen an den Karten
            card1.setBackground(Color.black);
            card2.setBackground(Color.black);
            card1.setText("");
            card2.setText("");
            card1.setEnabled(false);
            card2.setEnabled(false);

            //Falls alle Karten aufgedeckt wurden
            if (logik.getGefundenePaare() == field.getAnzahlKarten() / 2){

                //Falls die Stoppuhr aktiviert wurde
                if (timer2 == true) {
                    stoppuhr.stop();
                }
                setVisible(false);
                SpielFertig fertigesSpiel = new SpielFertig(stoppuhr.getTime(), Integer.parseInt(points1.getText()), Integer.parseInt(points2.getText()),joker2, timer2);
            }
        }
    }
}
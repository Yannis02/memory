package view;

import control.Logik;
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
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Spiel extends JFrame {

    Logik logik = new Logik();
    private JButton firstOpenedCard = new JButton();
    private JButton secondOpenedCard = new JButton();
    private Field field = new Field();

    private List<JButton> buttons = new ArrayList<>();

    private JLabel titleLabel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel pointLabel1;
    private JLabel pointLabel2;

    private JButton reset;
    private JButton beenden;
    private JButton hilfe;

    private JPanel cardPanel;
    private JPanel buttonPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;

    private DecimalFormat decimalFormatPoints = new DecimalFormat("000");


    public Spiel(Spieler spieler1, Spieler spieler2) {
        setTitle("Memory");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(255, 171, 0));
        setResizable(true);
        setLayout(new BorderLayout(100, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put("Button.disabledText", new ColorUIResource(Color.BLACK));//damit enabled buttons die Textfarbe schwarz haben


        titleLabel = new JLabel("Memory", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
        EmptyBorder titleborder = new EmptyBorder(80, 0, 100, 0);
        titleLabel.setBorder(titleborder);


        nameLabel1 = new JLabel(spieler1.getName());
        nameLabel2 = new JLabel(spieler2.getName());
        nameLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        nameLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        nameLabel1.setBackground(Color.white);
        nameLabel2.setBackground(Color.white);
        nameLabel1.setOpaque(true);
        nameLabel2.setOpaque(true);
        nameLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel1.setBorder(new LineBorder(Color.black, 4));
        nameLabel2.setBorder(new LineBorder(Color.black, 4));

        pointLabel1 = new JLabel(decimalFormatPoints.format(spieler1.getScore()));
        pointLabel2 = new JLabel(decimalFormatPoints.format(spieler2.getScore()));
        pointLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        pointLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        pointLabel1.setBackground(Color.white);
        pointLabel1.setOpaque(true);
        pointLabel2.setBackground(Color.white);
        pointLabel2.setOpaque(true);
        pointLabel1.setBorder(new LineBorder(Color.black, 4));
        pointLabel2.setBorder(new LineBorder(Color.black, 4));
        pointLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);


        //player1 = new JPlayerLabel();
        //player2 = new JPlayerLabel();


        reset = new JButton("Reset");
        beenden = new JButton("Beenden");
        hilfe = new JButton("Hilfe");


        //Karten-Buttons erstellen und zu List adden
        for (int i = 0; i < 36; i++) {
            JButton button = new JButton(String.valueOf(field.getCardVector().get(i).getValue()));
            //button.setBackground(new Color(255,255,255,0));
            button.setForeground(new Color(255, 171, 0));
            button.setBackground(field.getCardVector().get(i).getBackgroundcolor());
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            button.setBorder(new LineBorder(Color.black, 4));
            button.setOpaque(false);
            button.addActionListener(new cardbuttonListener());
            buttons.add(button);

        }


        //cardPanel
        cardPanel = new JPanel(new GridLayout(6, 6, 40, 30));
        for (JButton button : buttons) {
            cardPanel.add(button);
        }
        cardPanel.setBackground(new Color(255, 171, 0));
        cardPanel.setBorder(new EmptyBorder(0, 0, 100, 0));


        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(reset);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(beenden);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(hilfe);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.setBackground(new Color(255, 171, 0));
        buttonPanel.setBorder(new EmptyBorder(0, 0, 30, 0));

        //playerPanel
        player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.PAGE_AXIS));
        player1Panel.add(nameLabel1);
        player1Panel.add(Box.createRigidArea(new Dimension(0, 45)));
        player1Panel.add(pointLabel1);
        player1Panel.setOpaque(false);
        player1Panel.setBorder(new EmptyBorder(0, 30, 0, 0));

        player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.PAGE_AXIS));
        player2Panel.add(nameLabel2);
        player2Panel.add(Box.createRigidArea(new Dimension(0, 45)));
        player2Panel.add(pointLabel2);
        player2Panel.setOpaque(false);
        player2Panel.setBorder(new EmptyBorder(0, 0, 0, 30));


        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(player1Panel, BorderLayout.WEST);
        getContentPane().add(player2Panel, BorderLayout.EAST);


        setVisible(true);
    }

    public static void main(String[] args) {
    }


    class cardbuttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (logik.getAnzKartenGedreht() == 0) {
                logik.setSourceCard1(String.valueOf(e.getSource()));
            } else {
                logik.setSourceCard2(String.valueOf(e.getSource()));
            }

            JButton sender = (JButton) e.getSource();
            sender.setEnabled(false);
            //System.out.println(sender.getText());
            //sender.setBackground(Color.blue);
            if (logik.isSwitchPlayer()) {
                twoTurnedNotEqual(firstOpenedCard, secondOpenedCard);
                logik.setSwitchPlayer(false);
            }
            sender.setForeground(Color.black);
            sender.setOpaque(true);
            logik.setAnzKartenGedreht(logik.getAnzKartenGedreht() + 1);


            if (logik.checkAnzGedrehte() == true) {

                if (logik.compare(firstOpenedCard.getText(), firstOpenedCard.getBackground(), sender.getText(), sender.getBackground()) == true) {
                    twoTurnedEqual(firstOpenedCard, sender);
                } else {    //Karten sind kein Paar
                    logik.setSwitchPlayer(true);
                }
            } else {
                firstOpenedCard = sender;
            }
            secondOpenedCard = sender;

        }

        public void twoTurnedNotEqual(JButton card1, JButton card2) {
            card1.setOpaque(false);
            card1.setForeground(new Color(255, 171, 0));
            card2.setOpaque(false);
            card2.setForeground(new Color(255, 171, 0));
            card1.setEnabled(true);
            card2.setEnabled(true);

        }

        public void twoTurnedEqual(JButton card1, JButton card2) {
            card1.setBackground(Color.black);
            card2.setBackground(Color.black);
            card1.setText("");
            card2.setText("");
            card1.setEnabled(false);
            card2.setEnabled(false);

            if (logik.isPlayer1WillPlay() == true) {
                pointLabel1.setText(String.valueOf(decimalFormatPoints.format(Integer.parseInt(pointLabel1.getText()) + 1)));
            } else {
                pointLabel2.setText(String.valueOf(decimalFormatPoints.format(Integer.parseInt(pointLabel2.getText()) + 1)));
            }

            if (logik.getAnzPairsFound() == field.getAmountCards() / 2) {    //Spiel beendet?
                //glückwunsch-> modal?
                SpielFertig fertigesSpiel = new SpielFertig();
            }
        }
    }

    public void timeDelay() throws InterruptedException {
        Thread.sleep(2000);
    }


}
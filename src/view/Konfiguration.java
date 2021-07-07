package view;

import model.Config;
import model.Field;
import model.Spieler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yannis Lee / Maruthan Thanabalasingam
 * @version 1.0
 * @since 07.07.2021
 * Es wird ein GUI erstellt, welches die Setting in Comboboxen anzeigt und diese speichert,
 * über einen Click auf den OK Button
 */

public class Konfiguration extends JFrame {
    JPanel topPanel;
    JPanel midPanel;
    JPanel botPanel;
    JPanel jokerPanel;
    JLabel jokerLabel;
    JButton jokerSubmitButton;
    JPanel timerPanel;
    JLabel timerLabel;
    JButton timerSubmitButton;
    Config config = new Config();
    public boolean joker;
    public  boolean timer;
    String[] withJokerArray ={"No", "Yes"};
    JComboBox withJoker;
    String[] withTimerArray ={"No", "Yes"};
    JComboBox withTimer;
    JButton submitButton;
    Font original;
    Font titleFont;
    Color teal;
    Color mandarine;

    /**
     * Konstruktor der die init() Methode aufruft
     */
    public Konfiguration(){
        init();
    }

    /**
     * Methode, die den Ablauf der Methoden bestimmt
     */
    public void init(){
        set();
        modify();
        add();
        activate();
    }

    /**
     * Setzt die verschiedenen Komponenten zusammen
     */
    public void set(){
        //Panels
        topPanel =new JPanel();
        midPanel =new JPanel();
        botPanel =new JPanel();

        //mit einer Stoppuhr
        jokerPanel = new JPanel();
        jokerLabel = new JLabel("Do you want to play with a Timer?   ");
        jokerSubmitButton = new JButton("OK");
        withJoker = new JComboBox();
        withJoker.setModel(new DefaultComboBoxModel(withJokerArray));

        //mit einer Jokerkarte
        timerPanel = new JPanel();
        timerLabel = new JLabel("Do you want to play with Jokers?    ");
        timerSubmitButton = new JButton("OK");
        withTimer = new JComboBox();
        withTimer.setModel(new DefaultComboBoxModel(withTimerArray));

        //Speichern Button
        submitButton = new JButton("Save and Continue");

        //Design und Schriftarten
        original = new Font("Impact", Font.BOLD,18);
        titleFont = new Font("Impact", Font.BOLD,32);
        teal = new Color(170, 241, 237);
        mandarine = new Color(248, 205, 171);
    }

    /**
     * Getter für den Joker
     * @return joker
     */
    public boolean isJoker() {
        return joker;
    }

    /**
     * Getter für den Timer
     * @return timer
     */
    public boolean isTimer() {
        return timer;
    }

    /**
     * Setzt das Layout des mittleren Panels
     */
    public void modify(){
        midPanel.setLayout(new GridLayout(3,1));
    }

    /**
     * Fügt Komponenten den verschiedenen Panels zu
     */
    public void add(){
        this.getContentPane().add(topPanel,BorderLayout.NORTH);
        this.getContentPane().add(midPanel,BorderLayout.CENTER);
        this.getContentPane().add(botPanel,BorderLayout.SOUTH);
        midPanel.add(jokerPanel);
        midPanel.add(timerPanel);

        jokerPanel.add(jokerLabel,BorderLayout.WEST);
        jokerPanel.add(withJoker,BorderLayout.CENTER);
        jokerPanel.add(jokerSubmitButton,BorderLayout.EAST);
        timerPanel.add(timerLabel,BorderLayout.WEST);
        timerPanel.add(withTimer,BorderLayout.CENTER);
        timerPanel.add(timerSubmitButton,BorderLayout.EAST);
        botPanel.add(submitButton);
    }

    /**
     * Methode um das GUI zu aktivieren
     */
    public void activate(){
        this.pack();
        this.setTitle("Settings");
        this.addListener();
        this.setVisible(true);
    }


    /**
     * Fügt Listener den verschiedenen Buttons hinzu
     */
    public void addListener(){

        //OK Button beim Joker
        jokerSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (withJoker.getSelectedIndex() == 0){
               joker = false;
               } else if(withJoker.getSelectedIndex() == 1){
                   joker = true;
               }
            }
        });

        //OK Button beim Timer
        timerSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (withTimer.getSelectedIndex() == 0){
                timer = false;
                }
                else if(withTimer.getSelectedIndex() == 1){
                    timer = true;
                }
            }
        });

        //Save and Continue Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Spieler spieler1 = new Spieler("1. Spieler");
                Spieler spieler2 = new Spieler("2. Spieler");
                Spiel spiel = new Spiel(spieler1, spieler2, joker, timer);
            }
        });
    }
}

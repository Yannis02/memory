package view;

import model.Config;
import model.Field;
import model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maruthan Thanabalasingam
 * @version 0.9
 * @date 16-06-2021
 * Bei der Instanzierung wird ein JFrame-Objekt erzeugt und dies wird als Startfenster angezeigt.
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
    public static boolean variable;
    public boolean joker;
    public  boolean timer;

    public Konfiguration getKonfiguration() {
        return konfiguration;
    }

    public void setKonfiguration(Konfiguration konfiguration) {
        this.konfiguration = konfiguration;
    }

    Konfiguration konfiguration;


    String[] withJokerArray ={"No", "Yes"};
    JComboBox withJoker;
    String[] withTimerArray ={"No", "Yes"};
    JComboBox withTimer;
    JButton submitButton;
    //Attributes
    Font original;
    Font titleFont;
    Color teal;
    Color mandarine;
    public Konfiguration(){
        init();
    }

    public void init(){
        set();
        modify();
        add();
        activate();
    }
    public void set(){
        topPanel =new JPanel();
        midPanel =new JPanel();
        botPanel =new JPanel();
        //with Joker
        jokerPanel = new JPanel();
        jokerLabel = new JLabel("Do you want to play with a Timer?   ");
        jokerSubmitButton = new JButton("OK");
        withJoker = new JComboBox();
        withJoker.setModel(new DefaultComboBoxModel(withJokerArray));

        //with Timer
        timerPanel = new JPanel();
        timerLabel = new JLabel("Do you want to play with Jokers?    ");
        timerSubmitButton = new JButton("OK");
        withTimer = new JComboBox();
        withTimer.setModel(new DefaultComboBoxModel(withTimerArray));
        submitButton = new JButton("Save and Continue");
        original = new Font("Impact", Font.BOLD,18);
        titleFont = new Font("Impact", Font.BOLD,32);
        teal = new Color(170, 241, 237);
        mandarine = new Color(248, 205, 171);
    }

    public boolean isJoker() {
        return joker;
    }

    public boolean isTimer() {
        return timer;
    }

    public void modify(){
        midPanel.setLayout(new GridLayout(3,1));
    }
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
    public void activate(){
        this.pack();
        this.setTitle("Settings");
        this.addListener();
        this.setVisible(true);
    }




    public void addListener(){
        jokerSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (withJoker.getSelectedIndex() == 0){
                 config.setMitJoker(false);
               joker = false;}
               else if(withJoker.getSelectedIndex() == 1){
                   config.setMitJoker(true);
                   joker = true;
               }
            }
        });

        timerSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (withTimer.getSelectedIndex() == 0){
                    config.setMitTimer(false);
                timer = false;
                }
                else if(withTimer.getSelectedIndex() == 1){
                    config.setMitTimer(true);
                    timer = true;
                }
                 variable = timer;
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Spieler spieler1 = new Spieler("1. Spieler");
                Spieler spieler2 = new Spieler("2. Spieler");
                //Field field = new Field(joker);
                Spiel spiel = new Spiel(spieler1, spieler2, joker, timer);
            }
        });
    }
}

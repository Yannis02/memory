package view;

import model.Config;

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

    public Konfiguration getKonfiguration() {
        return konfiguration;
    }

    public void setKonfiguration(Konfiguration konfiguration) {
        this.konfiguration = konfiguration;
    }

    Konfiguration konfiguration;


    String[] withJokerArray ={"Yes", "No"};
    JComboBox withJoker;
    String[] withTimerArray ={"Yes", "No"};
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
        jokerLabel = new JLabel("Do you want to play with Jokers?   ");
        jokerSubmitButton = new JButton("OK");
        withJoker = new JComboBox();
        withJoker.setModel(new DefaultComboBoxModel(withJokerArray));
        //with Timer
        timerPanel = new JPanel();
        timerLabel = new JLabel("Do you want to play with Timer?    ");
        timerSubmitButton = new JButton("OK");
        withTimer = new JComboBox();
        withTimer.setModel(new DefaultComboBoxModel(withTimerArray));
        submitButton = new JButton("Save and Continue");
        original = new Font("Comic Sans MS", Font.BOLD,18);
        titleFont = new Font("Comic Sans MS", Font.BOLD,32);
        teal = new Color(170, 241, 237);
        mandarine = new Color(248, 205, 171);
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
                withJoker.getSelectedIndex();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test");
                setVisible(false);
                App app = new App();
            }
        });
    }

    public static void main(String[] args) {
        Konfiguration  k= new Konfiguration();
    }
}

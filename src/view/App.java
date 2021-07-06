package view;

import control.Logik;
import model.Spieler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private Logik logik;

    private JLabel titel;

    private JButton startGame;
    private JButton konfigurationen;
    private JButton ersteller;

    private JPanel buttonPanel;
    private JPanel buttonBoxPanel;

    private JPanel titlePanel;


    public App() {
        logik = new Logik();

        setTitle("Memory");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(21,76,121));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titel = new JLabel("Memory", SwingConstants.CENTER);
        titel.setForeground(Color.black);
        startGame = new JButton("Start Game");
        ersteller = new JButton("Made by");
        konfigurationen = new JButton("Settings");


        EmptyBorder border = new EmptyBorder(80, 0, 80, 0);
        titel.setBorder(border);

        titel.setFont(new Font("Impact", Font.PLAIN, 65));
        startGame.setFont(new Font("Impact", Font.PLAIN, 45));
        konfigurationen.setFont(new Font("Impact", Font.PLAIN, 45));
        ersteller.setFont(new Font("Impact", Font.PLAIN, 45));

        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        konfigurationen.setAlignmentX(Component.CENTER_ALIGNMENT);
        ersteller.setAlignmentX(Component.CENTER_ALIGNMENT);



        buttonBoxPanel = new JPanel();
        buttonBoxPanel.setLayout(new BoxLayout(buttonBoxPanel, BoxLayout.PAGE_AXIS));
        buttonBoxPanel.add(startGame);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(konfigurationen);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(ersteller);
        buttonPanel = new JPanel();
        buttonPanel.add(buttonBoxPanel);

        buttonBoxPanel.setBackground(new Color(21,76,121));
        buttonPanel.setBackground(new Color(21,76,121));


        getContentPane().setLayout(new BorderLayout(1, 1));
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(titel, BorderLayout.NORTH);

        //add ActionListener
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                logik.spiel();
            }
        });
        ersteller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Credits credits = new Credits();
            }
        });
        konfigurationen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Konfiguration konfiguration = new Konfiguration();
            }
        });



        setVisible(true);

    }

    public static void main(String[] args) {
        App app = new App();
        if (Konfiguration.variable == true){
            System.out.println("Timer");
        }
        if (Konfiguration.variable == false){
            System.out.println("Joker");
        }
    }


}

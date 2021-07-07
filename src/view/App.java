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
 */

public class App extends JFrame {
    private Logik logik;
    private JLabel titel;
    private JButton startGame;
    private JButton konfigurationen;
    private JButton ersteller;
    private JPanel buttons;
    private JPanel buttonPanel;
    private JPanel title;

    /**
     * Konstruktor der die Logik initialisiert und das StartGUI ladet
     */
    public App() {
        logik = new Logik();
        setTitle("Memory");
        getContentPane().setBackground(new Color(21,76,121));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);

        titel = new JLabel("Memory", SwingConstants.CENTER);
        titel.setForeground(Color.black);

        //Buttons
        startGame = new JButton("Start Game");
        ersteller = new JButton("Made by");
        konfigurationen = new JButton("Settings");

        //Border
        EmptyBorder emptyBorder = new EmptyBorder(75, 0, 75, 0);
        titel.setBorder(emptyBorder);

        //Setzen der Schriftart + Grösse der Buttons und des Titels
        titel.setFont(new Font("Impact", Font.PLAIN, 70));
        startGame.setFont(new Font("Impact", Font.PLAIN, 40));
        konfigurationen.setFont(new Font("Impact", Font.PLAIN, 40));
        ersteller.setFont(new Font("Impact", Font.PLAIN, 40));

        //Alignment für die Buttons
        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        konfigurationen.setAlignmentX(Component.CENTER_ALIGNMENT);
        ersteller.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Füllen des Buttonpanels mit den Buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(startGame);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonPanel.add(konfigurationen);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonPanel.add(ersteller);
        buttons = new JPanel();
        buttons.add(buttonPanel);

        //Setzen der Hintergrundfarben des Panels und der Buttons
        buttonPanel.setBackground(new Color(21,76,121));
        buttons.setBackground(new Color(21,76,121));

        //Setzen des Layouts und hinzufügen der Komponenten
        getContentPane().setLayout(new BorderLayout(1, 1));
        getContentPane().add(buttons, BorderLayout.CENTER);
        getContentPane().add(titel, BorderLayout.NORTH);

        //ActionListener für den StartGame Button
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                logik.spiel();
            }
        });
        //ActionListener für den Mady by Button
        ersteller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Credits credits = new Credits();
            }
        });
        //ActionListener für den Settings Button
        konfigurationen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Konfiguration konfiguration = new Konfiguration();
            }
        });
        setVisible(true);
    }

    /**
     * Main-Methode um das Memory zu starten
     * @param args
     */
    public static void main(String[] args) {
        App app = new App();
    }
}

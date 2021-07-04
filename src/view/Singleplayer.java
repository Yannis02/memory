package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Singleplayer extends JFrame{

    private List<JButton> buttons = new ArrayList<>();

    private JLabel titleLabel;
    private JLabel timerLabel;

    private JButton reset;
    private JButton beenden;
    private JButton hilfe;

    private JPanel cardPanel;
    private JPanel buttonPanel;


    public Singleplayer(){
        setTitle("Singlemode");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(253,253,39));
        setResizable(true);
        setLayout(new BorderLayout(100,0));


        titleLabel = new JLabel("Singleplayer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
        EmptyBorder titleborder = new EmptyBorder(80,0,100,0);
        titleLabel.setBorder(titleborder);

        timerLabel = new JLabel("timer folgt");
        timerLabel.setBackground(Color.white);
        timerLabel.setBorder(BorderFactory.createEmptyBorder(0,0,400,50));
        //timerLabel.setBorder(BorderFactory.createLineBorder(Color.black, 5));

        reset = new JButton("Reset");
        beenden = new JButton("Beenden");
        hilfe = new JButton("Hilfe");


        //Karten-Buttons erstellen und zu List adden
        for (int i = 1; i <= 36; i++) {
            buttons.add(new JButton(""));
        }



        //cardPanel
        cardPanel = new JPanel(new GridLayout(6,6,40,30 ));
        for (JButton button : buttons) {
            cardPanel.add(button);
        }
        cardPanel.setBackground(new Color(253,253,39));
        cardPanel.setBorder(new EmptyBorder(0,0,100,0));


        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(reset);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,45)));
        buttonPanel.add(beenden);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,45)));
        buttonPanel.add(hilfe);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,45)));
        buttonPanel.setBackground(new Color(253,253,39));
        buttonPanel.setBorder(new EmptyBorder(0,50,0,0));



        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(timerLabel, BorderLayout.EAST);




        setVisible(true);
    }

    public static void main(String[] args) {
        Singleplayer singleplayer = new Singleplayer();
    }
}

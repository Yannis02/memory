package view;
import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Erstellt einen Dialog um die Ersteller des Programmes anzugeben
 *
 * @author Yannis Lee
 * @version 1.0
 */
public class SetPlayers {
    String ersterSpieler;
    String zweiterSpieler;
    public SetPlayers(){
        JDialog dialog = new JDialog();
        JLabel label1 = new JLabel("Spieler 1");
        JLabel label2 = new JLabel("Spieler 2");
        JTextField spieler1 = new JTextField("Dies löschen");
        JTextField spieler2 = new JTextField("Dies löschen");
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        dialog.setTitle("Players");

        spieler1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        spieler1.setSize(100,500);
        spieler2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        spieler2.setSize(100,100);

        panel1.setLayout(new BorderLayout());
        panel1.add(label1, BorderLayout.WEST);
        panel1.add(spieler1, BorderLayout.EAST);

        panel2.setLayout(new BorderLayout());
        panel2.add(label2, BorderLayout.WEST);
        panel2.add(spieler2, BorderLayout.EAST);

        dialog.setSize(300,200);

        dialog.setModal(true);

        dialog.setLayout(new BorderLayout());

        dialog.add(panel1, BorderLayout.NORTH);
        dialog.add(panel2, BorderLayout.SOUTH);

        dialog.setVisible(true);
         ersterSpieler = spieler1.getText();
         zweiterSpieler = spieler2.getText();
    }

    public static void main(String[] args) {

        SetPlayers setPlayers = new SetPlayers();
        System.out.println(setPlayers.ersterSpieler);
        System.out.println(setPlayers.zweiterSpieler);

    }
}
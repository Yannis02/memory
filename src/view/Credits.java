package view;
import javax.swing.*;
import java.awt.*;

/**
 * Erstellt einen Dialog um die Ersteller des Programmes anzugeben
 *
 * @author Yannis Lee
 * @version 1.0
 */
public class Credits {
    public Credits(){
        JDialog dialog = new JDialog();
        JTextArea text = new JTextArea("Made by:\n" +
                "Yannis Lee \n" +
                "Maruthan Thanabalasingam \n" +
                "Jonas Rhybary \n");
        dialog.setTitle("Made by");

        text.setFont(new Font("Impact", Font.PLAIN, 20));

        dialog.setSize(300,200);

        dialog.setModal(true);

        dialog.add(text);

        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }

    public static void main(String[] args) {

        Credits credits = new Credits();

    }
}
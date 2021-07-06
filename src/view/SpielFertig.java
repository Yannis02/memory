package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SpielFertig {

    private JTextArea contentArea;

    public SpielFertig(){
        JDialog ueberUnsModal = new JDialog();

        ueberUnsModal.setTitle("Über uns");
        ueberUnsModal.setSize(450,400);
        ueberUnsModal.setModal(true);

        contentArea = new JTextArea("Test");
        contentArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50,50,50,50));

        ueberUnsModal.add(contentArea, BorderLayout.CENTER);

        ueberUnsModal.setLocationRelativeTo(null);
        ueberUnsModal.setVisible(true);

    }
}
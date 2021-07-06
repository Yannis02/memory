package view;

import model.Spieler;

import javax.swing.*;
import java.awt.*;

public class JPlayerLabel extends JPanel implements JplayerListModel{

    JPlayerLabelModel playerModel;
    JTextField name;
    JTextField score;

    public JPlayerLabel(JPlayerLabelModel playerModel){
        this.playerModel = playerModel;
        playerModel.setComponent(this);
        this.setLayout(new GridLayout(2,2));

        name = new JTextField(20);
        score =new JTextField(5);
        name.setEditable(false);
        score.setEditable(false);

        this.add(new JLabel("Name: "));
        this.add(name);
        this.add(new JLabel("Score: "));
        this.add(score);
    }

    @Override
    public void fireScoreChanged() {
        score.setText(String.valueOf(playerModel.getScore()));
    }

    @Override
    public void fireNameChanged() {
        name.setText(playerModel.getName());
    }


}

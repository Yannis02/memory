package model;

import view.JPlayerLabelModel;
import view.JplayerListModel;

public class Spieler implements JPlayerLabelModel {
    private String name;
    private int punkte;
    private long highscore;
    private JplayerListModel plm;

    public Spieler(){
    }

    public Spieler(String name){
        this.name = name;
        this.punkte = 0;
        this.highscore = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }



    @Override
    public int getScore() {
        return punkte;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setComponent(JplayerListModel plm) {
        this.plm = plm;
    }
}

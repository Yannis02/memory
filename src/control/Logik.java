package control;

import model.Field;
import model.Spieler;
import org.omg.CORBA.UserException;
import view.Spiel;

import javax.swing.*;
import java.awt.*;

public class Logik {
    private int anzKartenGedreht = 0;
    private int anzPairsFound = 0;
    private boolean player1WillPlay = false;
    private boolean switchPlayer=false;
    private String sourceCard1;
    private String sourceCard2;

    private Timer timer = new Timer();
    private Field field;
    private Spieler spieler;
    private Spiel spiel;

    public Logik() {
    }

    public void spiel() {
        Spieler spieler1 = new Spieler("1. Spieler");
        Spieler spieler2 = new Spieler("2. Spieler");
        Spiel spiel = new Spiel(spieler1, spieler2, false, false);
        

    }

    public void setAnzKartenGedreht(int anzKartenGedreht) {
        this.anzKartenGedreht = anzKartenGedreht;
    }

    public int getAnzKartenGedreht() {
        return anzKartenGedreht;
    }

    public int getAnzPairsFound() {
        return anzPairsFound;
    }

    public String getSourceCard1() {
        return sourceCard1;
    }

    public String getSourceCard2() {
        return sourceCard2;
    }

    public void setSourceCard1(String sourceCard1) {
        this.sourceCard1 = sourceCard1;
    }

    public void setSourceCard2(String sourceCard2) {
        this.sourceCard2 = sourceCard2;
    }

    public void setSwitchPlayer(boolean switchPlayer) {
        this.switchPlayer = switchPlayer;
    }

    public boolean isSwitchPlayer() {
        return switchPlayer;
    }

    public boolean isPlayer1WillPlay() {
        return player1WillPlay;
    }

    public boolean checkAnzGedrehte() {
        if (anzKartenGedreht == 2) {
            anzKartenGedreht = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean compare(String text1, Color color1, String text2, Color color2){

        if (text1.equals(text2) && color1 == color2){
            anzPairsFound++;
            return true;
        }else {
            player1WillPlay = !player1WillPlay; //changes bool to opposite
            return false;
        }
    }
}
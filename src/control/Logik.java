package control;

import model.Field;
import model.Spieler;
import view.Spiel;

import java.awt.*;

public class Logik {

    private int anzKartenGedreht = 0;
    private int anzPairsFound = 0;
    private boolean player1WillPlay = true;
    private boolean switchPlayer=false;
    private String sourceCard1;
    private String sourceCard2;

    private Timer timer;
    private Field field;
    private Spieler spieler;
    private Spiel spiel;

    public Logik() {
    }

    public void spiel() {
        Spieler spieler1 = new Spieler("Player One");
        Spieler spieler2 = new Spieler("Player Two");
        Spiel spiel = new Spiel(spieler1, spieler2);


        //Player player1 = new Player();
        //Player player2 = new Player();

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
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (text1.equals(text2) && color1 == color2){
            anzPairsFound++;
            return true;
        }else {
            player1WillPlay = !player1WillPlay; //changes bool to opposite
            return false;
        }
    }
}
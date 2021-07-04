package control;

import model.Field;
import model.Rangliste;
import model.Spieler;
import view.Spiel;
import view.Singleplayer;

import java.awt.*;

public class Logik {

    private int anzKartenGedreht = 0;

    private Timer timer;
    private Field field;
    private Spieler spieler;
    private Rangliste rangliste;
    private Spiel spiel;

    public Logik() {
    }

    public void multiplayer() {
        Spiel spiel = new Spiel();


        //Player player1 = new Player();
        //Player player2 = new Player();


    }

    public void singleplayer() {
        Spieler spieler = new Spieler();
    }

    public void setAnzKartenGedreht(int anzKartenGedreht) {
        this.anzKartenGedreht = anzKartenGedreht;
    }

    public int getAnzKartenGedreht() {
        return anzKartenGedreht;
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
        if (text1 == text2 && color1 == color2){
            return true;
        }else {
            return false;
        }
    }
}

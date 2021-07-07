package control;

import model.Field;
import model.Spieler;
import view.Spiel;
import java.awt.*;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 *Dies ist die Klasse in welcher die Logik des Memorys programmiert wird
 */
public class Logik {
    private int gedrehteKarten = 0;
    private int gefundenePaare = 0;
    private boolean spieler1IstAmZug = false;
    private boolean spielerWechseln=false;
    private String sourceCard1;
    private String sourceCard2;

    private Stoppuhr timer = new Stoppuhr();
    private Field field;
    private Spieler spieler;
    private Spiel spiel;

    /**
     * Leerer Konstruktor
     */
    public Logik() {
    }

    /**
     * Erstellt ein Memory-Spiel, welches 2 Spieler beinhaltet
     * und als Default-Werte keine Jokerkarten und keine Stoppuhr hat
     */
    public void spiel() {
        Spieler spieler1 = new Spieler("1. Spieler");
        Spieler spieler2 = new Spieler("2. Spieler");
        Spiel spiel = new Spiel(spieler1, spieler2, false, false);
    }

    /**
     *Setter für die Anzahl der gedrehten Karten
     * @param gedrehteKarten
     */
    public void setGedrehteKarten(int gedrehteKarten) {
        this.gedrehteKarten = gedrehteKarten;
    }

    /**
     * Getter für die Anzahl der gedrehten Karten
     * @return gedrehteKarten
     */
    public int getGedrehteKarten() {
        return gedrehteKarten;
    }

    /**
     * Getter für die Anzahl der gefundenen Paare
     * @return gefundenePaare
     */
    public int getGefundenePaare() {
        return gefundenePaare;
    }

    /**
     * Getter für die erste SourceKarte
     * @return sourceCard1
     */
    public String getSourceCard1() {
        return sourceCard1;
    }

    /**
     * Getter für die zweite SourceKarte
     * @return sourceCard2
     */
    public String getSourceCard2() {
        return sourceCard2;
    }

    /**
     * Setter für die erste SourceKarte
     * @param sourceCard1
     */
    public void setSourceCard1(String sourceCard1) {
        this.sourceCard1 = sourceCard1;
    }

    /**
     * Setter für die zweite SourceKarte
     * @param sourceCard2
     */
    public void setSourceCard2(String sourceCard2) {
        this.sourceCard2 = sourceCard2;
    }

    /**
     * Setter für die Variable um den Spieler zu wechseln
     * @param spielerWechseln
     */
    public void setSpielerWechseln(boolean spielerWechseln) {
        this.spielerWechseln = spielerWechseln;
    }

    /**
     * Getter um den Boolean spielerWechseln zu bekommen
     * @return spielerWechseln
     */
    public boolean isSpielerWechseln() {
        return spielerWechseln;
    }

    /**
     * Getter um den Boolean zu bekommen, ob Spieler 1 am Zug ist
     * @return spieler1IstAmZug
     */
    public boolean isSpieler1IstAmZug() {
        return spieler1IstAmZug;
    }

    /**
     * Checkt ob in diesem Zug schon 2 Karten aufgedeckt wurden,
     * wenn ja wird die Variable wieder auf 0 gesetzt
     * @return boolean
     */
    public boolean checkgedrehteKarten() {
        if (gedrehteKarten == 2) {
            gedrehteKarten = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vergleicht 2 Farben miteinander, falls Sie identisch sind werden die gefundenen Paare um 1 erhöht
     * wenn Sie nicht identisch sind, ist der andere Spieler am Zug
     * @param farbe1
     * @param farbe2
     * @return boolean
     */
    public boolean compare(Color farbe1, Color farbe2){

        if (farbe1 == farbe2){
            gefundenePaare++;
            return true;
        }else {
            spieler1IstAmZug = !spieler1IstAmZug; //changes bool to opposite
            return false;
        }
    }
}
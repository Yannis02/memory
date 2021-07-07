package model;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 * Klasse die einen Spieler erstellt
 */

public class Spieler {
    private String name;
    private int punkte;

    /**
     * Leerer Konstruktor
     */
    public Spieler(){
    }

    /**
     * Konstruktor mit einem Parameter für den Namen des Spielers
     * @param name
     */
    public Spieler(String name){
        this.name = name;
        this.punkte = 0;
    }

    /**
     * Setter für den Namen des Spielers
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter für den Namen eines Spielers
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für die Anzahl der Punkte die ein Spieler hat
     * @param punkte
     */
    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }


    /**
     * Getter für die Anzahl der Punkte die ein Spieler hat
     */
    public int getPunkte() {
        return punkte;
    }
}

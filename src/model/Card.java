package model;

import java.awt.*;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 *Dies ist die Klasse in welcher eine Karte, die dann auf einen Button kommt programmiert wird
 */

public class Card {
    private int wert;
    private final int points = 1;
    private Color background;

    /**
     * Leerer Konstruktor
     */
    public Card(){}

    /**
     * Setzt eine Farbe als Hintergrund, durch ihren RGB Wert
     * @param rot
     * @param grün
     * @param blau
     */
    public void setBackground(int rot, int grün, int blau){
        this.background = new Color(rot,grün,blau);
    }

    /**
     * Setter für den Wert
     * @param wert
     */
    public void setWert(int wert){
        this.wert = wert;
    }

    /**
     * Getter für den Wert einer Karte
     * @return wert
     */
    public int getWert(){
        return wert;
    }

    /**
     * Getter für die Hintergrundfarbe
     * @return background
     */
    public Color getBackground(){
        return background;
    }

    /**
     * Getter für die Punkte
     * @return points
     */
    public int getPoints(){
        return this.points;
    }
}

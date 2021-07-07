package model;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 * Klasse die eine Jokerkarte erstellt
 */
public class Joker extends Card{
    private final int points = 2;

    /**
     * Leerer Konstruktor
     */
    public Joker(){}

    @Override
    /**
     * Getter für die Anzahl der Punkte für eine Jokerkarte
     * @return points
     */
    public int getPoints() {
        return this.points;
    }
}

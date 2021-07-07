package model;

import java.util.Collections;
import java.util.Vector;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 *Dies ist die Klasse in welcher das Kartenfeld mit den verschiedenen Karten programmiert wird
 */

public class Field {
    private Vector<Card> karten;
    private int anzahlKarten = 36;
    private boolean jokerKarte = false;

    /**
     * Konstruktor, der al Parameter einen Boolean hat der sagt ob eine Jokerkarte gebraucht wird
     * @param isJoker
     */
    public Field(boolean isJoker) {
        karten = new Vector<>();
        jokerKarte = isJoker;
        makeCards();
    }

    /**
     * Methode die Karten erstellt, diese einem Vector hinzufügt,
     * falls es eine Jokerkarte braucht, wird diese erstellt und eine normale Karte entfernt
     */
    public void makeCards() {
        //Erstellen der Karten
        Card card1 = new Card();
        card1.setBackground(28,51,70);
        Card card2 = new Card();
        card2.setBackground(56,99,60);
        Card card3 = new Card();
        card3.setBackground(235,141,111);
        Card card4 = new Card();
        card4.setBackground(155,141,43);
        Card card5 = new Card();
        card5.setBackground(239,30,90);
        Card card6 = new Card();
        card6.setBackground(239,30,229);
        Card card7 = new Card();
        card7.setBackground(160,30,239);
        Card card8 = new Card();
        card8.setBackground(91,17,179);
        Card card9 = new Card();
        card9.setBackground(69,1,247);
        Card card10 = new Card();
        card10.setBackground(1,80,247);
        Card card11 = new Card();
        card11.setBackground(1,166,247);
        Card card12 = new Card();
        card12.setBackground(126,166,202);
        Card card13 = new Card();
        card13.setBackground(1,247,164);
        Card card14 = new Card();
        card14.setBackground(10,255,50);
        Card card15 = new Card();
        card15.setBackground(85,17,26);
        Card card16 = new Card();
        card16.setBackground(191,243,11);
        Card card17 = new Card();
        card17.setBackground(243,213,11);

        //Hinzufügen der Karten
        karten.add(card1);
        karten.add(card2);
        karten.add(card3);
        karten.add(card4);
        karten.add(card5);
        karten.add(card6);
        karten.add(card7);
        karten.add(card8);
        karten.add(card9);
        karten.add(card10);
        karten.add(card11);
        karten.add(card12);
        karten.add(card13);
        karten.add(card14);
        karten.add(card15);
        karten.add(card16);
        karten.add(card17);

        //Jokerkarte erstellen
        if (jokerKarte == true){
            Joker joker = new Joker();
            joker.setBackground(235,64,52);
            karten.add(joker);
        }
        //Normale 18te Karte erstellen
        else {
            Card card = new Card();
            card.setBackground(243,132,11);
            karten.add(card);
        }
        //Karten verdoppeln und mischen
        Vector doubleCards = (Vector) karten.clone();
        karten.addAll(17, doubleCards);
        Collections.shuffle(karten);
    }

    /**
     * Getter um die Karten zu bekommen
     * @return karten
     */
    public Vector<Card> getKarten() {
        return karten;
    }

    /**
     * Getter um die Anzahl der Karten zu bekommen
     * @return anzahlKarten
     */
    public int getAnzahlKarten() {
        return anzahlKarten;
    }
}

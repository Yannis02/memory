package model;

import java.util.Collections;
import java.util.Vector;

public class Field {

    private int length;
    private int height;
    private int amountCards = 36;
    private Vector<Card> cardVector;

    public Field() {
        cardVector = new Vector<>();
        erstelleKarten();
    }

    public void setFieldSize(int length, int height) {
        // amountCards = length * height;

    }

    public void erstelleKarten() {
        int value = 0;
        int counteri;
        int r = 255;
        int g = 0;
        int b = 0;

        for (counteri = 0; counteri < (amountCards - 0) / 2; counteri++) {  //noch -2 für Jokercard
            Card card = new Card();

            //value
            if (value < 10) {
                card.setValue(value);
            } else {
                value = 0;
                card.setValue(value);
            }
            value++;

            //color
            if (counteri < amountCards / 6) { //0-5
                if (counteri == 2) {
                    g = 200;
                } else if (counteri == 4) {
                    g = 0;
                    b = 200;
                }
            } else if (counteri < amountCards / 3) {   //6-11
                r = 0;
                g = 255;
                b = 0;
                if (counteri == 8) {
                    b = 200;
                } else if (counteri == 10) {
                    r = 200;
                    b = 0;
                }
            } else {
                r = 200;
                g = 200;
                b = 255;
                if (counteri == 14) {
                    r = 0;
                    g = 200;
                } else if (counteri == 16) {
                    r = 200;
                    g = 0;
                }
            }
            card.setBackgroundcolor(r, g, b);
            card.setIdentificator(counteri);

            cardVector.add(card);
        }
        Vector cloneVector = (Vector) cardVector.clone();
        cardVector.addAll(counteri, cloneVector);
        Collections.shuffle(cardVector);
    }


    public void fillField(Vector cardVector) {

    }

    public Vector<Card> getCardVector() {
        return cardVector;
    }
}

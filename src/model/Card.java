package model;

import java.awt.*;

public class Card {

    private final int pointsNormalCard = 1;
    private int value;
    private Color backgroundcolor;
    private int identificator;

    public Card(){

    }

    public void setBackgroundcolor(int r, int g, int b){
        this.backgroundcolor = new Color(r,g,b);
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setIdentificator(int identificator){
        this.identificator=identificator;
    }

    public void turn(){}

    public Color getBackgroundcolor(){
        return backgroundcolor;
    }

    public int getValue(){
        return value;
    }

    public int getIdentificator(){
        return identificator;
    }
}

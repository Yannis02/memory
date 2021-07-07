package model;

public class Joker extends Card{
    private final int pointsJokerCard = 2;

    public Joker(){}

    @Override
    public int getPointsCard() {
        return this.pointsJokerCard;
    }
}

package model;

public class Config {
    Boolean mitJoker;
    Boolean mitTimer;
    int spielfeldlaenge;
    int getSpielfeldBreite;

    public Config(){}

    public Boolean getMitJoker() {
        return mitJoker;
    }

    public void setMitJoker(Boolean mitJoker) {
        this.mitJoker = mitJoker;
    }

    public Boolean getMitTimer() {
        return mitTimer;
    }

    public void setMitTimer(Boolean mitTimer) {
        this.mitTimer = mitTimer;
    }

    public int getSpielfeldlaenge() {
        return spielfeldlaenge;
    }

    public void setSpielfeldlaenge(int spielfeldlaenge) {
        this.spielfeldlaenge = spielfeldlaenge;
    }

    public int getGetSpielfeldBreite() {
        return getSpielfeldBreite;
    }

    public void setGetSpielfeldBreite(int getSpielfeldBreite) {
        this.getSpielfeldBreite = getSpielfeldBreite;
    }
}

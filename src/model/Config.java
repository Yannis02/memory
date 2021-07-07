package model;

/**
 * @author Maruthan Thanabalasingam
 * @since 07.07.2021
 * @version 1.0
 * Konfigurationsklasse die dem KonfigurationsGUI hilft
 */
public class Config {
    Boolean mitJoker;
    Boolean mitStoppuhr;

    /**
     * Leerer Konstruktor
     */
    public Config(){}

    /**
     * Getter um herauszufinden ob mit Jokerkarten gespielt wird
     * @return mitJoker
     */
    public Boolean getMitJoker() {
        return mitJoker;
    }

    /**
     * Setter um zu setzen ob mit Jokerkarten gespielt wird
     * @param mitJoker
     */
    public void setMitJoker(Boolean mitJoker) {
        this.mitJoker = mitJoker;
    }

    /**
     * Getter um herauszufinden ob mit Stoppuhr gespielt wird
     * @return mitStoppuhr
     */
    public Boolean getMitStoppuhr() {
        return mitStoppuhr;
    }

    /**
     * Setter um zu setzen ob mit Stoppuhr gespielt wird
     * @param mitStoppuhr
     */
    public void setMitStoppuhr(Boolean mitStoppuhr) {
        this.mitStoppuhr = mitStoppuhr;
    }

}

package control;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.*;

/**
 * @author Yannis Lee
 * @since 07.07.2021
 * @version 1.0
 *Dies ist die Klasse in welcher die Logik der Stoppuhr programmiert wird
 */

public class Stoppuhr {
    private boolean amLaufen;
    private LocalTime start;
    private LocalTime finish;
    private long time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");

    /**
     * Leerer Konstruktor
     */
    public Stoppuhr() {}

    /**
     * Startet die Stoppuhr und setzt als Zeit die lokale Zeit
     */
    public void start() {
        this.start = LocalTime.parse(LocalTime.now().format(formatter));
    }

    /**
     * Stoppt die Stoppuhr
     */
    public void stop() {
        this.finish = LocalTime.parse(LocalTime.now().format(formatter));

    }

    /**
     * Setzt den Timer wieder auf Start zurück
     */
    public void reset() {
        long start = System.nanoTime();
    }

    /**
     * Gibt die Zeit, in welcher die Stoppuhr gelaufen ist in einem long zurück
     * @return time
     */
    public long getTime() {
        time = MILLIS.between(start,finish)/1000;
        return time;
    }
}

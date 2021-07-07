package control;

import java.time.Duration;
import java.time.LocalTime;

import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.*;

public class Timer {
    private boolean ongoing;
    private LocalTime start;
    private LocalTime finish;
    private long time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");


    public Timer() {
    }

    public void start() {
        this.start = LocalTime.parse(LocalTime.now().format(formatter));
    }

    public void stop() {
        this.finish = LocalTime.parse(LocalTime.now().format(formatter));

    }

    public void reset() {
        long start = System.nanoTime();
    }

    public long getTime() {
        System.out.println(start);
        System.out.println(finish);
        time = MILLIS.between(start,finish)/1000;
        return time;

    }

}

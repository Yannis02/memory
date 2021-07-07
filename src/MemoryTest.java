import model.Card;
import model.Joker;
import model.Spieler;
import org.junit.*;
import view.Konfiguration;
import view.Spiel;

import java.awt.*;

import static org.junit.Assert.* ;
public class MemoryTest {
    private static Spieler spieler;
    private static Spieler spieler2;
    private static Card card;
    private static Joker joker;
    private static Konfiguration config;
    private static Spiel spiel;
    @Before
    public void setUp(){
        spieler = new Spieler("1. Spieler");
        spieler2 = new Spieler("Yannis");
        card = new Card();
        card.setBackground(12,41,52);
        joker = new Joker();
        joker.setWert(2);
        config = new Konfiguration();
        spiel = new Spiel(spieler, spieler2, true, false);

    }
    @Test
    public void testName(){
        assertEquals("1. Spieler", spieler.getName());
    }
    @Test
    public void cardTest(){
        assertEquals(new Color(12,41,52), card.getBackground());
    }
    @Test
    public void jokerTest(){
        assertEquals(2, joker.getWert());
    }
    @Test
    public void defaultTest(){
        assertEquals(false,config.timer);
    }
    @Test
    public void spielTest(){
        assertEquals(true, spiel.timer2);
    }


}

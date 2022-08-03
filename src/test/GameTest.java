package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Game;
import src.main.models.Team;

public class GameTest {

    Game game;

    @Before
    /*
     * setup
     * 
     */
    public void setup() {
        Team home = new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] { "Angelina", "Ginny", "Katie" });
        Team away = new Team("SLYTHERIN", "Vincent", "Draco",
                new String[] { "Bridget", "Harper", "Malcolm" });

        game = new Game(home, away);

    }

    @Test
    public void getPlaceholderTest() {
        String testPosition = "chaser";
        assertEquals(testPosition, game.getPlaceholder(
                "<chaser> starts with the quaffle, speeds off towards the goal posts, and scores! 10 points!"));
    }

    @Test
    public void replacePlaceholderTest() {
        final String play = "<chaser> starts with the quaffle, speeds off towards the goal posts, and scores! 10 points!";
        final String placeholder = "chaser";
        final String value = "Katie";
        final String updatedPlay = "Katie starts with the quaffle, speeds off towards the goal posts, and scores! 10 points!";

        assertEquals(updatedPlay, game.replacePlaceholder(play, placeholder, value));

    }

    @Test
    public void quaffleScoreTest() {
        for (int i = 0; i < 2; i++) {
            game.quaffleScore(game.getTeam("GRYFFINDOR"));
        }
        assertEquals(20, game.getScore(game.getTeam("GRYFFINDOR")));
    }

    @Test
    public void setScoreTest() {
        game.setScore(game.getTeam("GRYFFINDOR"), 50);
        assertEquals(50, game.getScore(game.getTeam("GRYFFINDOR")));

    }

    @Test
    public void catchSnitchTest() {
        game.catchSnitch(game.getTeam("SLYTHERIN"));
        assertEquals(150, game.getScore(game.getTeam("SLYTHERIN")));

    }

}

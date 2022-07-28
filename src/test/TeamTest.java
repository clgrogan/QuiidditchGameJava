package src.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Team;

public class TeamTest {

  private Team team01;
  private Team copyTeam01;
  private Team team02;

  @Before
  public void setup() {

    team01 = new Team("GRYFFINDOR", "Oliver", "Harry",
        new String[] { "Angelina", "Ginny", "Katie" });
    copyTeam01 = new Team(team01);
    team02 = new Team("SLYTHERIN", "Vincent", "Draco",
        new String[] { "Bridget", "Harper", "Malcolm" });
  }

  @Test
  public void hasNullTest() {
    String[] chasers = new String[] { null, "Ginny", "Katie" };
    assertTrue(Team.arrayHasNull(chasers));
  }

  @Test
  public void hasEmptyTest() {
    String[] chasers = new String[] { "Beuford", "Ginny", "       " };
    assertTrue(Team.arrayHasBlank(chasers));

  }

  @Test
  public void equalsTest() {
    assertTrue(team01.equals(copyTeam01));
  }

}

package src.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import src.main.models.Team;

public class TeamTest {

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

}

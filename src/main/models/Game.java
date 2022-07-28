package src.main.models;

import java.util.HashMap;
import java.util.Optional;

public class Game {
  private HashMap<Team, Integer> scoreboard;
  private Team returnTeam = null;

  private static int gameCount;

  public Game(Team home, Team away) {
    scoreboard = new HashMap<Team, Integer>();
    scoreboard.put(new Team(home), 0);
    scoreboard.put(new Team(away), 0);
    gameCount++;
  }

  public Integer getScore(Team team) {
    return (this.scoreboard.get(team));
  }

  public void setScore(Team team, Integer score) {
    this.scoreboard.put(new Team(team), (score));
  }

  public static int getGameCount() {
    return gameCount;
  }

  public static void setGameCount(int parmGameCount) {
    gameCount = parmGameCount;
  }

  /**
   * getTeam
   * 
   * @param house
   * @return (Team)
   */
  public Team getTeam(String house) {
    this.returnTeam = null;

    scoreboard.keySet().forEach((key) -> {
      if (key.getHouse().equals(house)) {
        this.returnTeam = new Team(key);
      }
    });
    return this.returnTeam;
  }

  /**
   * getTeamRefactored
   * 
   * refactoring to eliminate need for the instance variable "returnTeam"
   * 
   * @param house
   * @return (Team)
   */
  public Team getTeamRefactored(String house) {
    Optional<Team> teamOptional = null;

    teamOptional = scoreboard.keySet().stream().filter((e) -> e.getHouse().equals(house)).findFirst();
    return teamOptional.isPresent() ? teamOptional.get() : null;
  }
}
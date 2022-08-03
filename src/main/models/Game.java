package src.main.models;

import java.util.HashMap;
import java.util.Optional;

public class Game {
  private HashMap<Team, Integer> scoreboard;
  private Team returnTeam = null;
  private final int QUAFFLE_POINTS = 10;
  private final int SNITCH_POINTS = 150;

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
    if (team == null || score == null)
      throw new IllegalArgumentException("Arguments may not be null");
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

  /**
   * getPlaceHolder
   * 
   * @param String
   * @return String
   */
  public String getPlaceholder(String play) {

    if (play == null || play.isEmpty())
      return null;

    int startSubstring = play.indexOf("<") + 1;
    int endSubstring = play.indexOf(">");
    if (startSubstring < 0
        || startSubstring >= play.length() - 2
        || startSubstring >= endSubstring
        || endSubstring < 1
        || endSubstring > play.length() - 1)
      return null;
    return play.substring(startSubstring, endSubstring);
  }

  public String replacePlaceholder(String play, String placeholder, String value) {

    return play.replace(("<" + placeholder + ">"), value);

  }

  public void quaffleScore(Team team) {
    scoreboard.put(team, scoreboard.get(team) + QUAFFLE_POINTS);
  }

  /**
   * 
   * @param Team
   */
  public void catchSnitch(Team team) {
    scoreboard.put(team, scoreboard.get(team) + SNITCH_POINTS);
  }

  public String simulate(String play) {
    String placeholder = getPlaceholder(play);
    Team randomTeam = new Team(getRandomTeam());

    if (placeholder.equals(Team.getPositionChaser())) {
      quaffleScore(randomTeam);
      return replacePlaceholder(play, placeholder, randomTeam.getChasers()[(int) (Math.random() * 3)]);
    } else if (placeholder.equals(Team.getPositionSeeker())) {
      catchSnitch(randomTeam);
      return replacePlaceholder(play, placeholder, randomTeam.getSeeker());
    } else if (placeholder.equals(Team.getPositionKeeper()))
      return replacePlaceholder(play, placeholder, randomTeam.getKeeper());
    return null;
  }

  public Team getRandomTeam() {
    return scoreboard.keySet().toArray(new Team[scoreboard.size()])[(int) (100 * Math.random() % 2)];
  }

}
package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.main.models.Game;
import src.main.models.Team;

public class MainOriginal {

        static Game game;
        static final String TEAMS_FILE = "src/main/teams.txt";
        static final String PLAYS_FILE = "src/main/plays.txt";

        public static void main(String[] args) {

                Team home = new Team("GRYFFINDOR", "Oliver", "Harry",
                                new String[] { "Angelina", "Ginny", "Katie" });
                Team away = new Team("SLYTHERIN", "Vincent", "Draco",
                                new String[] { "Bridget", "Harper", "Malcolm" });
                game = new Game(home, away);
                System.out.println();
                System.out.println(home);
                System.out.println(away);
                System.out.println();
                System.out.println("GET: game.getScore(home): " + game.getScore(home));
                game.setScore(home, 50);
                System.out.println("\nSET: game.setScore(home, 50)");
                System.out.println("\nGET: game.getScore(home): " + game.getScore(home));
                System.out.println();
                System.out.println("game.getTeam(" + home.getHouse() + "):\n" +
                                game.getTeam(home.getHouse()));
                System.out.println("\ngetTeam Refactored");
                System.out.println(
                                "game.getTeamRefactored(" + home.getHouse() + "):\n"
                                                + game.getTeamRefactored(home.getHouse()));

                System.out.println();
                System.out.println("Game.getGameCount(): " + Game.getGameCount());
                System.out.println("\n\tGame game2 = new Game(away, home);\n");
                Game game2 = new Game(away, home);
                System.out.println("Game.getGameCount(): " + Game.getGameCount());
                System.out.println();
                for (int i = 1; i <= 50; i++) {
                        System.out.print(game.getRandomTeam().getHouse());
                        if (i % 10 == 0)
                                System.out.println();
                        else
                                System.out.print(" ");
                }
                System.out.println();
        }

        /**
         * Function name: getData
         * 
         * @return (String[][])
         * @throws FileNotFoundException
         * 
         *                               Inside the function:
         *                               1. Returns data from TEAMS_FILE as a String[][]
         *                               array
         */
        public static String[][] getData() throws FileNotFoundException {
                FileInputStream fis = new FileInputStream(TEAMS_FILE);
                Scanner scanFile = new Scanner(fis);
                String[] rows = new String[] {
                                scanFile.nextLine(),
                                scanFile.nextLine() };
                scanFile.close();

                return new String[][] { rows[0].split(","), rows[1].split(",") };

        }

        /**
         * Function name: startGame
         * 
         * Inside the function:
         * 1. Grabs each play from plays.txt and calls game.simulate(play);
         * 2. Prints the return from game.simulate(play)
         * - println("\n" + <return> + "\n");
         */

        /**
         * Function name: printResult()
         * 
         * Inside the function:
         * 1. Prints the final score: println("\nGRYFFINDOR: " + <gryffindor score> + "
         * SLYTHERIN: " + <slytherin score>);
         * 2. Prints the winner: println("\n" + <winner team name> + " WINS!");
         * 
         */

        /**
         * Function name: wait
         * 
         * @param sec
         * 
         *            Inside the function:
         *            1. Make the code sleep for X seconds.
         */

}

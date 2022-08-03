package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.main.models.Game;
import src.main.models.Team;

public class Main {

        static Game game;
        static final String TEAMS_FILE = "src/main/teams.txt";
        static final String PLAYS_FILE = "src/main/plays.txt";

        public static void main(String[] args) {
                System.out.println("\n - - - - - Quidditch Bowl MCLVII - - - - -");
                System.out.println(
                                "\n\tSimulate a Quidditch game using input\n\tfrom files and outputing to terminal.\n");
                String[][] teamData = null;
                try {
                        teamData = getData();
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                game = new Game(
                                new Team(teamData[1][0], teamData[1][1], teamData[1][2], teamData[1][3], teamData[1][4],
                                                teamData[1][5]),
                                new Team(teamData[1][0], teamData[1][1], teamData[1][2], teamData[1][3], teamData[1][4],
                                                teamData[1][5]));

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
                                scanFile.nextLine(),
                                scanFile.nextLine() };
                scanFile.close();

                return new String[][] { rows[0].split(","), rows[1].split(",") };

        }

        public static String[] getPlays() throws FileNotFoundException {
                FileInputStream fis = new FileInputStream(TEAMS_FILE);
                Scanner scanFile = new Scanner(fis);
                String[] rows = new String[] {
                                scanFile.nextLine(),
                                scanFile.nextLine() };
                scanFile.close();

                return null;
        }

        /**
         * Function name: startGame
         * 
         * Inside the function:
         * 1. Grabs each play from plays.txt and calls game.simulate(play);
         * 2. Prints the return from game.simulate(play)
         * - println("\n" + <return> + "\n");
         */
        public void startGame() {
                String[] plays;

        }

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

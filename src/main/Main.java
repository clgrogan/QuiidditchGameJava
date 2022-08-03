package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Thread;

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
                                new Team(teamData[0][0], teamData[0][1], teamData[0][2], teamData[0][3], teamData[0][4],
                                                teamData[0][5]),
                                new Team(teamData[1][0], teamData[1][1], teamData[1][2], teamData[1][3], teamData[1][4],
                                                teamData[1][5]));
                try {
                        startGame();
                        printResult();
                } catch (Exception e) {
                        e.printStackTrace();
                }

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
        public static void startGame() throws Exception {
                String[] plays = null;

                try {
                        plays = getPlays();
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                if (plays == null || plays.length == 0)
                        throw new Exception("The plays file is invalid.");
                System.out.println();
                for (int i = 0; i < plays.length; i++) {
                        wait(2);
                        System.out.println(game.simulate(plays[i]) + "\n");
                }
                System.out.println();

        }

        /**
         * getPlays
         * 
         * @return String[]
         * @throws FileNotFoundException
         */
        public static String[] getPlays() throws FileNotFoundException {
                ArrayList<String> plays = new ArrayList<String>();
                FileInputStream fis = new FileInputStream(PLAYS_FILE);
                Scanner scanFile = new Scanner(fis);
                while (scanFile.hasNextLine())
                        plays.add(scanFile.nextLine());
                scanFile.close();

                return plays.toArray(new String[plays.size()]);
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
        public static void printResult() {
                final Team gryffindor = new Team(game.getTeam("GRYFFINDOR"));
                final Team slytherin = new Team(game.getTeam("SLYTHERIN"));
                final String winner = (game.getScore(gryffindor) > game.getScore(slytherin)) ? gryffindor.getHouse()
                                : slytherin.getHouse();
                System.out.println("\nGRYFFINDOR: " + game.getScore(gryffindor) + "\tSLYTHERIN: "
                                + game.getScore(slytherin) + "\n");
                System.out.println(winner + " WINS!\n");

        }

        /**
         * Function name: wait
         * 
         * @param sec
         * 
         *            Inside the function:
         *            1. Make the code sleep for X seconds.
         */
        public static void wait(int seconds) {
                try {
                        Thread.sleep(1000 * seconds);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

}

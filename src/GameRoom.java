/* Java.GameRoom
 *  William Deeds, Joseph Jager, and Jakob Mook
 *  11 May 2020
 *  Game Room is a program that will ask the user for their name and will save their
 *  name in a file that contains how many times the user has played each game. This program
 *  has a main class for the directory then it will have a class for each game.
 */

import java.util.Scanner;

public class GameRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        NumberGuess numberGuess = new NumberGuess();
        Connect4 connect4 = new Connect4();
        boolean loopEntry = false;
        String userName;
        String goAgain;
        int userWins = 0, computerWins = 0, ties = 0;
        String inputVal = "";

       do {
            System.out.println("Hello user, welcome to Game Room. \n"
                    + " Please input your name");
           userName = input.nextString;

       } while ();
    }
}

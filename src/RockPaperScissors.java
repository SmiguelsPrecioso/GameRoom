/* Java.GameRoom
 *  William Deeds
 *  11 May 2020
 *  This is the class for the Rock Paper Scissors game.
*/

 import java.util.Date;
         import java.util.Random;
         import java.util.Scanner;

public static class RockPaperScissors {
    //public static void main(String[] args) {
        long timeSeed = new Date().getTime();
        Random random = new Random(timeSeed);
        boolean loopEntry = false;
        Scanner scanner = new Scanner(System.in);
        int userWins = 0, computerWins = 0, ties = 0;
        String goAgain;
        String inputVal = "";
        String[] choices = {"Rock", "Paper", "Scissors"};
        do {
            int userChoice = 0;
            int compChoice = random.nextInt(3);
            do {
                System.out.print("Make a selection:\n 1 for Rock\n 2 for paper\n 3 for Scissors\n choose one: ");
                loopEntry = false;
                try {                                                      // Checks if user input a number between 1 & 3.
                    userChoice = Integer.valueOf(scanner.nextLine());
                    if (userChoice < 1 || userChoice > 3) loopEntry = true;
                } catch (Exception e) {
                    loopEntry = true;
                    System.out.println("You must enter an integer between 1 and 3 ");
                }
            } while (loopEntry);
            userChoice--;
            System.out.println("You chose " + choices[userChoice]);
            System.out.println("The computer chose " + choices[compChoice] + ". ");
            if (userChoice == compChoice) {                                              // checks if it's a tie
                System.out.println("It's a tie! ");
                ties ++;
            } else if (userChoice == compChoice + 1 || userChoice == compChoice - 2) {     //checks if user wins
                System.out.println("User is da winna! ");
                userWins ++;
            } else {                                                                        //checks if computer wins
                System.out.println("Computer is da winna!");
                computerWins ++;
            }            //I decided to count wins and losses, not ties. I did, because I felt that ties weren't a win or loss, so they shouldn't be counted.
            System.out.println("Do you want to play again (Y/N)? ");
            goAgain = scanner.nextLine();
            System.out.println("User won " + userWins + " times, computer won " + computerWins + " times, and there were " + ties + " ties. ");
            if (userWins == 0 && computerWins == 0) {
                System.out.println("The winning percentage is 0% \n" + "The losing percentage is 0%");
            } else {
                System.out.println("The winning percentage is " + (userWins / (computerWins + userWins) * 100) + "%. ");
                System.out.println("The losing percentage is " + (computerWins / (computerWins + userWins) * 100) + "%. ");
            }
        } while (!goAgain.toUpperCase().startsWith("N"));
    }
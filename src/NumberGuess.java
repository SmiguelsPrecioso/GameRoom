/* Java.GameRoom
 *  William Deeds
 *  11 May 2020
 *  This is the class for the Guess a Number game.
 */

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args){
        Scanner inputnum = new Scanner(System.in);  //This number will be the max number the player has to guess too.
        int maxnum;
        maxnum = inputnum.nextInt();
        Random rand = new Random();
        int number = rand.nextInt(maxnum);
        int tries = 0; //Will increase depending on how many tries it takes
        Scanner input = new Scanner(System.in);
        int guess;
        boolean win = false;

                System.out.println("Welcome to Guess a Number.\n"
                        + "Pick the size of the number pool: ");

                while (win == false){  //This while loop false the code with in it repeat until win === true

                    System.out.println("Guess a number between 1 and "+ maxnum +": ");
                    guess = input.nextInt();
                    tries++; //Increasing the number set in the variable tries by 1

                    if (guess == number){
                        win = true; //Since the number is correct win == true then ending the loop
                        //First thing the guess is compared too
                    }

                    else if(guess < number){
                        System.out.println("Number is to low, try again");
                        //2nd thing guess is compared too.
                    }

                    else if(guess > number){
                        System.out.println("Number is to high, try again");//3rd thing guess is compared too.
                    }
                }
                System.out.println("You win!");System.out.println("It took you "+ tries + " tries.");
     }
}

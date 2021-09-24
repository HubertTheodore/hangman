package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {// write your code here
	Scanner input = new Scanner(System.in);

	System.out.println("Welcome to Hangman!");
	System.out.println("Player 1 starts by writing a word");

	// Player 1 word
	String guessWord = input.next();
	char[] guessChars = guessWord.toCharArray();
	int wordLength = guessWord.length();

	// Process message for Player 2
	System.out.println("Now it's Player 2's turn to guess");
	int numGuessesLeft = 10;

	String hiddenWord = "";
	char[] hiddenChars = new char[wordLength];
	for(int i=0;i<wordLength;i++) {
	    hiddenChars[i] = '_';
    }

	// Begin game
        while(!hiddenWord.equals(guessWord)){
            String msg = String.format("Please guess a letter in this %d-letter word\n", wordLength);
            msg += String.format("You have %d guesses left\n", numGuessesLeft);
            System.out.println(msg);

            // Get Player 2 to guess
            String inputWord = input.next();
            char[] inputChars = inputWord.toCharArray();
            char inputChar = inputChars[0];
            System.out.println("Your guess: " + inputChar);

            // Check to see if the character guessed the letter in the word
            boolean guessedRight = false;
            for(int i=0;i<wordLength;i++) {
                char current_compare = guessChars[i];
                // Compare current character to player 2 inputChar
                if(inputChar == current_compare){
                    guessedRight = true;
                    hiddenChars[i] = inputChar;
                } // if player 2 guessed right
            } // Compare player 2 input to every char in hiddenWord

            if(!guessedRight){
                numGuessesLeft--;
            }

            if(numGuessesLeft == 0) {
                System.out.println("Oh no! You ran out of guesses. Better luck next time!");
                return;
            }

            hiddenWord = new String(hiddenChars);
            System.out.println("The word is: " + hiddenWord);

        }
        // While loop for entire game
        System.out.println();
    }


}

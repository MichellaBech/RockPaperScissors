package src;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner scan = new Scanner(System.in);

    private final HashMap<String, String> rules;

    //A HashMap where there are a key and a value saved.
    public Game() {
        rules = new HashMap<>();
        rules.put("Rock", "Scissors"); // a rule where "Rock" beats "Scissors"
        rules.put("Paper", "Rock");
        rules.put("Scissors", "Paper");
    }
    public void startGame() {
        System.out.println("Hello, welcome to Rock-Paper-Scissors game! Please write your name");
        String name = scan.nextLine();
        System.out.println("Are you 1 or 2 players?");
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("1"))
        {
            playWithComputer(name);
        } else {
            playTwoUsers (name);
        }
    }

    public void playTwoUsers (String name)
    {
        boolean continueWithGame = false;
        while (!continueWithGame) {
            System.out.println("What is the name of the other player?");
            String nameTwo = scan.nextLine();
            System.out.println("Let's play " + name + " and " + nameTwo + "! " + name + " begins. Please write Rock, Paper or Scissors");
            String choiceOne = scan.nextLine();
            System.out.println(nameTwo + " now it is your turn! Please write Rock, Paper or Scissors");
            String choiceTwo = scan.nextLine();
            System.out.println(name + ": " + choiceOne);
            System.out.println(nameTwo + ": " + choiceTwo);
            theBattleTwoUsers(choiceOne, choiceTwo, name, nameTwo);
            System.out.println("Do you want to play again? Y/N");
            String answerYN = scan.nextLine();
            if(answerYN.equalsIgnoreCase("Y"))
            {
                continueWithGame = false;
            } else {
                continueWithGame = true;
            }

        }

    }

    public void playWithComputer(String name)
    {
        boolean continueWithGame = false;
        while (!continueWithGame) {
            System.out.println("Let's play " + name + "! Please write Rock, Paper or Scissors");
            String userChoice = scan.nextLine();
            String computerChoice = rockPaperScissorsChoice();
            System.out.println(name + ": " + userChoice);
            System.out.println("Computer: " + computerChoice);
            theBattleWithComputer(computerChoice, userChoice);
            System.out.println("Do you want to play again? Y/N");
            String answerYN = scan.nextLine();
            if(answerYN.equalsIgnoreCase("Y"))
            {
                continueWithGame = false;
            } else {
                continueWithGame = true;
            }
        }

    }

    //Makes a random choice for the computer
    public String rockPaperScissorsChoice ()
    {
        Random random = new Random();
        int randomNumber = random.nextInt(3); // Generates a random number between 0 and 2

        String[] choices = {"Paper", "Rock", "Scissors"};
        return choices[randomNumber];
    }

    public void theBattleWithComputer(String computerChoice, String userChoice)
    {
        if (computerChoice.equalsIgnoreCase(userChoice))
        {
            System.out.println("It's a tie!");
        } else if (rules.get(computerChoice).equalsIgnoreCase(userChoice)) {
            System.out.println("The Computer wins!");
        } else {
            System.out.println("You win!");
        }

    }

    public void theBattleTwoUsers(String choiceOne, String choiceTwo, String nameOne, String nameTwo)
    {
        if (choiceOne.equalsIgnoreCase(choiceTwo))
        {
            System.out.println("It's a tie!");
        } else if (rules.get(choiceOne).equalsIgnoreCase(choiceTwo))
        {
            System.out.println(nameOne + " wins!");
        } else {
            System.out.println(nameTwo + " wins!");
        }
    }



}

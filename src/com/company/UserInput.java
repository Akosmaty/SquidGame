package com.company;

import java.util.Scanner;

public class UserInput {
    String userGuess;
    int userBallsNumberInHand;
    String userChooose;
    private final Scanner scanner = new Scanner(System.in);


    public int userBallInHand() {
        userBallsNumberInHand = scanner.nextInt();


        return userBallsNumberInHand;
    }

    public String userGuess() {
        userGuess = scanner.nextLine();

        return userGuess;
    }

}

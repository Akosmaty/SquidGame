package com.company;

import java.util.Scanner;

public class UserInput {
    private String userGuess;
    private int userBallsNumberInHand;
    private Scanner scanner= new Scanner(System.in);


    public int UserBallInHand(){
        userBallsNumberInHand = scanner.nextInt();


        return userBallsNumberInHand ;
    }
    public String UserGuess(){
        userGuess = scanner.nextLine();

        return userGuess;
    }
}

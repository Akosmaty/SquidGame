package com.company;

import java.util.Scanner;

public class UserInput {
  private final Scanner scanner = new Scanner(System.in);
  String userGuess;
  int userBallsNumberInHand;
  String userChooose;

  public int userBallInHand() {
    userBallsNumberInHand = scanner.nextInt();

    return userBallsNumberInHand;
  }

  public String userGuess() {
    userGuess = scanner.nextLine();

    return userGuess;
  }
}

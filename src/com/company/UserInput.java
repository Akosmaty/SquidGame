package com.company;

import java.util.Scanner;

public class UserInput {
  final Scanner scanner = new Scanner(System.in);

  int userBallInHand() {

    return scanner.nextInt();
  }

  String userGuess() {

    return scanner.nextLine();
  }
}

package com.company;

import java.util.Scanner;

public class GameLogic {
  NpcInput npcInput = new NpcInput();
  UserInput userInput = new UserInput();
  private int userBalls = 20;
  private int npsBalls = 20;
  private int userBallsInHand;
  private int npcBallsInHand;
  private String userGuess;
  private boolean npcGuess;

  public void startGame() {
    // if Npc guess = true -> paired, if falls -> unpaired
    while (true) {
      userTurn();

      npcTurn();
    }
  }

  public void userTurn() {
    {
      npcBallsInHand = npcInput.ballsInHand(npsBalls);

      System.out.println("posiadasz: " + userBalls + " kulek, ile chcesz wlozyc do reki?");

      userBallsInHand = userInput.userBallInHand();

      while (userBallsInHand > userBalls) {
        userCheater();
      }
      System.out.println(
          "Zgadnij czy Twoj przeciwnik ma parzysta(kliknij P) czy nieparzysta(kliknij N liczbe kulek w rece. ");
      userGuess = userInput.userGuess();
      while (!(userGuess.equalsIgnoreCase("P") || userGuess.equalsIgnoreCase("N"))) {
        userMoron();
      }
      System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);

      userTurnLogic();
      if (((userBalls <= 0) || (userBalls >= 40))) endGame();
    }
  }

  public void npcTurn() {

    npcBallsInHand = npcInput.ballsInHand(npsBalls);
    System.out.println("posiadasz: " + userBalls + " kulek. ile z nich chcesz wlozyc do reki");
    userBallsInHand = userInput.userBallInHand();
    while (userBallsInHand > userBalls) {
      userCheater();
    }
    this.npcGuess = npcInput.npcGuess();
    System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);
    System.out.println(
        "Przecwinik powiedział  " + npcGuess + " że masz parzysta liczbe kulek w reku");
    npsTurnLogic();
    if (((userBalls <= 0) || (userBalls >= 40))) endGame();
  }

  public void npsTurnLogic() {
    if (userBallsInHand % 2 == 0 && npcGuess) {
      userBalls = userBalls - npcBallsInHand;
      npsBalls = npsBalls + npcBallsInHand;
    }
    if (userBallsInHand % 2 == 0 && !npcGuess) {
      npsBalls = npsBalls - npcBallsInHand;
      userBalls = userBalls + npcBallsInHand;
    }
    if (userBallsInHand % 2 == 1 && !npcGuess) {
      userBalls = userBalls - npcBallsInHand;
      npsBalls = npsBalls + npcBallsInHand;
    }
    if (userBallsInHand % 2 == 1 && npcGuess) {
      npsBalls = npsBalls - npcBallsInHand;
      userBalls = userBalls + npcBallsInHand;
    }
  }

  private void userTurnLogic() {
    if (npcBallsInHand % 2 == 0 && (userGuess.equalsIgnoreCase("P"))) {
      npsBalls = npsBalls - userBallsInHand;
      userBalls = userBalls + userBallsInHand;
    }
    if (npcBallsInHand % 2 == 0 && (userGuess.equalsIgnoreCase("N"))) {
      userBalls = userBalls - userBallsInHand;
      npsBalls = npsBalls + userBallsInHand;
    }
    if (npcBallsInHand % 2 == 1 && (userGuess.equalsIgnoreCase("N"))) {
      npsBalls = npsBalls - userBallsInHand;
      userBalls = userBalls + userBallsInHand;
    }
    if (npcBallsInHand % 2 == 1 && (userGuess.equalsIgnoreCase("P"))) {
      userBalls = userBalls - userBallsInHand;
      npsBalls = npsBalls + userBallsInHand;
    }
  }

  private void userCheater() {

    System.out.println("Nie mozesz postawic wiecej kulek niz masz!!!!!");
    System.out.println("Pozostalo Ci " + userBalls + " kulek");
    userBallsInHand = userInput.userBallInHand();
  }

  private void userMoron() {
    System.out.println("wpisz poprawny znak P- parzysta, N - nieparzysta");
    userGuess = userInput.userGuess();
  }

  private void endGame() {

    System.out.println(
        "Twoja liczba kulek to " + userBalls + " liczba kulek przeciwnika to " + npsBalls + "\n");

    System.out.println(
        "Jesli chcesz rozpoczac nowa gre kliklnij Y, w przeciwnym wypadku kliknij dowolny klawisz i zatwierdz enterem");
    Scanner sc = new Scanner(System.in);
    String userPlayOrLeave = sc.nextLine();

    if (userPlayOrLeave.equalsIgnoreCase("y")) {
      userBalls = 20;
      npsBalls = 20;
      startGame();
    } else System.exit();
  }
}

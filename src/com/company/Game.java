package com.company;

import java.util.ArrayList;

public class Game {
  NpcInput npcInput = new NpcInput();
  UserInput userInput = new UserInput();
  private final int maxBallsInStock = gameRules();
  ArrayList<Integer> list = new ArrayList<>();
  Logic logic = new Logic();
  private int userBalls = maxBallsInStock;
  private int npsBalls = maxBallsInStock;
  private int userBallsInHand;
  private int npcBallsInHand;
  private String userGuess;
  private boolean npcGuess;
  private boolean userGuessInBoolean;

  public void startGame() {
    // if Npc guess = true -> paired, if falls -> unpaired
  while(true){
    userTurn();
    npcTurn();
    }
  }

  public void userTurn() {
    {
      npcBallsInHand = npcInput.ballsInHand(npsBalls);

      System.out.println("posiadasz: " + userBalls + " kulek, ile chcesz wlozyc do reki?");

      userBallsInHand = userInput.userBallInHand();

      antycheat();

      System.out.println(
          "Zgadnij czy Twoj przeciwnik ma parzysta(kliknij P) czy nieparzysta(kliknij N liczbe kulek w rece. ");
      userGuess = userInput.userGuess();

      playerGuessValidator();
      list.add(userBallsInHand);
      list.add(npcBallsInHand);
      userGuessInBoolean = userGuessTranslator(userGuess);
      list.add(userBalls);
      list.add(npsBalls);
      logic.setParameters(list, userGuessInBoolean);

      System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);

      logic.turnLogic();
      userBalls = logic.activePlayerBallsInStack;
      npsBalls = logic.passivePlayerBallsInStack;
      list.clear();
      endTurnChecker();
    }
  }

  public void npcTurn() {

    npcBallsInHand = npcInput.ballsInHand(npsBalls);
    System.out.println("posiadasz: " + userBalls + " kulek. ile z nich chcesz wlozyc do reki");
    userBallsInHand = userInput.userBallInHand();

    antycheat();

    list.add(npcBallsInHand);
    list.add(userBallsInHand);
    this.npcGuess = npcInput.npcGuess();
    list.add(npsBalls);
    list.add(userBalls);

    logic.setParameters(list, npcGuess);
    System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);
    System.out.println(
        "Przecwinik powiedział  " + npcGuess + " że masz parzysta liczbe kulek w reku");

    logic.turnLogic();
    userBalls = logic.passivePlayerBallsInStack;
    npsBalls = logic.activePlayerBallsInStack;
    list.clear();

    endTurnChecker();
  }

  private void antycheat() {
    while (userBallsInHand > userBalls) {
      System.out.println("Nie mozesz postawic wiecej kulek niz masz!!!!!");
      System.out.println("Pozostalo Ci " + userBalls + " kulek");
      userBallsInHand = userInput.userBallInHand();
    }
  }

  private void playerGuessValidator() {
    while (!(userGuess.equalsIgnoreCase("P") || userGuess.equalsIgnoreCase("N"))) {
      System.out.println("wpisz poprawny znak P- parzysta, N - nieparzysta");
      userGuess = userInput.userGuess();
    }
  }

  private void endTurnChecker() {
    if (((userBalls <= 0) || (userBalls >= maxBallsInStock * 2))) endGame();
  }

  private void endGame() {

    System.out.println(
        "Twoja liczba kulek to " + userBalls + " liczba kulek przeciwnika to " + npsBalls + "\n");

    System.out.println(
        "Jesli chcesz rozpoczac nowa gre kliklnij Y, w przeciwnym wypadku kliknij dowolny klawisz i zatwierdz enterem");

    String userPlayOrLeave = userInput.userGuess();

    if (userPlayOrLeave.equalsIgnoreCase("y")) {
      userBalls = maxBallsInStock;
      npsBalls = maxBallsInStock;
      startGame();
    }  System.exit(2);
  }

  private int gameRules() {
    System.out.println(
        "Podaj liczbe początkową kulek, aby zmienic liczbe poczatkowa kulek w trakcie gry nalezy ją zresetować");
    return userInput.userBallInHand();
  }

  private boolean userGuessTranslator(String userGuess) {
    return userGuess.equalsIgnoreCase("p");
  }
}

package com.company;

public class GameLogic {
  NpcInput npcInput = new NpcInput();
  UserInput userInput = new UserInput();
  private final int maxBallsInStock = gameRules();

  private int userBalls = maxBallsInStock;
  private int npsBalls = maxBallsInStock;
  private int userBallsInHand;
  private int npcBallsInHand;
  private String userGuess;
  private boolean npcGuess;

  public void startGame() {
    // if Npc guess = true -> paired, if falls -> unpaired

    userTurn();
    npcTurn();
    startGame();
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

      System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);

      userTurnLogic();
      endTurnChecker();
    }
  }

  public void npcTurn() {

    npcBallsInHand = npcInput.ballsInHand(npsBalls);
    System.out.println("posiadasz: " + userBalls + " kulek. ile z nich chcesz wlozyc do reki");
    userBallsInHand = userInput.userBallInHand();

    antycheat();

    this.npcGuess = npcInput.npcGuess();

    System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);
    System.out.println(
        "Przecwinik powiedział  " + npcGuess + " że masz parzysta liczbe kulek w reku");
    npsTurnLogic();
    endTurnChecker();
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
    } else System.exit(2);
  }

  private int gameRules() {
    System.out.println(
        "Podaj liczbe początkową kulek, aby zmienic liczbe poczatkowa kulek w trakcie gry nalezy ją zresetować");
    return userInput.userBallInHand();
  }
}

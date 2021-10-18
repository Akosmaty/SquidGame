package com.company;

public class GameLogic {
  NpcInput npcInput = new NpcInput();
  UserInput userInput = new UserInput();
  private int userBalls = 20;
  private int npsBalls = 20;
  private int userBallsInHand;
  private int npcBallsInHand;
  private String userGuess;
  private boolean npcGuess;
  private String userChoose = "Y";

  public void startGame() {
    // if Npc guess = true -> paired, if falls -> unpaired
    while (true) {
      if (!((userBalls <= 0) || (userBalls >= 40))) userTurn();

      if (!((userBalls <= 0 || userBalls >= 40))) npsTurn();
      else {
        System.out.println(
            "Twoja liczba kulek to " + userBalls + " liczba kulek przeciwnika to " + npsBalls);
        userBalls = 20;
        npsBalls = 20;
        break;
      }
    }
    restartGame();
  }

  public void userTurn() {
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
  }

  public void npsTurn() {
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
  }

  public void npsTurnLogic() {
    if (userBallsInHand % 2 == 0 && npcGuess) {
      userBalls = userBalls - npcBallsInHand;
      npsBalls = npsBalls + npcBallsInHand;
    }
    if (userBallsInHand % 2 == 0 && !npcGuess) {
      npsBalls = npsBalls - userBallsInHand;
      userBalls = userBalls + userBallsInHand;
    }
    if (userBallsInHand % 2 == 1 && !npcGuess) {
      userBalls = userBalls - npcBallsInHand;
      npsBalls = npsBalls + npcBallsInHand;
    }
    if (userBallsInHand % 2 == 1 && npcGuess) {
      npsBalls = npsBalls - userBallsInHand;
      userBalls = userBalls + userBallsInHand;
    }
  }

  private void userTurnLogic() {
    if (npcBallsInHand % 2 == 0 && (userGuess.equalsIgnoreCase("P"))) {
      npsBalls = npsBalls - userBallsInHand;
      userBalls = userBalls + userBallsInHand;
    }
    if (npcBallsInHand % 2 == 0 && (userGuess.equalsIgnoreCase("N"))) {
      userBalls = userBalls - npcBallsInHand;
      npsBalls = npsBalls + npcBallsInHand;
    }
    if (npcBallsInHand % 2 == 1 && (userGuess.equalsIgnoreCase("N"))) {
      npsBalls = npsBalls - userBallsInHand;
      userBalls = userBalls + userBallsInHand;
    }
    if (npcBallsInHand % 2 == 1 && (userGuess.equalsIgnoreCase("P"))) {
      userBalls = userBalls - npcBallsInHand;
      npsBalls = npsBalls + npcBallsInHand;
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

  private void restartGame() {
    System.out.println(
        "Jesli chcesz rozpoczac nowa gre kliklnij Y, w przeciwnym wypadku kliknij dowolny klawisz i zatwierdz enterem");
    userChoose = userInput.userGuess();
    if (userChoose.equalsIgnoreCase("y")) {
      startGame();
    }
  }
}

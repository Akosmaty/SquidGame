package com.company;

public class GameLogic {
    int userBalls = 10;
    int npsBalls = 10;
    int userBallsInHand;
    int npcBallsInHand;
    String userGuess;
    boolean npcGuess;

    public void StartGame() {
        // if Npc guess = true -> paired, if falls -> unpaired
        while (true) {
            if (!((userBalls <= 0) || (userBalls >= 20)))

                UserTurn();
            if (!((userBalls <= 0 || userBalls >= 20)))
                NpsTurn();
            else {
                System.out.println("Twoja liczba kulek to " + userBalls + " liczba kulek przeciwnika to " + npsBalls);
                break;
            }
        }
    }

    public void UserTurn() {
        npcBallsInHand = new NpcInput().BallsInHand(npsBalls);

        System.out.println("posiadasz: " + userBalls + " kulek, ile chcesz wlozyc do reki?");

        userBallsInHand = new UserInput().UserBallInHand();

        while (userBallsInHand > userBalls) {
            UserCheater();
        }
        System.out.println("Zgadnij czy Twoj przeciwnik ma parzysta(kliknij P) czy nieparzysta(kliknij N liczbe kulek w rece. ");
        userGuess = new UserInput().UserGuess();
        while (!(userGuess.equals("P") || userGuess.equals("p") || userGuess.equals("N") || userGuess.equals("n"))) {
            UserMoron();
        }
        System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);

        UserTurnLogic();

    }

    public void NpsTurn() {
        npcBallsInHand = new NpcInput().BallsInHand(npsBalls);
        System.out.println("posiadasz: " + userBalls + " kulek. ile z nich chcesz wlozyc do reki");
        userBallsInHand = new UserInput().UserBallInHand();
        while (userBallsInHand > userBalls) {
            UserCheater();
        }
        this.npcGuess = new NpcInput().NpcGuess();
        System.out.println("libcza kulek w ręku przeciwnika: " + npcBallsInHand);
        System.out.println("Przecwinik powiedział  " + npcGuess + " że masz parzysta liczbe kulek w reku");
        NpsTurnLogic();

    }

    public void NpsTurnLogic() {
        if (userBallsInHand % 2 == 0 && npcGuess) {
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;
        }
        if (userBallsInHand % 2 == 0 && !npcGuess) {
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;
        }
        if (!(userBallsInHand % 2 == 0) && !npcGuess) {
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;
        }
        if (!(userBallsInHand % 2 == 0) && npcGuess) {
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;
        }
    }

    private void UserTurnLogic() {
        if (npcBallsInHand % 2 == 0 && (userGuess.equals("P") || userGuess.equals("p"))) {
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;

        }
        if (npcBallsInHand % 2 == 0 && (userGuess.equals("N") || userGuess.equals("n"))) {
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;
        }
        if (!(npcBallsInHand % 2 == 0) && (userGuess.equals("N") || userGuess.equals("n"))) {
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;
        }
        if (!(npcBallsInHand % 2 == 0) && (userGuess.equals("P") || userGuess.equals("p"))) {
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;

        }
    }

    private void UserCheater() {

        System.out.println("Nie mozesz postawic wiecej kulek niz masz!!!!!");
        System.out.println("Pozostalo Ci " + userBalls + " kulek");
        userBallsInHand = new UserInput().UserBallInHand();


    }

    private void UserMoron() {
        System.out.println("wpisz poprawny znak P- parzysta, N - nieparzysta");
        userGuess = new UserInput().UserGuess();
    }
}

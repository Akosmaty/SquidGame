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
            if(!((userBalls <= 0)|| (userBalls>=20)))

            UserTurn();
            if(!((userBalls <= 0|| userBalls>=20)))
            NpsTurn();
            else{
                System.out.println("Twoja liczba kulek to" + userBalls + "libcza kulek przeciwnika to" + npsBalls);
                break;
            }
        }

    }

    public void UserTurn() {
        npcBallsInHand = new NpcInput().BallsInHand(npsBalls);
        System.out.println("posiadasz: "+userBalls+" kulek, ile chcesz wlozyc do reki?");
        userBallsInHand = new UserInput().UserBallInHand();
        System.out.println("Zgadnij czy Twoj przeciwnik ma parzysta(kliknij P) czy nieparzysta(kliknij N liczbe kulek w rece. ");
        userGuess = new UserInput().UserGuess();
        System.out.println("libcza kulek w ręku przeciwnika: "+ npcBallsInHand);


        if (npcBallsInHand % 2 == 0 && (userGuess.equals("P") || userGuess.equals("p"))) {
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;

        }
        if (npcBallsInHand % 2 == 0 && (userGuess.equals("N") || userGuess.equals("n"))) {
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;
        }
        if (npcBallsInHand % 2 == 1 && (userGuess.equals("N") || userGuess.equals("n"))) {
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;
        }
        if (npcBallsInHand % 2 == 1 && (userGuess.equals("P") || userGuess.equals("p"))) {
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;

        }



    }

    public void NpsTurn() {
        npcBallsInHand = new NpcInput().BallsInHand(npsBalls);
        System.out.println("posiadasz: "+userBalls+"kulek. ile z nich chcesz wlozyc do reki");
        userBallsInHand = new UserInput().UserBallInHand();
        npcGuess = new NpcInput().NpcGuess();
        System.out.println("libcza kulek w ręku przeciwnika: "+ npcBallsInHand);
        System.out.println("Przecwinik powiedział  " + npcGuess + "że masz parzysta liczbe kulek w reku");

        if (userBallsInHand%2==0&& npcGuess){
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;
        }
        if (userBallsInHand%2==0&& !npcGuess){
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;
        }
        if (userBallsInHand%2==1&& !npcGuess){
            userBalls = userBalls - npcBallsInHand;
            npsBalls = npsBalls + npcBallsInHand;
        }
        if (userBallsInHand%2==1&& npcGuess){
            npsBalls = npsBalls - userBallsInHand;
            userBalls = userBalls + userBallsInHand;
        }



    }



}

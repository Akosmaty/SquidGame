package com.company;

import java.util.ArrayList;



import java.util.ArrayList;

public class GameBeatwinBots {
        NpcInput npcInput = new NpcInput();

        private final int maxBallsInStock = 20;
        ArrayList<Integer> list = new ArrayList<>();
        Logic logic = new Logic();
        private int userBalls = maxBallsInStock;
        private int npsBalls = maxBallsInStock;
        private int userBallsInHand;
        private int npcBallsInHand;
        private String userGuess;
        private boolean npcGuess;
        private boolean userGuessInBoolean;
        private UserInput userInput = new UserInput();

        public void startGame() {
            // if Npc guess = true -> paired, if falls -> unpaired
            while(true){
                botUserTurn();
                botNpcTurn();
            }
        }

        public void botUserTurn() {
            {
                npcBallsInHand = npcInput.ballsInHand(npsBalls);

                System.out.println("posiadasz: " + userBalls + " kulek, ile chcesz wlozyc do reki?");

                userBallsInHand = npcInput.ballsInHand(userBalls);



                System.out.println(
                        "Zgadnij czy Twoj przeciwnik ma parzysta(kliknij P) czy nieparzysta(kliknij N liczbe kulek w rece. ");



                list.add(userBallsInHand);
                list.add(npcBallsInHand);
                userGuessInBoolean = npcInput.npcGuess();
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

        public void botNpcTurn() {

            npcBallsInHand = npcInput.ballsInHand(npsBalls);
            System.out.println("posiadasz: " + userBalls + " kulek. ile z nich chcesz wlozyc do reki");
            userBallsInHand = npcInput.ballsInHand(userBalls);



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




        private boolean userGuessTranslator(String userGuess) {
            return userGuess.equalsIgnoreCase("p");
        }
    }


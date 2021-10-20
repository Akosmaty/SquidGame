package com.company;

public class GameMode {
    public void gamemode(){
        UserInput userInput = new UserInput();
        System.out.println("Wcisnij B aby zagrac z komputerem, \n wcisnij dowolny klawisz aby obejrzec rozgrywke miedzy botami");
        String userModeChoice = userInput.userGuess();

        if (!userModeChoice.equalsIgnoreCase("B")){
            GameBeatwinBots gameLogic = new GameBeatwinBots();

            gameLogic.startGame();
        }
        else {
            Game game = new Game();
            game.startGame();
        }


    }
}

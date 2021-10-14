package com.company;

public class RestartGame {
    private final UserInput userInput = new UserInput();
    public void newGame(){
        System.out.println("\n Jesli chcesz kontunowac gre kliknij Y");
        System.out.println("\n Aby wyjsc z gry kliknij dowolny inny klawisz i zatwierdz enterem");
        String userchoos = userInput.userChoose();
        if (userchoos.equalsIgnoreCase("Y")){
            new GameLogic().startGame();

        }
    }
}

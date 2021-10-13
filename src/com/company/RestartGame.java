package com.company;

public class RestartGame {
    public void NewGame(){
        System.out.println("/n jesli chcesz kontunowac gre kliknij Y");
        System.out.println("/n Aby wyjsc z gry kliknij dowolny inny klawisz i zatwierdz enterem");
        String userchoos = new UserInput().UserChoose();
        if (userchoos.equals("Y") || userchoos.equals("y")){
            new GameLogic().StartGame();
            NewGame();
        }
    }
}

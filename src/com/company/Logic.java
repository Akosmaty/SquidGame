package com.company;

import java.util.ArrayList;

public class Logic {
  int activePlayerBallsInHand;
  int passivePlayerBallsInHand;
  boolean activePlayerGuess;
  int activePlayerBallsInStack;
  int passivePlayerBallsInStack;

  public void setParameters(ArrayList<Integer> list, boolean guess) {
    this.activePlayerBallsInHand = list.get(0);
    this.passivePlayerBallsInHand = list.get(1);
    this.activePlayerGuess = guess;
    this.activePlayerBallsInStack = list.get(2);
    this.passivePlayerBallsInStack = list.get(3);
  }

  public void turnLogic() {

    if (passivePlayerBallsInHand % 2 == 0 && activePlayerGuess) {
      activeWin();
    }

    if (passivePlayerBallsInHand % 2 == 0 && !activePlayerGuess) {
    activeLoose();
    }

    if (passivePlayerBallsInHand % 2 == 1 && !activePlayerGuess) {
      activeWin();
    }

    if (passivePlayerBallsInHand % 2 == 1 && activePlayerGuess) {
     activeLoose();
    }
  }
  void activeWin(){
    activePlayerBallsInStack = activePlayerBallsInStack + activePlayerBallsInHand;
    passivePlayerBallsInStack = passivePlayerBallsInStack - activePlayerBallsInHand;

  }
  void activeLoose(){
    activePlayerBallsInStack = activePlayerBallsInStack - activePlayerBallsInHand;
    passivePlayerBallsInStack = passivePlayerBallsInStack + activePlayerBallsInHand;
  }

}

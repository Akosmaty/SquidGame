package com.company;

import java.util.Random;

public class NpcInput {

  Random random = new Random();

  public int ballsInHand(int allBalls) {

    return random.nextInt(allBalls);
  }

  public boolean npcGuess() {

    return random.nextBoolean();
  }
}

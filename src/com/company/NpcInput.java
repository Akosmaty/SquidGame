package com.company;

import java.util.Random;

public class NpcInput {

  Random random = new Random();

  int ballsInHand(int allBalls) {

    return random.nextInt(allBalls);
  }

  boolean npcGuess() {

    return random.nextBoolean();
  }
}

package com.company;

import java.util.Random;

public class NpcInput {


    Random random = new Random();


    public int BallsInHand(int allBalls) {


        return random.nextInt(allBalls);

    }

    public boolean NpcGuess() {


        return random.nextBoolean();
    }


}

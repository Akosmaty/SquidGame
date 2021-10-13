package com.company;

import java.util.Random;

public class NpcInput {

    public String npcGuess;
    public int npcNumberBallsInHand;
    Random random = new Random();


    public int BallsInHand(int allBalls){

        int ballsInHand = random.nextInt(allBalls);
        return ballsInHand;

    }

    public boolean NpcGuess(){

        boolean guess = random.nextBoolean();
        return guess;
    }




}

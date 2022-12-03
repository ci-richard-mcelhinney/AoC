package com.conserveit.aoc.day2;

public enum GameInput
{
    ROCK('A', 'X'),
    PAPER('B', 'Y'),
    SCISSORS('C', 'Z');


    GameInput(int valA, int valB)
    {
        this.valA = valA;
        this.valb = valB;
    }

    public Integer getInputScore()
    {
        Integer score = 0;

        if (this == ROCK)
            score = 1;
        else if (this == PAPER)
            score = 2;
        else if (this == SCISSORS)
            score = 3;

        return score;
    }

    private final int valA;
    private final int valb;
}

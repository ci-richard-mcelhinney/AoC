package com.conserveit.aoc.day2;


public enum Recommendation
{
    LOSE('X'),
    DRAW('Y'),
    WIN('Z'),
    DEFAULT(-1);



    Recommendation(int val)
    {
        this.val = val;
    }

    public GameInput getMyGameInput(GameInput theirs)
    {
        GameInput input = GameInput.DEFAULT;

        if (this == LOSE)
        {
            if      (theirs == GameInput.SCISSORS) input = GameInput.PAPER;
            else if (theirs == GameInput.ROCK)     input = GameInput.SCISSORS;
            else if (theirs == GameInput.PAPER)    input = GameInput.ROCK;
        }
        else if (this == DRAW)
        {
            if      (theirs == GameInput.SCISSORS) input = GameInput.SCISSORS;
            else if (theirs == GameInput.ROCK)     input = GameInput.ROCK;
            else if (theirs == GameInput.PAPER)    input = GameInput.PAPER;
        }
        else if (this == WIN)
        {
            if      (theirs == GameInput.SCISSORS) input = GameInput.ROCK;
            else if (theirs == GameInput.ROCK)     input = GameInput.PAPER;
            else if (theirs == GameInput.PAPER)    input = GameInput.SCISSORS;
        }

        return input;
    }

    private final int val;

}

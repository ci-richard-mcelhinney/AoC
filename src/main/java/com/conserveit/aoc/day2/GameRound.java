package com.conserveit.aoc.day2;

import static com.conserveit.aoc.day2.GameInput.*;

/**
 * Models a round of Rock, Paper, Scissors
 */
public class GameRound
{
    public GameRound(GameInput them, GameInput me)
    {
        this.them = them;
        this.me = me;
    }

    public Integer calcMyScore()
    {
        Integer myScore = 0;
        myScore = me.getInputScore();

        if (me.equals(them))
            myScore = myScore + DRAW;
        else if (me.equals(PAPER) && them.equals(ROCK))
            myScore = myScore + WIN;
        else if (me.equals(PAPER) && them.equals(SCISSORS))
            myScore = myScore + LOSS;
        else if (me.equals(SCISSORS) && them.equals(PAPER))
            myScore = myScore + WIN;
        else if (me.equals(SCISSORS) && them.equals(ROCK))
            myScore = myScore + LOSS;
        else if (me.equals(ROCK) && them.equals(PAPER))
            myScore = myScore + LOSS;
        else if (me.equals(ROCK) && them.equals(SCISSORS))
            myScore = myScore + WIN;

        return myScore;
    }

    private static final Integer LOSS = 0;
    private static final Integer DRAW = 3;
    private static final Integer WIN = 6;

    private final GameInput them;
    private final GameInput me;
}

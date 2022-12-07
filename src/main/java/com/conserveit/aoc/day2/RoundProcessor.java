package com.conserveit.aoc.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static com.conserveit.aoc.day2.GameInput.*;

/**
 * Processes a series of rounds of RSP
 */
public class RoundProcessor
{
    public RoundProcessor(BufferedReader bufferedReader)
    {
        this.bufferedReader = bufferedReader;
        this.myTotalScore = 0;
    }

    public void processPart1() throws IOException
    {
        ArrayList<GameRound> rounds = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            char them = line.charAt(0);
            char me = line.charAt(2);

            GameInput myInput = convert(me);
            GameInput theirInput = convert(them);

            GameRound round = new GameRound(theirInput, myInput);
            rounds.add(round);
        }

        myTotalScore = rounds
                .stream()
                .reduce(0, (part, round) -> part + round.calcMyScore(), Integer::sum);
    }

    public void processPart2() throws IOException
    {
        ArrayList<GameRound> rounds = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            char them = line.charAt(0);
            char me = line.charAt(2);

            GameInput theirInput = convert(them);
            GameInput myInput = translate(me, theirInput);


            GameRound round = new GameRound(theirInput, myInput);
            rounds.add(round);
        }

        myTotalScore = rounds
                .stream()
                .reduce(0, (part, round) -> part + round.calcMyScore(), Integer::sum);
    }

    public GameInput convert(char input)
    {
        if      (input == 'A' || input == 'X') return ROCK;
        else if (input == 'B' || input == 'Y') return PAPER;
        else if (input == 'C' || input == 'Z') return SCISSORS;

        return null;
    }

    public GameInput translate(char input, GameInput theirs)
    {
        Recommendation todo = Recommendation.DEFAULT;
        if      (input == 'X') todo = Recommendation.LOSE;
        else if (input == 'Y') todo = Recommendation.DRAW;
        else if (input == 'Z') todo = Recommendation.WIN;

        return todo.getMyGameInput(theirs);
    }

    public Integer getMyTotalScore()
    {
        return myTotalScore;
    }

    private final BufferedReader bufferedReader;
    private Integer myTotalScore;
}

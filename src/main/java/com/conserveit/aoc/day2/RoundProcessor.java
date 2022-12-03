package com.conserveit.aoc.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

    public void process() throws IOException
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

    public GameInput convert(char input)
    {
        if      (input == 'A' || input == 'X') return ROCK;
        else if (input == 'B' || input == 'Y') return PAPER;
        else if (input == 'C' || input == 'Z') return SCISSORS;

        return null;
    }

    public Integer getMyTotalScore()
    {
        return myTotalScore;
    }

    private final BufferedReader bufferedReader;
    private Integer myTotalScore;
}

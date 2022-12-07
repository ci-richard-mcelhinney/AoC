package com.conserveit.aoc.day2;

import org.testng.annotations.*;
import org.testng.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;

@Test
public class RPSTest
{
    @Test
    public void calcTheoreticalGameScorePart1() throws IOException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day2.txt").getFile());
        String data = new String(Files.readAllBytes(file.toPath()), "UTF-8");

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        RoundProcessor proc = new RoundProcessor(buf);
        proc.processPart1();
        Integer score = proc.getMyTotalScore();

        System.out.println("Part 1");
        System.out.println("------");
        System.out.println("My estimated score is: " + score);
    }

    @Test
    public void calcTheoreticalGameScorePart2() throws IOException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day2.txt").getFile());
        String data = new String(Files.readAllBytes(file.toPath()), "UTF-8");

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        RoundProcessor proc = new RoundProcessor(buf);
        proc.processPart2();
        Integer score = proc.getMyTotalScore();

        System.out.println("Part 2");
        System.out.println("------");
        System.out.println("My estimated score is: " + score);
    }
}

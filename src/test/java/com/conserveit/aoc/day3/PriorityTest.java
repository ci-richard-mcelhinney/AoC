package com.conserveit.aoc.day3;

import org.testng.annotations.*;
import org.testng.*;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;

@Test
public class PriorityTest
{
    @Test
    public void playground()
    {
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('b'));
        System.out.println(Character.getNumericValue('c'));
        System.out.println(Character.getNumericValue('d'));
        System.out.println(Character.getNumericValue('e'));

        System.out.println(Character.getNumericValue('A'));
        System.out.println(Character.getNumericValue('B'));
        System.out.println(Character.getNumericValue('C'));
        System.out.println(Character.getNumericValue('D'));
        System.out.println(Character.getNumericValue('E'));

    }

    @Test
    public void calcPart1SamplePriority() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("day3Part1Sample.txt")).getFile());
        String data = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        ArrayList<Rucksack> listOfSacks = new ArrayList<>();
        buf.lines().forEach(line -> {
            Rucksack rucksack = new Rucksack(line);
            rucksack.init();
            listOfSacks.add(rucksack);
        });

        PriorityAccumulator pa = new PriorityAccumulator(listOfSacks);
        pa.process();
        System.out.println("Day 3 Sample Input");
        System.out.println("------");
        System.out.println("Priority for rearranging rucksacks is: " + pa.getTotalPriority());
    }

    @Test
    public void calcPart2SamplePriority() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("day3Part2Sample.txt")).getFile());
        String data = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        long numLines = buf.lines().count();
        if (numLines % 3 != 0)
        {
            System.out.println("Weird number of elf groups");
            return;
        }

        long numReads = numLines / 3;
        ArrayList<ElfGroup> groups = new ArrayList<>();
        buf = new BufferedReader(new StringReader(data));
        for (int i = 0; i < numReads; i++)
        {
            String l1 = buf.readLine();
            String l2 = buf.readLine();
            String l3 = buf.readLine();
            ElfGroup group = new ElfGroup(
                    new Rucksack(l1),
                    new Rucksack(l2),
                    new Rucksack(l3));

            groups.add(group);
        }

        Integer total = 0;
        for(ElfGroup g : groups)
        {
            total += g.processPriority();
        }

        System.out.println("Sample priority total = " + total);
    }

    @Test
    public void calcPart1Priority() throws IOException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("day3.txt")).getFile());
        String data = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        ArrayList<Rucksack> listOfSacks = new ArrayList<>();
        buf.lines().forEach(line -> {
            Rucksack rucksack = new Rucksack(line);
            rucksack.init();
            listOfSacks.add(rucksack);
        });

        PriorityAccumulator pa = new PriorityAccumulator(listOfSacks);
        pa.process();
        System.out.println("Day 3 Part 1");
        System.out.println("------");
        System.out.println("Priority for rearranging rucksacks is: " + pa.getTotalPriority());
    }

    @Test
    public void calcPart2Priority() throws Exception
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("day3.txt")).getFile());
        String data = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        long numLines = buf.lines().count();
        if (numLines % 3 != 0)
        {
            System.out.println("Weird number of elf groups");
            return;
        }

        long numReads = numLines / 3;
        ArrayList<ElfGroup> groups = new ArrayList<>();
        buf = new BufferedReader(new StringReader(data));
        for (int i = 0; i < numReads; i++)
        {
            String l1 = buf.readLine();
            String l2 = buf.readLine();
            String l3 = buf.readLine();
            ElfGroup group = new ElfGroup(
                    new Rucksack(l1),
                    new Rucksack(l2),
                    new Rucksack(l3));

            groups.add(group);
        }

        Integer total = 0;
        for(ElfGroup g : groups)
        {
            total += g.processPriority();
        }

        System.out.println("Sample priority total = " + total);
    }
}

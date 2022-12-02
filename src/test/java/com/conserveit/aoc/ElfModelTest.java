package com.conserveit.aoc;

import com.conserveit.aoc.day1.ElfFactory;
import org.testng.annotations.*;
import org.testng.*;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

@Test
public class ElfModelTest
{
    @Test
    public void solveDay1Input() throws IOException, URISyntaxException
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("day1.txt").getFile());
        String data = new String(Files.readAllBytes(file.toPath()), "UTF-8");

        StringReader rdr = new StringReader(data);
        BufferedReader buf = new BufferedReader(rdr);

        System.out.println("Day 1");
        System.out.println("------");
        try
        {
            List<ElfModel> elves = ElfFactory.createElves(buf);
            Collections.sort(elves, new ElfSorter());
            Collections.reverse(elves);

            System.out.println(elves.get(0).getName() + " has the most food\n\n");

            elves.forEach(e -> System.out.println(e.toString()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void findElfWithMostFood()
    {
        StringReader rdr = new StringReader(testData.toString());
        BufferedReader buf = new BufferedReader(rdr);

        try
        {
            List<ElfModel> elves = ElfFactory.createElves(buf);
            Collections.sort(elves, new ElfSorter());
            Collections.reverse(elves);

            System.out.println(elves.get(0).getName() + " has the most food\n\n");

            elves.forEach(e -> System.out.println(e.toString()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private StringBuffer testData = new StringBuffer()
    .append(1000).append('\n')
    .append(2000).append('\n')
    .append(3000).append('\n')
    .append('\n')
    .append(4000).append('\n')
    .append('\n')
    .append(5000).append('\n')
    .append(6000).append('\n')
    .append('\n')
    .append(7000).append('\n')
    .append(8000).append('\n')
    .append(9000).append('\n')
    .append('\n')
    .append(10000).append('\n');
}

package com.conserveit.aoc;

import com.conserveit.aoc.day1.ElfFactory;
import org.testng.annotations.*;
import org.testng.*;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

@Test
public class ElfModelTest
{
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

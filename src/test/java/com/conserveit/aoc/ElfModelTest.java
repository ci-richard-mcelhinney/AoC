package com.conserveit.aoc;

import org.testng.annotations.*;
import org.testng.*;

import java.util.*;

@Test
public class ElfModelTest
{
    @Test
    public void findElfWithMostFood()
    {
        List<Integer> elf1Cals = Arrays.asList(1000, 2000, 3000);
        ElfModel elf1 = new ElfModel(elf1Cals, "Elf1", "cal");

        List<Integer> elf2Cals = Arrays.asList(4000);
        ElfModel elf2 = new ElfModel(elf2Cals, "Elf2", "cal");

        List<Integer> elf3Cals = Arrays.asList(5000, 6000);
        ElfModel elf3 = new ElfModel(elf3Cals, "Elf3", "cal");

        List<Integer> elf4Cals = Arrays.asList(7000, 8000, 9000);
        ElfModel elf4 = new ElfModel(elf4Cals, "Elf4", "cal");

        List<Integer> elf5Cals = Arrays.asList(10000);
        ElfModel elf5 = new ElfModel(elf5Cals, "Elf5", "cal");

        ArrayList<ElfModel> elves = new ArrayList<>();
        elves.add(elf1);
        elves.add(elf2);
        elves.add(elf3);
        elves.add(elf4);
        elves.add(elf5);
        Collections.sort(elves, new ElfSorter());
        Collections.reverse(elves);

        System.out.println(elves.get(0).getName() + " has the most food\n\n");

        elves.forEach(e -> System.out.println(e.toString()));
    }
}

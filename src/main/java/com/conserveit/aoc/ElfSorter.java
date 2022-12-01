package com.conserveit.aoc;

import java.util.Comparator;

/**
 * A class to sort Elves
 */
public class ElfSorter implements Comparator<ElfModel>
{
    public int compare(ElfModel a, ElfModel b)
    {
        return a.getTotalEnergy() - b.getTotalEnergy();
    }
}
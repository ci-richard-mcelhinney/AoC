package com.conserveit.aoc.day3;

import java.text.CharacterIterator;

public class ElfGroup
{
    public ElfGroup(Rucksack e1, Rucksack e2, Rucksack e3)
    {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    public Integer processPriority()
    {
        Integer total = 0;
        char cur;

        e1.init();
        e2.init();;
        e3.init();

        while ((cur = e1.getNextChar()) != CharacterIterator.DONE)
        {
            if (e2.contains(cur) && e3.contains(cur))
            {
                if (Character.isUpperCase(cur))
                    total = PriorityAccumulator.uppercase.get(cur);
                else if (Character.isLowerCase(cur))
                    total = PriorityAccumulator.lowercase.get(cur);

                break;
            }
        }

        return total;
    }



    private final Rucksack e1;
    private final Rucksack e2;
    private final Rucksack e3;
}

package com.conserveit.aoc.day3;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rucksack
{
    public Rucksack(String items)
    {
        this.items = items;
    }

    public void init()
    {
        int isEven = items.length() % 2;
        if (isEven != 0)
        {
            System.out.println(items + "contains an odd number of chars " + items.length());
            return;
        }

        it = new StringCharacterIterator(items);
        compartment1 = items.substring(0, items.length()/2);
        compartment2 = items.substring(items.length()/2);
    }

    public List<Character> processCompartments()
    {
        if (compartment1 == null || compartment2 == null) return Collections.emptyList();

        ArrayList<Character> intersect = new ArrayList<>();
        ArrayList<Character> checked = new ArrayList<>();

        CharacterIterator com1It = new StringCharacterIterator(compartment1);
        while (com1It.current() != CharacterIterator.DONE)
        {
            char cur = com1It.current();
            if (checked.contains(cur))
            {
                com1It.next();
                continue;
            }

            if (compartment2.contains(String.valueOf(cur)))
            {
                intersect.add(cur);
            }
            checked.add(cur);
            com1It.next();
        }

        return intersect;
    }

    public String getItems()
    {
        return items;
    }

    public boolean contains(char c)
    {
        return items.contains(String.valueOf(c));
    }

    public char getNextChar()
    {
        char cur = it.current();
        it.next();

        return cur;
    }

    private final String items;
    private CharacterIterator it;
    private String compartment1;
    private String compartment2;
}

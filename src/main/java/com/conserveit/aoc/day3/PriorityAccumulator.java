package com.conserveit.aoc.day3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PriorityAccumulator
{
    public PriorityAccumulator(List<Rucksack> sacks)
    {
        this.sacks = sacks;
    }

    public void process()
    {
        System.out.println("entered process");
        ArrayList<Integer> priorityList = new ArrayList<>();
        sacks.forEach(sack -> {
            List<Character> items = sack.processCompartments();
            items.forEach(i -> {
                char cur = i;
                if (Character.isUpperCase(cur))
                    priorityList.add(uppercase.get(cur));
                else
                    priorityList.add(lowercase.get(cur));
            });
        });
        totalPriority = priorityList.stream().reduce(0, Integer::sum);
    }

    public Integer getTotalPriority()
    {
        return totalPriority;
    }

    private final List<Rucksack> sacks;
    private Integer totalPriority;

    public static final HashMap<Character, Integer> lowercase = new HashMap<Character, Integer>();
    public static final HashMap<Character, Integer> uppercase = new HashMap<Character, Integer>();

    static {
        lowercase.put('a', 1);
        lowercase.put('b', 2);
        lowercase.put('c', 3);
        lowercase.put('d', 4);
        lowercase.put('e', 5);
        lowercase.put('f', 6);
        lowercase.put('g', 7);
        lowercase.put('h', 8);
        lowercase.put('i', 9);
        lowercase.put('j', 10);
        lowercase.put('k', 11);
        lowercase.put('l', 12);
        lowercase.put('m', 13);
        lowercase.put('n', 14);
        lowercase.put('o', 15);
        lowercase.put('p', 16);
        lowercase.put('q', 17);
        lowercase.put('r', 18);
        lowercase.put('s', 19);
        lowercase.put('t', 20);
        lowercase.put('u', 21);
        lowercase.put('v', 22);
        lowercase.put('w', 23);
        lowercase.put('x', 24);
        lowercase.put('y', 25);
        lowercase.put('z', 26);

        uppercase.put('A', 27);
        uppercase.put('B', 28);
        uppercase.put('C', 29);
        uppercase.put('D', 30);
        uppercase.put('E', 31);
        uppercase.put('F', 32);
        uppercase.put('G', 33);
        uppercase.put('H', 34);
        uppercase.put('I', 35);
        uppercase.put('J', 36);
        uppercase.put('K', 37);
        uppercase.put('L', 38);
        uppercase.put('M', 39);
        uppercase.put('N', 40);
        uppercase.put('O', 41);
        uppercase.put('P', 42);
        uppercase.put('Q', 43);
        uppercase.put('R', 44);
        uppercase.put('S', 45);
        uppercase.put('T', 46);
        uppercase.put('U', 47);
        uppercase.put('V', 48);
        uppercase.put('W', 49);
        uppercase.put('X', 50);
        uppercase.put('Y', 51);
        uppercase.put('Z', 52);
    };
}

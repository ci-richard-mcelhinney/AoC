package com.conserveit.aoc.day1;

import com.conserveit.aoc.ElfModel;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A way to create Elves with food
 */
public class ElfFactory
{
    public static List<ElfModel> createElves(BufferedReader buf) throws Exception
    {
        ArrayList<ElfModel> elves = new ArrayList<>();

        if (buf == null)
            return Collections.EMPTY_LIST;

        String line;
        List<FoodItem> foodItems = new ArrayList<>();
        int elfNum = 1;
        while((line = buf.readLine()) != null)
        {
            if (line.length() > 0)
            {
                FoodItem i = new FoodItem("", Integer.parseInt(line), "cal");
                foodItems.add(i);
            }
            else
            {
                ElfModel elf = new ElfModel(foodItems, "Elf"+elfNum, "cal");
                elves.add(elf);
                elfNum++;
                foodItems = new ArrayList<>();
            }
        }

        return elves;
    }
}

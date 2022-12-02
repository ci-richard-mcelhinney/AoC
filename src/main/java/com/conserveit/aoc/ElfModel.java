package com.conserveit.aoc;

import com.conserveit.aoc.day1.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A model for an Elf carrying food
 */
public class ElfModel
{
    /**
     * Constructor to make a model of an Elf
     *
     * @param caloriesCarried
     * @param name
     * @param unit
     */
    public ElfModel(List<FoodItem> foodItems, String name, String unit)
    {
        this.foodItems = foodItems;
        this.name = name;
        this.unit = unit;
    }

    /**
     * Getter
     *
     * @return the list of food with calories
     */
    public List<FoodItem> getCaloriesCarried()
    {
        return foodItems;
    }

    /**
     * Calculate the total calories this Elf is carrying
     * and return the value
     *
     * @return an Integer with the total calories
     */
    public Integer getTotalEnergy()
    {
        Integer sum = foodItems
                .stream()
                .reduce(0, (part, item) -> part + item.getEnergy(), Integer::sum);

        return sum;
    }

    /**
     * Getter for name field
     *
     * @return a String with the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Standard toString implementation
     *
     * @return a String with information on this Elf
     */
    public String toString()
    {
        StringBuffer output = new StringBuffer();

        output.append("Elf ").append(name);
        output.append(" has ").append(getTotalEnergy()).append(" ").append(unit);

        return output.toString();
    }

    private List<FoodItem> foodItems = new ArrayList<>();
    private String unit;
    private String name;
}

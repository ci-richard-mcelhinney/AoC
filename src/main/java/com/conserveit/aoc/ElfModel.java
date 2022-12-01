package com.conserveit.aoc;

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
    public ElfModel(List<Integer>caloriesCarried, String name, String unit)
    {
        this.caloriesCarried = caloriesCarried;
        this.name = name;
        this.unit = unit;
    }

    /**
     * Getter
     *
     * @return the list of food with calories
     */
    public List<Integer> getCaloriesCarried()
    {
        return caloriesCarried;
    }

    /**
     * Calculate the total calories this Elf is carrying
     * and return the value
     *
     * @return an Integer with the total calories
     */
    public Integer getTotalEnergy()
    {
        Integer sum = caloriesCarried.stream().reduce(0, Integer::sum);
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

    private List<Integer> caloriesCarried = new ArrayList<>();
    private String unit;
    private String name;
}

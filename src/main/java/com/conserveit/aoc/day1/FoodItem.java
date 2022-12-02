package com.conserveit.aoc.day1;

/**
 * Declares an item of food plus properties about
 * that food
 */
public class FoodItem
{
    public FoodItem(String name, Integer energy, String unit)
    {
        this.name = name;
        this.energy = energy;
        this.unit = unit;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getEnergy()
    {
        return energy;
    }

    public void setEnergy(Integer energy)
    {
        this.energy = energy;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    private String name;
    private Integer energy;
    private String unit;
}

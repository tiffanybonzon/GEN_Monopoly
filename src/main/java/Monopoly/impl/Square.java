package Monopoly.impl;

public abstract class Square {
    private String name;

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void landedOn(Player player);
}

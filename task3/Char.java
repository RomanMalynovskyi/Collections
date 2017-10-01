package com.gmail.malynovskyiroman.task3;

public class Char  {
    private char symbol;
    private int quantity;

    public Char() {
        super();
    }

    public Char(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || this == null) return false;

        Char aChar = (Char) o;

        return symbol == aChar.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }

    @Override
    public String toString() {
        return "Char{" +
                "symbol=" + symbol +
                ", quantity=" + quantity +
                '}';
    }
}

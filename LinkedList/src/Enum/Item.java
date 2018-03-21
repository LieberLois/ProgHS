package Enum;

public class Item {
    private final String name;
    private final int preis;

    public Item(String name, int preis){
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public int getPreis() {
        return preis;
    }
}


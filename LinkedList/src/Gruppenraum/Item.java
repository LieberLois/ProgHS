package Gruppenraum;

public class Item {
    final int preis;
    final String name;

    Item(String name, int preis){
        this.name = name;
        this.preis = preis;
    }

    public int getPreis(){
        return preis;
    }

    public String getName(){
        return name;
    }


}

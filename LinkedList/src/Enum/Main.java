package Enum;

public class Main {
    public static void main(String[] args) {
        //Item[] bestellung = {new Item("Hamburger", 99), new Item("Cola", 159)};

        Item[] bestellung = new Item[2];
        bestellung[0] = new Item("Hamburger", 99);
        bestellung[1] = new Item("Cola", 159);

        Order order1 = new Order(Order.Location.IN_HOUSE, bestellung);

        System.out.println("Bestellung - Preis: " + order1.calcPrice() + " - STATE: " + order1.state + " - " +
                           "Location: " + order1.loc + " - Rabatt: " + (order1.loc == Order.Location.TAKE_AWAY) + " - Stornierbar: " + (order1.isStornierbar()));

        System.out.println("Bestellung - Preis: " + order1.calcPrice() + " - STATE: " + order1.state + " - " +
                "Location: " + order1.loc + " - Rabatt: " + (order1.loc == Order.Location.TAKE_AWAY) + " - Stornierbar: " + (order1.isStornierbar()));

    }
}

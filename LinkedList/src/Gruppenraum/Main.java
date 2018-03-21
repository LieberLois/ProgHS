package Gruppenraum;

public class Main {


    public static void main(String[] args) {
        Item[] bestellung = {new Item("Hamburger", 99), new Item("Cola", 149)};

        Order order1 = new Order(bestellung, Order.Location.TAKE_AWAY);
        Order order2 = new Order(bestellung, Order.Location.IN_HOUSE);

        System.out.println("Order1 kostet " + order1.calcPrice());
        System.out.println("Order2 kostet " + order2.calcPrice());

    }
}

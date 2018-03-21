package Enum;


public class Order {

    Location loc;
    Item[] items;
    Status state;


    public Order(Location loc, Item[] items){
        this.loc = loc;
        this.items = items;
        state = Status.TAKEN;
    }

    public int calcPrice(){
        int preis = 0;
        double rabatt = 1.0;


        if(loc == Location.TAKE_AWAY){
            rabatt = 0.9;
        }

        for(int i = 0; i < items.length; i++){
            preis += items[i].getPreis() * rabatt;
        }

        return preis;
    }

    public boolean changeToPaid(){
        if(state == Status.TAKEN) {
            state = Status.PAID;
            return true;
        }

        return false;
    }

    public boolean startPreparation(){
        if(state == Status.PAID) {
            state = Status.IN_PREPARATION;
            return true;
        }

        return false;
    }

    public boolean cancel(){
        if(state == Status.TAKEN) {
            state = Status.CANCELLED;
            return true;
        } else if (state == Status.PAID){
            state = Status.CANCELLED;
            System.out.println("Es werden " + calcPrice() + " ct zurück gezahlt.");
            return true;
        } else {
            return false;
        }

    }

    public boolean isStornierbar(){
        if(state == Status.TAKEN || state == Status.PAID){
            return true;
        } else {
            return false;
        }
    }

    public boolean changeToDelivered(){
        if(state == Status.IN_PREPARATION){
            state = Status.DELIVERED;
            return true;
        }
        return false;
    }



    public enum Location{
        TAKE_AWAY, IN_HOUSE;
    }

    public enum Status{
        TAKEN, PAID, IN_PREPARATION, DELIVERED, CANCELLED;
    }
}

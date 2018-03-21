package Gruppenraum;

public class Order {

    Item[] order;
    Location location;
    Status status;

    public Order(Item[] order, Location location){
        this.order = order;
        this.location = location;
        this.status = Status.TAKEN;
    }

    public int calcPrice(){
        int preis = 0;

        for(Item i : order){
            preis += i.getPreis();
        }

        if(location == Location.TAKE_AWAY){
            return (int)(preis*0.9);
        }

        return preis;
    }

    public boolean changeToPaid(){
        if(status == Status.TAKEN) {
            status = Status.PAID;
            return true;
        }
        return false;
    }

    public boolean startPreparation(){
        if(status == Status.PAID){
            status = Status.IN_PREPARATION;
            return true;
        }
        return false;
    }

    public boolean cancel(){
        if(status != Status.DELIVERED && status != Status.IN_PREPARATION){

            if(status != Status.TAKEN){
                System.out.println("Es werden " + calcPrice() + "ct ausgezahlt!");
            }

            status = Status.CANCELLED;



            return true;
        }
        return false;
    }

    public boolean changeToDelivered(){
        if(status == Status.IN_PREPARATION){
            status = Status.DELIVERED;
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

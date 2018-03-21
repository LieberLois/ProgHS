package LinkedList;

public class LinkedList {
    LinkedElement first;
    LinkedElement last;

    public LinkedList(String data){
        first = new LinkedElement(data, null);
        last = first;
    }

    public void add(String data){
        LinkedElement aktuell = first;

        while(aktuell.next != null){
            aktuell = aktuell.next;
        }

        aktuell.next = new LinkedElement(data, null);
    }

    public void addUnten(String data){
        last.next = new LinkedElement(data, null);
        last = last.next;
    }

    public LinkedElement getFirst(){
        LinkedElement oldFirst = first;
        first = first.next;

        return oldFirst;
    }

    public String toString(){
        String s = "";

        LinkedElement aktuell = first;

        while(aktuell.next != null){
            s += aktuell.data + " - ";
            aktuell = aktuell.next;
        }

        s += aktuell.data;



        return s;
    }
}

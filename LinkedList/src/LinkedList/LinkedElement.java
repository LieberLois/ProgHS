package LinkedList;

public class LinkedElement {
    String data;
    LinkedElement next;

    LinkedElement(String data, LinkedElement next) {
        this.data = data;
        this.next = next;
    }

    public void printData(){
        System.out.println(data);
    }

}

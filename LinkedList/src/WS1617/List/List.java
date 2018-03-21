package WS1617.charArray.List;

public class List {
    ListElement first;

    public List(String data){
        first = new ListElement(data, null);
    }

    public void add(String data){
        if (first != null) {
            ListElement aktuell = first;

            while(aktuell.next != null){
                aktuell = aktuell.next;
            }

            aktuell.next = new ListElement(data, null);
        } else {
            first = new ListElement(data, null);
        }
    }

    public String get(){
        ListElement oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    public String toString(){
        String output = "";
        ListElement aktuell = first;

        while(aktuell.next != null){
            output += (aktuell.data + " - ");
            aktuell = aktuell.next;
        }
            output += aktuell.data;


        return output;
    }
}

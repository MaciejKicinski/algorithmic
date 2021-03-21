public class CircularList {
    public Node head = null;

    /**
     * Konstruktor ktory ustawia pierwszy element,
     * i ustawia noda na siebie samego
     */
    public CircularList() {
        head = new Node(0, -1);
        head.setNext(head);
    }

    /**
     * metoda dodajaca nowy element do listy
     *
     * @param value1 - wspolczynnik
     * @param value2 - wykladnik potegi
     */
    public void add(int value1, int value2) {
        Node newNode = new Node(value1, value2);
        if (head == null) {
            head = new Node(0, -1);
            head.setNext(head);
        }
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        head = newNode;
    }

    /**
     * usuwa ostatni element listy
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("lista nieprawidlowo zainicjalizowana");
            return;
        }
        if (head == head.getNext() && head.getValue1() == 0 && head.getValue2() == -1) {
            System.out.println("lista bez wielomianu");
            return;
        }
        Node prev = head.getNext();
        while (prev.getNext() != head) {
            prev = prev.getNext();
        }
        prev.setNext(head.getNext());
        head = prev;
        return;
    }

    /**
     * wyświetla liste elementow (każdy node) znajdujacych sie w liscie
     * wyświetla wartości node oraz wartosci kolejnego noda, na ktorego wskazuje
     */

    public void display() {
        Node current = head;
        System.out.println("Nodes of the CircularList: ");
        do {
            System.out.println(current.getNext().toString());
            current = current.getNext();
        } while (current != head);
    }

    /**
     * wyświetla ciag wielomianu w czytelnym formacie
     */

    public String displayPolynomial() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        current = current.getNext();
        do {
            if (current.getValue1() != 0) {
                result.append(current.generatePolynomial());
            }
            current = current.getNext();
        } while (current != head.getNext());
        return result.toString();
    }

    public int returnNumberOfNodes() {
        int result = 0;
        Node current = head.getNext();
        do {
            result = result + 1;
            current = current.getNext();
        }
        while (current != head);
        return result;
    }
}

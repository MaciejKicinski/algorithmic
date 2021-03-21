public class Node {
    private int value1;
    private int value2;
    private Node next;

    /**
     * Konstruktor przyjmujacy wszystkie argumenty
     *
     * @param value1 wspolczynnik
     * @param value2 wykladnik potegi
     *               next nastepny element w liscie
     */
    public Node(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
        this.next = null;
    }


    /**
     * metoda generuje string reprezentujacego mian-element wielomianu w czytelnym formacie
     *
     * @return string w formacie +value1 X^value2
     */

    public String generatePolynomial() {
        String znak = value2 == 0 ? "" : "x";
        String result = "";

        result = value1 + " ";
        if (!znak.isEmpty() && value1 > 0) {
            result = "+" + value1 + znak + "^" + value2 + " ";
        }
        if (!znak.isEmpty() && value1 < 0) {
            result = value1 + znak + "^" + value2 + " ";
        }

        if (znak.isEmpty() && value1 > 0) {
            result = "+ " + result;
        }

        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ",    Nextvalue1=" + next.getValue1() +
                ",    Nextvalue2=" + next.getValue2() +
                '}';
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }
}

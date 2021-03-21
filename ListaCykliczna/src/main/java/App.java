public class App {
    public static void main(String[] args) {

        CircularList circularList = new CircularList();
        circularList.add(88, 40);
        circularList.add(6, 30);
        circularList.add(-25, 1);
        circularList.display();
        System.out.println("");

        System.out.println(circularList.displayPolynomial());
        circularList.deleteLast();
        System.out.println("wywołanie metody: circularList.deleteLast();");
        System.out.println(circularList.displayPolynomial());

    }
}

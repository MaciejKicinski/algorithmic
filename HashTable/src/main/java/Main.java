public class Main {
    public static void main(String[] args) {
        HashTable<String> hm = new HashTable<>(10);
        hm.put(11, "Maciek11");
        hm.put(21, "Maciek21");
        hm.put(12, "Ewelina12");
        hm.put(13, "Ola");
        hm.put(13, "Ala");
        hm.put(13, "Dominika13");

        System.out.println(hm.get(11));
        System.out.println(hm.get(21));
        System.out.println(hm.get(12));
        System.out.println(hm.get(13));
    }
}

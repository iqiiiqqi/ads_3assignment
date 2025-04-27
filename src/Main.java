import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        table.put(1, "One");
        table.put(2, "Two");
        String value = table.get(1);
        System.out.println(value);

        Random random = new Random();


        MyHashTable<MyTestingClass, String> customTable = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i, "Name" + random.nextInt(10000));
            customTable.put(key, "Value" + i);
        }

        customTable.printBucketSizes();
    }
}

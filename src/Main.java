import java.util.Random;

public class Main {

    private static final Random RNG = new Random(42);
    private static final String[] FIRST = {"Alice","Bob","Charlie","Diana","Eve","Frank","Grace","Hank","Iris","Jack"};
    private static final String[] LAST  = {"Smith","Jones","Lee","Brown","Kim","Patel","Nguyen","Garcia","Wang","Ali"};

    private static String randomName() {
        return FIRST[RNG.nextInt(FIRST.length)] + " " + LAST[RNG.nextInt(LAST.length)];
    }

    // =========================================================== Part 1
    static void testHashTable() {
        System.out.println("========== Part 1 – MyHashTable ==========\n");

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(1000);

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key   = new MyTestingClass(RNG.nextInt(500_000), randomName());
            Student        value = new Student(randomName(), 18 + RNG.nextInt(10), 2.0 + RNG.nextDouble() * 2.0);
            table.put(key, value);
        }

        System.out.println("Total elements: " + table.size());
        System.out.println("\nElements per bucket:");

        // basic functional checks
        MyTestingClass k = new MyTestingClass(1, "Test");
        Student        v = new Student("Test Student", 20, 4.0);
        table.put(k, v);
        System.out.println("\nget      → " + table.get(k));
        System.out.println("contains → " + table.contains(v));
        System.out.println("getKey   → " + table.getKey(v));
        table.remove(k);
        System.out.println("after remove get → " + table.get(k));
    }

    // =========================================================== Part 2
    static void testBST() {
        System.out.println("\n========== Part 2 – MyBST ==========\n");

        MyBST<Integer, String> tree = new MyBST<>();

        int[] keys = {5, 3, 7, 1, 4, 6, 9, 2, 8};
        for (int k : keys) tree.put(k, "value_" + k);

        System.out.println("Size after 9 inserts: " + tree.size());

        // update existing key — size must not change
        tree.put(5, "updated_five");
        System.out.println("Size after update  : " + tree.size() + " (expected 9)");

        System.out.println("\nIn-order traversal (should be sorted):");
        for (var elem : tree) {
            System.out.println("  key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(3);
        System.out.println("\nSize after delete(3): " + tree.size() + " (expected 8)");

        System.out.println("\nIn-order after deletion:");
        for (var elem : tree) {
            System.out.println("  key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        // String keys
        MyBST<String, Integer> words = new MyBST<>();
        for (String w : new String[]{"banana","apple","cherry","apple","date","banana"}) {
            Integer c = words.get(w);
            words.put(w, c == null ? 1 : c + 1);
        }
        System.out.println("\nWord counts (alphabetical):");
        for (var e : words) {
            System.out.println("  \"" + e.getKey() + "\" → " + e.getValue());
        }
    }

    // =========================================================== main
    public static void main(String[] args) {
        testHashTable();
        testBST();
    }
}
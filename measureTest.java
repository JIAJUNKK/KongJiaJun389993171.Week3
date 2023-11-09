import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * The `measureTest` class is used to perform benchmark tests on different collection types,
 * such as ArrayList, LinkedList, and HashMap, based on specified test types.
 */
public class measureTest implements CollectionTest {
    private ArrayList<Person> personArrayList;
    private LinkedList<Person> personLinkedList;
    private HashMap<String, Person> personHashMap;
    private int size;
    private String searchName;

    /**
     * Default constructor for the `measureTest` class.
     */
    public measureTest() {
    }

    /**
     * Sets the size of the collection used in the benchmark tests.
     *
     * @param size The size of the collection.
     */
    @Override
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Runs benchmark tests for a specified collection type, test type, and number of iterations.
     *
     * @param type       The type of collection to be tested (ArrayList, LinkedList, or HashMap).
     * @param test       The type of test to be performed (ADD, INDEX, or SEARCH).
     * @param iterations The number of iterations for the test.
     */
    @Override
    public void runTest(CollectionTest.CollectionType type, CollectionTest.TestType test, int iterations) {
        for (int i = 0; i < iterations; i++) {
            switch (type) {
                case ARRAY_LIST:
                    testArrayList(test);
                    break;
                case LINKED_LIST:
                    testLinkedList(test);
                    break;
                case HASH_MAP:
                    testHashMap(test);
                    break;
            }
        }
    }

    /**
     * Benchmark tests for an ArrayList based on the specified test type.
     *
     * @param test The type of test to be performed (ADD, INDEX, or SEARCH).
     */
    private void testArrayList(CollectionTest.TestType test) {
        switch (test) {
            case ADD:
                personArrayList = new ArrayList<Person>();
                for (int i = 1; i <= size; i++) {
                    Person p = new Person("Person" + i, i);
                    personArrayList.add(p);
                }
                break;

            case INDEX:
                personArrayList.get(size / 2);
                break;

            case SEARCH:
                searchName = "Person" + size / 2;
                for (Person p : personArrayList) {
                    if (p.getName().equals(searchName)) {
                        break;
                    }
                }
                break;
        }
    }

    /**
     * Benchmark tests for a LinkedList based on the specified test type.
     *
     * @param test The type of test to be performed (ADD, INDEX, or SEARCH).
     */
    private void testLinkedList(CollectionTest.TestType test) {
        switch (test) {
            case ADD:
                personLinkedList = new LinkedList<Person>();
                for (int i = 1; i <= size; i++) {
                    Person p = new Person("Person" + i, i);
                    personLinkedList.add(p);
                }
                break;

            case INDEX:
                personLinkedList.get(size / 2);
                break;

            case SEARCH:
                searchName = "Person" + size / 2;
                for (Person p : personLinkedList) {
                    if (p.getName().equals(searchName)) {
                        break;
                    }
                }
                break;
        }
    }

    /**
     * Benchmark tests for a HashMap based on the specified test type.
     *
     * @param test The type of test to be performed (ADD, INDEX, or SEARCH).
     */
    private void testHashMap(CollectionTest.TestType test) {
        switch (test) {
            case ADD:
                personHashMap = new HashMap<String, Person>();
                for (int i = 1; i <= size; i++) {
                    Person p = new Person("Person" + i, i);
                    personHashMap.put(p.getName(), p);
                }
                break;

            case INDEX:
                int currentIndex = 0;
                for (Map.Entry<String, Person> entry : personHashMap.entrySet()) {
                    if (currentIndex == size / 2) {
                        Person personAtIndex = entry.getValue();
                        break;
                    }
                    currentIndex++;
                }
                break;

            case SEARCH:
                searchName = "Person" + size / 2;
                personHashMap.get(searchName);
                break;
        }
    }
}

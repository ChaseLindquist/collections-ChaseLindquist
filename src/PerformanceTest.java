import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTest {


    static Map<String, Map<String, Long>> results = new LinkedHashMap<>();

    private static final int TOP = 60_000;
    public static void main(String[] args) {

        getTestTime();

        List<Integer> list = generateShuffledList();
        List<Integer> im = generateTestList(list);

        // HashSet

        long startTime;
        long endTime;

        testHashSet(list, im);

        removeHashSet(list, im);

        // LinkedListSet

        startTime = System.currentTimeMillis();
      
        

        // TreeSet

        // ArrayList

        // LinkedList

    }

    private static void removeHashSet(List<Integer> list, List<Integer> im) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        Map<String, Long> m1 = new HashMap<>();
        Set<Integer> xx = new HashSet<>(list);
        for (Integer i: im) {
            xx.remove(i);
        }
        endTime = System.currentTimeMillis();

        m1.put("remove", endTime - startTime);
        results.put("HashSet", m1);
        System.out.println("Time: " + (endTime - startTime));
    }

    private static void testHashSet(List<Integer> list, List<Integer> im) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        Set<Integer> x = new HashSet<>(list);
        for (Integer i: im) {
            x.contains(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
    }

    private static List<Integer> generateTestList(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        List<Integer> im = List.of(list.toArray(new Integer[] {}));
        return im;
    }

    private static List<Integer> generateShuffledList() {
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < PerformanceTest.TOP; index++) {

            list.add(index);


        }

        Collections.shuffle(list);
        return list;
    }

    private static void inform(List<Integer> list) {
        list.forEach(e -> System.out.println(e));
    }

    private static void getTestTime() {



        // get time
        long startTime = System.currentTimeMillis();

        int ii = 0;
        for (int index = 0; index < 10_000_000; index++) {
            ii+= index;
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

    }

    


    
    
}

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//        deque.addFirst(4);
//        deque.addLast(5);
//        System.out.println(deque.peek());
//        System.out.println(deque.peekLast());
//        System.out.println(deque.remove());
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeLast());


        // sort map by value and collect to another map
        Map<String, Integer> unsortedMap = Map.of("a", 1, "cd", 3, "b", 2, "e", 5, "d", 4);
        System.out.println(unsortedMap);

//        unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                java.util.LinkedHashMap::new));


        Map<String, Integer> sortedMap1 = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                java.util.LinkedHashMap::new));


        Map<Integer, String> swapped = unsortedMap.entrySet()
                .stream().
                collect(
                        Collectors.toMap(
                                Map.Entry::getValue,
                                Map.Entry::getKey,
                                (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));

        Map<String, Integer> sortedKey = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));

        Map<String, Integer> sortedKeyReverse = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));


//        System.out.println(sortedMap);
//        System.out.println(sortedMap);
//        System.out.println(swapped);
        System.out.println(sortedKey);

        //.collect(
        //        java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));
//        System.out.println(sortedMap);

        // sort map by key and collect to another map
//        Map<String, Integer> sortedKeyMap = unsortedMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));
//        System.out.println(sortedKeyMap);
//
//        // sort map by value in reverse order and collect to another map
//        Map<String, Integer> sortedReverseValueMap = unsortedMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));
//        System.out.println(sortedReverseValueMap);
//
//        // sort map by key in reverse order and collect to another map
//        Map<String, Integer> sortedReverseKeyMap = unsortedMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey().reversed()).collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (oldValue, newValue) -> oldValue, java.util.LinkedHashMap::new));
//        System.out.println(sortedReverseKeyMap);
    }
}
/*
unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        // sort map by key
        unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        // sort map by value in reverse order
        unsortedMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);

        // sort map by key in reverse order
        unsortedMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey().reversed()).forEach(System.out::println);


 */
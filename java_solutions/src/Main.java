import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private void dateFuntions() {
        long currentTimeMillis = Instant.now().toEpochMilli();
        long currentTimemillis = System.currentTimeMillis();

        LocalDate date = LocalDate.parse("2024-02-24");
        System.out.println("Day " + date.getDayOfMonth());
        System.out.println("Month " + date.getMonth());
        System.out.println("Month number " + date.getMonth().getValue());
        System.out.println("Year " + date.getYear());

        LocalDate startDate = LocalDate.parse("2022-04-24");
        LocalDate endDate = LocalDate.parse("2023-03-10");
        Period p = Period.between(startDate, endDate);
        System.out.println("Day diff " + p.getDays());
        System.out.println("Month diff " + p.getMonths());
        System.out.println("Year diff " + p.getYears());

        System.out.println(LocalDate.now());
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
//            String str = String.valueOf(arr);
            //map.put(s, map.getOrDefault(s, new ArrayList<>()).add(s));
            map.computeIfAbsent(String.valueOf(arr), k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<List<String>>();
        for (Map.Entry<String, List<String>> e: map.entrySet()) {

        }
        return null;
    }

    public static int minOperationsToOrganize(int[] items) {
        int operations = 0;
        int n = items.length;

        for (int i = 0; i < n - 1; i++) {
            while (items[i] % 2 == items[i + 1] % 2) {
                if (items[i] > items[i + 1]) {
                    while (items[i] % 2 == items[i + 1] % 2) {
                        items[i] /= 2;
                        operations++;
                    }
                } else {
                    while (items[i] % 2 == items[i + 1] % 2) {
                        items[i + 1] /= 2;
                        operations++;
                    }
                }
            }
        }

        return operations;
    }


    public static void main(String[] args) {
        String s = " test     test1";
        String s1 = "/opt/service/";
        String[] arr= s1.split("/");
        int[] items = {4,4,4,4};
//        List<Integer> l =  Arrays.stream(items).boxed().toList();

    }

    public boolean reorderedPowerOf2(int n) {
        char[] number = sortedDigits(n);
        System.out.println(number);

        for (int i = 0; i < 30; ++i) {
            char[] powerOfTwo = sortedDigits(1 << i);
//            System.out.println(powerOfTwo);
            if (Arrays.equals(number, powerOfTwo))
                return true;
        }
        return false;
    }

    private char[] sortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }
}
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of(
                "CD", 400, "CM", 900,
                "XL", 50, "XC", 100,
                "IV", 4, "IX", 9

        );
        map.put("IV", 4);
        char c = 'c';



        //        int sum = 0;
//        int i = 0;
//        while ( i < s.length()) {
//
//            if ( (i + 1) < s.length() && String.valueOf())
//
//                i++;
//        }
        // for (int i = 0; i<s.length() - 1; i++) {
        //     if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
        //         sum = sum - map.get(s.charAt(i));
        //     } else {
        //         sum = sum + map.get(s.charAt(i));
        //     }
        // }

//        return sum +  map.get(s.charAt(s.length() - 1));
        return 0;
    }
}

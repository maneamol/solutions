import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int val = 0;
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            val = 0;

            while (n > 0) {
                int k = n % 10;
                n = n / 10;
                val = val + (k * k);
                System.out.println(val);
            }
            n = val;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    /* Leetcode solution - start */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappyLeetcode(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /* Leetcode solution - end */

    public static void main(String[] args) {
        IsHappyNumber ob = new IsHappyNumber();
        ob.isHappy(2);
    }
}

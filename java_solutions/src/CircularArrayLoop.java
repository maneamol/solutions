import java.util.Arrays;

public class CircularArrayLoop {

    private boolean isNotCycle(boolean currentDirection, int index, int[] nums) {
        if (currentDirection != (nums[index] > 0)) {
            return true;
        }
        if ((Math.abs(nums[index]) % nums.length) == 0) {
            return true;
        }
        return false;
    }

    private int getNextIndex(int currentIndex, int[] nums) {
        int next = (currentIndex + nums[currentIndex]) % nums.length;
        if (next < 0) {
            next = next + nums.length;
        }
        System.out.println("Next : " + next);
        System.out.println("==============");
        return next;
    }

    private boolean checkIndex(int index, int[] nums) {
        int slow = index;
        int fast = index;
        boolean currentDirection = nums[slow] > 0;

        while (true) {
            slow = getNextIndex(slow, nums);
            if (isNotCycle(currentDirection, slow, nums)) {
                return false;
            }
            fast = getNextIndex(fast, nums);
            if (isNotCycle(currentDirection, fast, nums)) {
                return false;
            }

            fast = getNextIndex(fast, nums);
            if (isNotCycle(currentDirection, fast, nums)) {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
    }

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (checkIndex(i, nums)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CircularArrayLoop cal = new CircularArrayLoop();
        int[][] input = {
                {2,-1,1,2,2}
//                {-2, -3, -9},
//                {-5, -4, -3, -2, -1},
//                {-1, -2, -3, -4, -5},
//                {2, 1, -1, -2},
//                {-1, -2, -3, -4, -5, 6},
//                {1, 2, -3, 3, 4, 7, 1},
//                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = cal.circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

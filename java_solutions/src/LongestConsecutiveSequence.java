import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        UnionFindBySize ds = new UnionFindBySize(nums);

        for (int num : nums) {
            if (ds.parent.containsKey(num + 1)) {
                ds.union(num, num + 1);
            }
        }

        return ds.maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
//        obj.longestConsecutive()
        int[][] inputNums = {
//                {150, 14, 200, 1, 3, 2},
//                {1, 2, 3, 4, 5, 6, 7},
                {1, 3, 5, 7}
//                {7, 6, 5, 4, 3, 2, 1},
//                {7, 6, 5, 1}
        };

        for (int i = 0; i < inputNums.length; i++) {
            System.out.println((i + 1) + ".\tnums = " + Arrays.toString(inputNums[i]));
            System.out.println("\tThe length of the longest consecutive sequence is: " + obj.longestConsecutive(inputNums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

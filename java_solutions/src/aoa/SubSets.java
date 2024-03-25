package aoa;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);
        // generate(0, list, new ArrayList<Integer>(), nums);

        for (int k = 0; k < (nums.length + 1); k++) {
            genrateWithSize(0, list, new ArrayList<>(), nums, k);
        }
        return list;
    }

    private void genrateWithSize(int start, List<List<Integer>> list, List<Integer> tempList, int[] nums, int size) {
        if (tempList.size() == size) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i< nums.length; i++) {
            tempList.add(nums[i]);
            genrateWithSize(i + 1, list, tempList, nums, size);
            tempList.remove(tempList.size() - 1);
        }
    }

    private void generate(int start, List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i<nums.length; i++) {
            tempList.add(nums[i]);
            generate(i + 1, list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        //[1,2,3]
        List<List<Integer>> list = new ArrayList<>();
        SubSets ss =  new SubSets();
        int[] nums = {1, 2, 3};
        ss.generate(0, list, new ArrayList<>(), nums);
        list = new ArrayList<>();
        for (int k = 0; k < nums.length + 1; k++) {
            ss.genrateWithSize(0, list, new ArrayList<>(), nums, k);
        }
    }
}

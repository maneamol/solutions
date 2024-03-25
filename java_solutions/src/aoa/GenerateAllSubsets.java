package aoa;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {
    private void generateWithSize(int[] nums, int start, List<List<Integer>> list, List<Integer> tempList, int size)  {
        if (tempList.size() == size) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i =start; i < nums.length; i++) {
            tempList.add(nums[i]);
            generateWithSize(nums, i + 1, list, tempList, size);
            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args) {
        // [3, 1, 3, 5]
        int[] nums = new int[]{3, 1, 3, 5};
        List<List<Integer>> list = new ArrayList<>();
        GenerateAllSubsets generateAllSubsets = new GenerateAllSubsets();
        for (int k = 1; k< nums.length + 1; k++) {
            generateAllSubsets.generateWithSize(nums, 0, list, new ArrayList<>(), k);
        }
        System.out.println(list.size());
    }
}

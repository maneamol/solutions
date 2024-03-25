import aoa.SubSets;

import java.util.ArrayList;
import java.util.List;

public class SubSetsCopy {

    private void generateSubsetSize(int[] arr, List<List<Integer>> res, List<Integer> currList, int start, int size) {
        if (currList.size() == size) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i<arr.length; i++) {
            currList.add(arr[i]);
            generateSubsetSize(arr, res, currList, i+1, size);
            currList.remove(currList.size() - 1);
        }

    }

    private void generateSubsets(int[] arr, List<List<Integer>> res, List<Integer> currList, int start) {
        res.add(new ArrayList<>(currList));
        for (int i = start; i<arr.length; i++) {
            currList.add(arr[i]);
            generateSubsets(arr, res, currList, i + 1);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSetsCopy subSetsCopy = new SubSetsCopy();
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = {1, 2, 3};
        subSetsCopy.generateSubsets(arr, res, new ArrayList<>(), 0);
        System.out.println(res);

        res = new ArrayList<>();
        for (int k = 0; k < arr.length + 1; k++) {
            subSetsCopy.generateSubsetSize(arr, res, new ArrayList<>(), 0, k);
        }
        System.out.println(res);
    }
}

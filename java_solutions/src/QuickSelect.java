import java.util.Random;

public class QuickSelect {
    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, pIndex, left, right);
        if (pIndex == k) {
            return nums[pIndex];
        }
        if (pIndex < k) {
            return quickSelect(nums, pIndex + 1, right, k);
        }

        return quickSelect(nums, left, pIndex - 1, k);

    }

    private int partition(int[] nums, int pIndex, int left, int right) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);

        pIndex = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        return pIndex - 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}

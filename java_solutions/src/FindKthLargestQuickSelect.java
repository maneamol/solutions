public class FindKthLargestQuickSelect {
    /*
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, (nums.length -1), (nums.length - k));
    }
     */
    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(quickSelect.quickSelect(nums, 0, (nums.length -1), (nums.length - k)));
        // ---
        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println(quickSelect.quickSelect(nums, 0, (nums.length -1), (nums.length - k)));

    }
}

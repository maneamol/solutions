//https://leetcode.com/problems/sliding-window-maximum/solutions/65884/java-o-n-solution-using-deque-with-explanation/
/**
 At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means
 If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array
 Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.
 As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
 */
import java.util.ArrayDeque;
import java.util.Deque;


public class SlidingWindowMaximum {

    private void updateCurrentWindow(Deque<Integer> deque, int index, int[] nums) {
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[index]) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (nums.length < k) {
            k = nums.length;
        }
        int[] result = new int[(nums.length - k) + 1 ];
        Deque<Integer> deque = new ArrayDeque<>();
        int resultIndex = 0;
        for (int i = 0; i <= k - 1; i++) {
            updateCurrentWindow(deque, i, nums);
            deque.addLast(i);
        }
        result[resultIndex++] = nums[deque.peek()];

        for (int i = k; i < nums.length; i++) {
            // update current window
            updateCurrentWindow(deque, i, nums);
            deque.addLast(i);

            //remove i smaller than window
            while (!deque.isEmpty() && deque.peek() <= (i - k)) {
                deque.poll();
            }
            result[resultIndex++] = nums[deque.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        obj.maxSlidingWindow(nums, 3);
    }

}

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
class MedianOfStream {
    private double median = 0.0;
    private PriorityQueue<Integer> smallItemsMaxHeap;
    private PriorityQueue<Integer> largeItemsMinHeap;
    public MedianOfStream() {
        // Write your code here
        smallItemsMaxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        largeItemsMinHeap = new PriorityQueue<Integer>();
    }

    public void insertNum(int num) {
        // Write your code here
        if (smallItemsMaxHeap.isEmpty() && largeItemsMinHeap.isEmpty()) {
            smallItemsMaxHeap.offer(num);
            median = num;
            return;
        }

        if ( (smallItemsMaxHeap.isEmpty() && largeItemsMinHeap.peek() >= num) ||
                (!smallItemsMaxHeap.isEmpty()  && smallItemsMaxHeap.peek() >= num) ) {
            smallItemsMaxHeap.offer(num);
        } else {
            largeItemsMinHeap.offer(num);
        }

        //re balance
        if (Math.abs( smallItemsMaxHeap.size() - largeItemsMinHeap.size() ) > 1) {
            if (smallItemsMaxHeap.size() > largeItemsMinHeap.size()) {
                largeItemsMinHeap.offer(smallItemsMaxHeap.poll());
            } else {
                smallItemsMaxHeap.offer(largeItemsMinHeap.poll());
            }
        }

        if ( !smallItemsMaxHeap.isEmpty() && !largeItemsMinHeap.isEmpty() && smallItemsMaxHeap.size() == largeItemsMinHeap.size()) {
            median = (double) (smallItemsMaxHeap.peek() + largeItemsMinHeap.peek()) / 2.0;
        } else if (!smallItemsMaxHeap.isEmpty() && !largeItemsMinHeap.isEmpty() && smallItemsMaxHeap.size() > largeItemsMinHeap.size()) {
            median = smallItemsMaxHeap.peek();
        } else if (!smallItemsMaxHeap.isEmpty() && !largeItemsMinHeap.isEmpty() && smallItemsMaxHeap.size() < largeItemsMinHeap.size()) {
            median = largeItemsMinHeap.peek();
        } else if (smallItemsMaxHeap.isEmpty() && !largeItemsMinHeap.isEmpty()) {
            median = largeItemsMinHeap.peek();
        } else if (!smallItemsMaxHeap.isEmpty()){
            median = smallItemsMaxHeap.peek();
        }

    }

    public double findMedian() {
        // Replace this placeholder return statement with your code
        return median;
    }
    public static void main(String[] args) {
        int[] nums = {35, 22, 30, 25, 1};
        MedianOfStream medianOfAges = null;
        for(int i=0; i< nums.length; i++){
            System.out.print(i+1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianOfStream();
            for(int j=0; j<=i; j++){
                System.out.print(nums[j]);
                if(j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
            //System.out.println(PrintHyphens.repeat("-", 100));
            System.out.println("-".repeat(100));
        }
    }
}
class RunningSum {
    fun runningSum(nums: IntArray):IntArray {
//        if(nums.isNotEmpty() && nums.size > 1)
//            for (index in 1 until nums.size) {
//                nums[index] = nums[index] + nums[index - 1]
//            }
//        return nums
//        return nums.also { (1..nums.lastIndex).forEach { nums[it] += nums[it-1] } }
        return nums.also { (1..nums.lastIndex).forEach { nums[it] += nums[it-1] } }

    }
}
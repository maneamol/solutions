class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, v ->
//        for ((i,v) in nums.withIndex()) {
            map[target-v]?.let { return intArrayOf(it, i) }
            map[target - v] = i
        }
        throw IllegalStateException("No Solution")
    }
}
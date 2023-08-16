class ShuffleArrays {
    fun shuffleArray(nums: IntArray, n: Int): IntArray {
//        val res = IntArray(2 * n)
//        var index = 0
//        for (i in 0 until  n) {
//            res[index++] = nums[i]
//            res[index++] = nums[i+n]
//        }
//        return res;


//        return IntArray(2*n) {i -> if (i % 2 == 0) nums[i/2] else nums[i/2 + n]}
        return IntArray(2*n) {i -> i}
    }
}
class ConcatArrays {
    fun getConcatenation(nums: IntArray): IntArray {
        return nums + nums;
    }

    fun main(args: Array<String>) {
        val x = intArrayOf(1,2,3)
        getConcatenation(x)
    }
}
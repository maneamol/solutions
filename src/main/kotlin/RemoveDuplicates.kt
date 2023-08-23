class RemoveDuplicates {
    fun removeDuplicatesRec(nums: IntArray): Int {
        when {
            nums.size <= 1 -> return nums.size
            nums.size == 2 -> {
                if (nums[0] == nums[1]) {
                    return 1
                } else {
                    return 2
                }
            }

            else -> return (removeD(nums, 0, 1) + 1)
        }
    }

    fun removeD(nums: IntArray, i: Int, j: Int): Int {
        if (j == nums.size) return i
        if (nums[i] != nums[j]) {
            nums[i + 1] = nums[j]
            return removeD(nums, i + 1, j + 1)
        } else {
            return removeD(nums, i, j + 1)
        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        nums.distinct().let {
            it.forEachIndexed { index, value ->
                nums[index] = value
            }
            return it.size
        }
    }

}

fun main() {
    val x = intArrayOf(1,1,3,3,5,6)
    println( RemoveDuplicates().removeDuplicates(x))

}
class RemoveElement {
    fun removeElement(nums: IntArray, num: Int): Int {
        var counter = 0
        nums.forEach { if (it != num) nums[counter++] = it }

        return counter
    }
}


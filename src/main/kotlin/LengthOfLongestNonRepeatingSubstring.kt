class LengthOfLongestNonRepeatingSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = HashSet<Char>()
        var longest = 0
        var left = 0
        for (right in s.indices) {
            while (!set.add(s[right])) {
                set.remove(s[left++])
            }
//            longest = Math.max(set.size, longest)
            longest = set.size.coerceAtLeast(longest)
        }
        return longest
    }
}
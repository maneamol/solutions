class FindNeedle {
    fun strStr(haystack: String, needle: String): Int {

        if (needle.isEmpty()) return -1
        for(i in 0..haystack.length - needle.length) {
            if (needle == haystack.substring(i, i + needle.length)) {
                return i
            }
        }
        return -1
    }
}

fun main() {
    println(FindNeedle().strStr("butsad", "sad"))

    println("sadbutsad".indexOf("but"))
}

class CheckValidParenthesis {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        return checkValid(s, 0, stack) && stack.isEmpty()
//        return stack.isEmpty()
    }

    private fun checkValid(s: String, pos: Int, stack: ArrayDeque<Char>): Boolean {
        if (pos == s.length) return true
        when {
            s[pos] == '(' -> stack.addFirst(s[pos])
            s[pos] == '{' -> stack.addFirst(s[pos])
            s[pos] == '[' -> stack.addFirst(s[pos])
            s[pos] == ')' -> {
                if (stack.isEmpty() || '(' != stack.removeFirst()) {
                    return false
                }
            }
            s[pos] == ']' -> {
                if (stack.isEmpty() || '[' != stack.removeFirst()) {
                    return false
                }
            }
            s[pos] == '}' -> {
                if (stack.isEmpty() || '{' != stack.removeFirst()) {
                    return false
                }
            }
        }
        return checkValid(s, pos + 1, stack)
    }
}

fun main() {
    val cv = CheckValidParenthesis()
    val isValid = cv.isValid("(((")
    println(isValid)
}

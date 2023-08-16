class ZigZagPrint {
    fun zigZagPrint(s: String, n: Int) {
        val step = n + (n - 2)
        var first = true
        var iteration  = 0

        for (i in 0 until n) {
            var currentIndex = i
            while(currentIndex < s.length) {
                    if (currentIndex < s.length) {
                        print(s[currentIndex])
                        currentIndex += step
                    }
                    if (!first && i != (n -1))  {
                        if (currentIndex - (iteration * 2) < s.length) {
                            print(s[currentIndex - (iteration * 2)])
                        }
                    }
                    first = false
            }
            iteration++
            println()
        }
    }

    fun convertToZigZag(text: String, numRows: Int): String {
        if (numRows == 1 || text.length <= numRows) return text

        val rows = Array(numRows) { StringBuilder() }
        var currentRow = 0
        var goingDown = false

        for (c in text) {
            rows[currentRow].append(c)
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown
            currentRow += if (goingDown) 1 else -1
        }

        return rows.joinToString("") { it.toString() }
    }

}

fun main() {
    val s = "atlassianisawesome"
    /**
    atlassianisawesome
    a           i           w
    o           6           12

    t       s   a       a   e       e
    1       5   7       11  13      17

    l   s       n   s       s   m
    2   4       8   10      14  16

    a           i           o
    3           9           15

     * **/
//    ZigZagPrint().zigZagPrint(s, 4)
    ZigZagPrint().zigZagPrint(s, 4)
}
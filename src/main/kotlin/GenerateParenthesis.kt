import java.lang.StringBuilder

//import kotlin.text.StringBuilder

class GenerateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        generatep(n, n, "")
//        return solve(n ,n, "", listOf())
        return listOf()
    }

    private fun generatep(open: Int, close: Int, cur: String): Unit {
        when {
            open == 0 && close == 0 -> println(cur.toString())
            open == close -> generatep(open - 1, close, "$cur(")
            open == 0 -> generatep(open, close - 1, "$cur)")
            else -> {
                generatep(open - 1, close, "$cur(")
                generatep(open, close - 1, "$cur)")
            }
        }
    }

    fun generate(open: Int, close: Int, cur: String = "", result: List<String> = listOf()): List<String> =
        when {
            open == 0 && close == 0 -> result.plus(cur)
            open == close -> generate(open - 1, close, cur + "(", result)
            open == 0 -> generate(open, close - 1, cur + ")", result)
            else -> generate(open - 1, close, cur + "(", result).plus(generate(open, close - 1, cur + ")", result))
        }
}

fun main() {
    GenerateParenthesis().generateParenthesis(3)
}
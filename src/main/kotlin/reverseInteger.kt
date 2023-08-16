import kotlin.math.abs
import kotlin.math.sign

fun rev(x: Int): Int {
//    val sign = x.sign
//    println(sign)
    return try {
        abs(x).toString().reversed().toInt() * x.sign
    } catch (e: Exception) {
        0
    }
}

fun main() {
//    rev(-123)
//    println(21474836 * 10 > Int.MAX_VALUE / 10)
    println("Integer Max Value: ${Int.MAX_VALUE}")
    println("Integer Min Value: ${Int.MIN_VALUE}")
//    println(214748364 + 1)

//    println(Int.MIN_VALUE )
}
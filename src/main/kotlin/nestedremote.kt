//interface Remote {
//    fun up()
//    fun down()
//}
//
//class TV {
//    private var volume = 0
//    val remote: Remote
//        get() = TVRemote()
//
//    override fun toString(): String = "Volume: ${volume}"
//
//    inner class TVRemote : Remote {
//        override fun up() { volume++ }
//        override fun down() { volume-- }
//        override fun toString() = "Remote: ${this@TV.toString()}"
//    }
//}
//
fun main() {
//    val tv = TV()
//    println(tv.remote.toString())
//    val ace = Ace("Spade")
//    println(ace.toString())
//    println(Suit.valueOf("DIAMONDS"))

    val firstPair = PairEnum.FIRST.pair
    println(firstPair) // prints (1, one)

    for (s in Suit.values()) {
        println(s.display())
    }

}


enum class Suit (val symbol: Char) {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665') {
        override fun display() = "${super.display()} $symbol"
    },
    SPADES('\u2660');

    open fun display() = "$symbol $name"
}

sealed class Card(val suit: String)

class Ace(suit: String) : Card(suit)

class King(suit: String) : Card(suit) {
    override fun toString() = "King of $suit"
}

class Queen(suit: String) : Card(suit) {
    override fun toString() = "Queen of $suit"
}

class Jack(suit: String) : Card(suit) {
    override fun toString() = "Jack of $suit"
}

class Pip(suit: String, val number: Int) : Card(suit) {
    init {
        if (number < 2 || number > 10) {
            throw RuntimeException("Pip has to be between 2 and 10")
        }
    }
}

enum class PairEnum(val pair: Pair<Int, String>) {
    FIRST(1 to "one"),
    SECOND(2 to "two"),
    THIRD(3 to "three")
}

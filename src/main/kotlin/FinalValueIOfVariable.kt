class FinalValueIOfVariable {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0;
        operations.forEach {
            op ->
            when(op) {
                "X++","++X" -> x++
                "X--","--X" -> x--
            }
//            op -> if (op.contains("++")) {
//                x++
//            } else {
//                x--
//            }
//            op -> {
//                if (op.contains("++")) {
//                    x++
//                    println(x)
//                } else {
//                    x--
//                    println(x)
//                }
//        }
        }
        return x;
    }
}
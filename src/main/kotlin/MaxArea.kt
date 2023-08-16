class MaxArea {
    fun maxArea(height: IntArray): Int {
//        println(null)
        return if (height.size > 1) { findMaxArea(height, 0, height. size - 1, 0) } else { 0 }
    }

    fun findMaxArea(height: IntArray, l: Int, r: Int, area: Int): Int {
        if (l >= r) return area

        val currentArea =  minOf(height[l] , height[r]) * (r - l)
        val area1 = if (height[l] < height[r] ) {
            findMaxArea(height, l + 1, r, currentArea)
        } else {
            findMaxArea(height, l, r - 1, currentArea)
        }
        //val currentMaxArea = maxOf(area, minOf(l, r) * (r - l))
        println("$currentArea $area1 $l $r $area")
        return maxOf(currentArea, area1)
    }


}
fun main() {
    val m = MaxArea()
    println(m.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}
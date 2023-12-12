import kotlin.math.min
import kotlin.math.pow
fun main() {
    fun getNumOfWinning(line: String) : Int {
        val game = line.substringAfter(':').trim()
        val winning = game.substringBefore('|').trim().split(' ').filter { it.isNotEmpty() }.toSet()
        val elf = game.substringAfter('|').trim().split(' ').filter { it.isNotEmpty() }.toSet()
        return winning.intersect(elf).size
    }
    fun part1(input: List<String>): Int {
       var sum = 0
        for (line in input) {

            sum += 2.0.pow(((getNumOfWinning(line) - 1).toDouble())).toInt()

        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val arr = IntArray(input.size) { _ -> 1 }
        for (i in input.indices) {
            val wins = getNumOfWinning(input[i])
            for (j in i+1 until i +wins + 1) {
                arr[j] += arr[i]
            }
        }
        return arr.sum()
    }





    val input = readInput("Day04")

    part1(input).println()
    part2(input).println()
}

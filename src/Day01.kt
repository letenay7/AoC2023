fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            val digits = line.filter { it.isDigit() }
            val calibration =  "" + digits.first() + digits.last()
            sum += calibration.toInt()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        val digits = setOf(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        for (line in input) {
            val numbers = mutableListOf<String>()
            for(( i, ch )in line.withIndex()) {
                if (ch.isDigit()) {
                    numbers.add(ch.toString())
                }
                for( (index, value) in digits.withIndex() ) {
                    val sub = line.substring(i)
                    if (sub.startsWith(value)) {
                        numbers.add((index + 1).toString())
                    }
                }
            }
            val num = "" + numbers.first() + numbers.last()
            sum += num.toInt()


        }
        return sum
    }





    val input = readInput("Day01")

    part1(input).println()
    part2(input).println()
}

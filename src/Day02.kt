fun main() {
    fun extractNum(cube : String) : Int {
        return  cube.trim().substringBefore(' ').toInt()
    }
     fun evaluateSet (set : List<String>) : Boolean {
         var red = 0
         var green = 0
         var blue = 0
         val r = 12
         val g = 13
         val b = 14
         for (elem in set) {
             val cubes = elem.split(',')
             for (cube in cubes) {
                 if (cube.contains("red")) {
                     val num = extractNum(cube)
                     if (num > r) {
                         return false
                     }
                 }
                 else if (cube.contains("green")) {
                     val num = extractNum(cube)
                     if (num > g) {
                         return false
                     }
                 }
                 else if (cube.contains("blue")) {
                     val num = extractNum(cube)
                     if (num > b) {
                         return false
                     }
                 }
             }

         }
         return true
     }
    fun eval2 (set : List<String>) :  Int {
        var red = 0
        var green = 0
        var blue = 0
        for (elem in set) {
            val cubes = elem.split(',')
            for (cube in cubes) {
                if (cube.contains("red")) {
                    val num = extractNum(cube)
                    if (num > red) red = num

                }
                else if (cube.contains("green")) {
                    val num = extractNum(cube)
                    if ( num > green) green = num

                }
                else if (cube.contains("blue")) {
                    val num = extractNum(cube)
                    if (num > blue) blue = num

                 }
            }

        }
        return red * green * blue
    }



    fun part1(input: List<String>): Int {
        var sum = 0

        for (line in input) {
            val game = line.split(':')
            val start = game[0]
            val gameNum =  start.substring(start.indexOf(' ') + 1).toInt()
            val set = game[1].split(';')

            if (evaluateSet(set)) {
                sum += gameNum
            }
        }

        return sum
    }


    fun part2(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            val game = line.substringAfter(':').trim()
            val sets = game.split(';')
            sum += eval2(sets)

        }

        return sum
    }





    val input = readInput("Day02")

    part1(input).println()
    part2(input).println()
}

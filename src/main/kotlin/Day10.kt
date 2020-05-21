import org.clechasseur.adventofcode2017.KnotHash

object Day10 {
    private const val input = "165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153"

    fun part1(): Int {
        val lengths = input.split(',').map { it.toInt() }
        val hash = KnotHash(lengths, 1).sparseHash
        return hash[0] * hash[1]
    }

    fun part2(): String = KnotHash(input).toString()
}

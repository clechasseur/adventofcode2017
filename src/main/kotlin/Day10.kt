import kotlin.math.ceil

object Day10 {
    private const val input = "165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153"

    fun part1(): Int {
        val lengths = input.split(',').map { it.toInt() }
        val hash = computeSparseHash(lengths, 1)
        return hash[0] * hash[1]
    }

    fun part2(): String {
        val lengths = input.map { it.toInt() } + listOf(17, 31, 73, 47, 23)
        val sparseHash = computeSparseHash(lengths, 64)
        val denseHash = computeDenseHash(sparseHash)
        return denseHash.joinToString("") { it.toString(16).padStart(2, '0') }
    }

    private fun computeSparseHash(lengths: List<Int>, rounds: Int): List<Int> {
        val list = (0..255).toMutableList()
        var pos = 0
        var skip = 0
        (0 until rounds).forEach { _ ->
            lengths.forEach { length ->
                (pos until (pos + ceil(length.toDouble() / 2.0).toInt())).forEach { a ->
                    val b = pos + (length - (a - pos)) - 1
                    list.swapIndexes(a % list.size, b % list.size)
                }
                pos += length + skip++
            }
        }
        return list
    }

    private fun computeDenseHash(sparseHash: List<Int>): List<Int>
            = sparseHash.chunked(16).map { elements -> elements.reduce { acc, i -> acc xor i } }

    private fun MutableList<Int>.swapIndexes(a: Int, b: Int) {
        val tmp = this[a]
        this[a] = this[b]
        this[b] = tmp
    }
}

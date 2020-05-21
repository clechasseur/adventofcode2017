object Day15 {
    private const val startingPointA = 703L
    private const val startingPointB = 516L

    private const val factorA = 16807L
    private const val factorB = 48271L

    private const val ceiling = 2147483647L

    private const val multipleOfA = 4L
    private const val multipleOfB = 8L

    fun part1() = generator(startingPointA, factorA)
            .zip(generator(startingPointB, factorB))
            .take(40_000_000)
            .filter { it.first % 0x1_0000L == it.second % 0x1_0000L }
            .count()

    fun part2() = generator(startingPointA, factorA, multipleOfA)
            .zip(generator(startingPointB, factorB, multipleOfB))
            .take(5_000_000)
            .filter { it.first % 0x1_0000L == it.second % 0x1_0000L }
            .count()

    private fun generator(startingPoint: Long, factor: Long, multipleOf: Long = 1L): Sequence<Long>
            = generateSequence(startingPoint) { it * factor % ceiling }.drop(1).filter { it % multipleOf == 0L }
}

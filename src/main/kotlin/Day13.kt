import com.sun.org.apache.xpath.internal.operations.Bool

object Day13 {
    private val input = """
        0: 3
        1: 2
        2: 4
        4: 4
        6: 5
        8: 6
        10: 6
        12: 6
        14: 6
        16: 8
        18: 8
        20: 8
        22: 8
        24: 10
        26: 8
        28: 8
        30: 12
        32: 14
        34: 12
        36: 10
        38: 12
        40: 12
        42: 9
        44: 12
        46: 12
        48: 12
        50: 12
        52: 14
        54: 14
        56: 14
        58: 12
        60: 14
        62: 14
        64: 12
        66: 14
        70: 14
        72: 14
        74: 14
        76: 14
        80: 18
        88: 20
        90: 14
        98: 17
    """.trimIndent()

    private val inputRegex = Regex("""^(\d+): (\d+)$""")

    fun part1() = tripSeverity(0).first

    fun part2() = generateSequence(0) { it + 1 }.map { tripSeverity(it) }.takeWhile { it.second }.count()

    private fun tripSeverity(delay: Int): Pair<Int, Boolean> {
        val layers = input.lineSequence().map { it.toLayer() }.map { it.depth to it }.toMap()
        val lastLayer = layers.keys.max()!!
        layers.values.forEach { it.picomove(delay) }
        var packet = 0
        var severity = 0
        var caught = false
        while (packet <= lastLayer) {
            val layer = layers[packet]
            if (layer != null && layer.position == 0) {
                severity += layer.severity
                caught = true
            }
            layers.forEach { (_, l) -> l.picomove(1) }
            packet++
        }
        return severity to caught
    }

    private class Layer(val depth: Int, val range: Int) {
        private var offset = 1

        var position = 0
            private set

        val severity: Int
            get() = depth * range

        fun picomove(by: Int) {
            (0 until (by % (range * 2 - 2))).forEach { _ ->
                position += offset
                if (position == 0 || position == (range - 1)) {
                    offset = -offset
                }
            }
        }

        override fun toString() = "{$depth} [$range] -> $position"
    }

    private fun String.toLayer(): Layer {
        val match = inputRegex.matchEntire(this) ?: error("Wrong layer format: $this")
        return Layer(match.groupValues[1].toInt(), match.groupValues[2].toInt())
    }
}

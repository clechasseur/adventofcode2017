object Day24 {
    private val input = """
        31/13
        34/4
        49/49
        23/37
        47/45
        32/4
        12/35
        37/30
        41/48
        0/47
        32/30
        12/5
        37/31
        7/41
        10/28
        35/4
        28/35
        20/29
        32/20
        31/43
        48/14
        10/11
        27/6
        9/24
        8/28
        45/48
        8/1
        16/19
        45/45
        0/4
        29/33
        2/5
        33/9
        11/7
        32/10
        44/1
        40/32
        2/45
        16/16
        1/18
        38/36
        34/24
        39/44
        32/37
        26/46
        25/33
        9/10
        0/29
        38/8
        33/33
        49/19
        18/20
        49/39
        18/39
        26/13
        19/32
    """.trimIndent()

    private val parts = input.lineSequence().map { it.toPart() }.toList()

    fun part1() = buildBridges(parts, listOf(Part(0, 0))).map { it.strength() }.max()!!

    fun part2(): Int {
        val bridges = buildBridges(parts, listOf(Part(0, 0))).sortedByDescending { it.size }
        val longestBridges = bridges.filter { it.size == bridges.first().size }
        return longestBridges.map { it.strength() }.max()!!
    }

    private fun buildBridges(partsLeft: List<Part>, soFar: List<Part>): List<List<Part>> {
        val matchingParts = partsLeft.filter { part ->
            part.leftPort == soFar.last().rightPort || part.rightPort == soFar.last().rightPort
        }
        if (matchingParts.isEmpty()) {
            return listOf(soFar)
        }
        return matchingParts.flatMap { nextPart ->
            val newPartsLeft = partsLeft - nextPart
            val newSoFar = soFar + if (nextPart.leftPort == soFar.last().rightPort) {
                nextPart
            } else {
                nextPart.reverse
            }
            buildBridges(newPartsLeft, newSoFar)
        }
    }

    private data class Part(val leftPort: Int, val rightPort: Int) {
        val strength: Int
            get() = leftPort + rightPort

        val reverse: Part
            get() = Part(rightPort, leftPort)

        override fun toString(): String = "$leftPort/$rightPort"
    }

    private fun String.toPart(): Part {
        val (leftPort, rightPort) = split('/')
        return Part(leftPort.toInt(), rightPort.toInt())
    }

    private fun List<Part>.strength() = sumBy { it.strength }
}

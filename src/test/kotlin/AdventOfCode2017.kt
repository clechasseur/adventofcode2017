import kotlin.test.Test
import kotlin.test.assertEquals

class AdventOfCode2017 {
    class Day1Puzzles {
        @Test
        fun `day 1, part 1`() {
            assertEquals(1141, Day1.part1())
        }

        @Test
        fun `day 1, part 2`() {
            assertEquals(950, Day1.part2())
        }
    }

    class Day2Puzzles {
        @Test
        fun `day 2, part 1`() {
            assertEquals(53978, Day2.part1())
        }

        @Test
        fun `day 2, part 2`() {
            assertEquals(314, Day2.part2())
        }
    }

    class Day3Puzzles {
        @Test
        fun `day 3, part 1`() {
            assertEquals(371, Day3.part1())
        }

        @Test
        fun `day 3, part 2`() {
            assertEquals(369601, Day3.part2())
        }
    }

    class Day4Puzzles {
        @Test
        fun `day 4, part 1`() {
            assertEquals(337, Day4.part1())
        }

        @Test
        fun `day 4, part 2`() {
            assertEquals(231, Day4.part2())
        }
    }

    class Day5Puzzles {
        @Test
        fun `day 5, part 1`() {
            assertEquals(342669, Day5.part1())
        }

        @Test
        fun `day 5, part 2`() {
            assertEquals(25136209, Day5.part2())
        }
    }

    class Day6Puzzles {
        @Test
        fun `day 6, part 1`() {
            assertEquals(3156, Day6.part1())
        }

        @Test
        fun `day 6, part 2`() {
            assertEquals(1610, Day6.part2())
        }
    }
}

import org.clechasseur.adventofcode2017.DuetInterpreter

object Day23 {
    private val input = """
        set b 65
        set c b
        jnz a 2
        jnz 1 5
        mul b 100
        sub b -100000
        set c b
        sub c -17000
        set f 1
        set d 2
        set e 2
        set g d
        mul g e
        sub g b
        jnz g 2
        set f 0
        sub e -1
        set g e
        sub g b
        jnz g -8
        sub d -1
        set g d
        sub g b
        jnz g -13
        jnz f 2
        sub h -1
        set g b
        sub g c
        jnz g 2
        jnz 1 3
        sub b -17
        jnz 1 -23
    """.trimIndent()

    fun part1() = DuetInterpreter(input, false).getMulCount(0)

    fun part2() = kotlinVersion()

    private fun kotlinVersion(): Long {
        var a = 1L
        var h = 0L
        var b = 65L
        var c = b
        var f = 0L
        var d = 0L
        var e = 0L
        var g = 0L
        b *= 100L
        b += 100000L
        c = b
        c += 17000L
        do {
            f = 1L
            d = 2L
            e = 0L
            g = 0L
            do {
                e = 2L
                do {
                    g = d
                    g *= e
                    g -= b
                    if (g == 0L) {
                        f = 0L
                    }
                    e++
                    g = e
                    g -= b
                } while (g != 0L)
                d++
                g = d
                g -= b
            } while (g != 0L)
            if (f == 0L) {
                h++
            }
            g = b
            g -= c
            if (g != 0L) {
                b += 17
            }
        } while (g != 0L)
        return h
    }
}

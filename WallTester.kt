fun main() {
    //w is short for wall
    var position = mutableListOf(0, 0)
    var wUp = false
    var wRight = false
    var wDown = false
    var wLeft = false
    fun wCheck(x: Int,y: Int) {
        when (x) {
            -2 -> when (y) {
                2 -> {
                    wUp = true
                    wLeft = true
                }
                1 -> {
                    wLeft = true
                    wRight = true
                }
                0 -> {
                    wLeft = true
                }
                -1 -> {
                    wLeft = true
                }
                -2 -> {
                    wLeft = true
                    wDown = true
                    wRight = true
                }
            }
            -1 -> when (y) {
                2 -> {
                    wUp = true
                    wDown = true
                }
                0 -> {
                    wUp = true
                }
                -1 -> {
                    wDown = true
                }
            }
            0 -> when (y) {
                2 -> {
                    wUp = true
                }
                1 -> {
                    wLeft = true
                    wRight = true
                }
                //0 -> no walls
                -1 -> {
                    wDown = true
                }
            }
            1 -> when (y) {
                2 -> {
                    wUp = true
                }
                1 -> {
                    wLeft = true
                }
                //0 -> no walls
                -1 -> {
                    wDown = true
                }
                -2 -> {
                    wUp = true
                    wDown = true
                    wLeft = true
                }
            }
            2 -> when (y) {
                2 -> {
                    wUp = true
                    wRight = true
                }
                1 -> {
                    wRight = true
                }
                0 -> {
                    wRight = true
                }
                -1 -> {
                    wRight = true
                }
                -2 -> {
                    wRight = true
                    wDown = true
                }
            }
        }
    }
    while (true) {
        val move = readLine()
        wUp = false
        wRight = false
        wDown = false
        wLeft = false
        wCheck(position[0],position[1])
        when (move) {
            "a" -> if (wLeft == false) {
                position[0] = position[0] - 1
            } else println("wall")

            "d" -> if (wRight == false) {
                position[0] = position[0] + 1
            } else println("wall")

            "w" -> if (wUp == false) {
                position[1] = position[1] + 1
            } else println("wall")

            "s" -> if (wDown == false) {
                position[1] = position[1] - 1
            } else println("wall")
        }
        print(position)
        println()
    }
}

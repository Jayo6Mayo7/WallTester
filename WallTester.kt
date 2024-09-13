fun main() {
    //w is short for wall
    val position = mutableListOf(0, 0)
    println("Use WASD to move")
    print("Your location: ")
    print(position)
    println()
    var wUp: Boolean
    var wRight: Boolean
    var wDown: Boolean
    var wLeft: Boolean
    var ranIntoWall = false
    fun wCheck(x: Int, y: Int) {
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
        val move = readlnOrNull()
        wUp = false
        wRight = false
        wDown = false
        wLeft = false
        wCheck(position[0], position[1])
        when (move) {
            "a" -> if (!wLeft) {
                position[0] = position[0] - 1
            } else {
                println("You ran into a wall")
                ranIntoWall = true
            }

            "d" -> if (!wRight) {
                position[0] = position[0] + 1
            } else {
                println("You ran into a wall")
                ranIntoWall = true
            }

            "w" -> if (!wUp) {
                position[1] = position[1] + 1
            } else {
                println("You ran into a wall")
                ranIntoWall = true
            }

            "s" -> if (!wDown) {
                position[1] = position[1] - 1
            } else {
                println("You ran into a wall")
                ranIntoWall = true
            }
        }
        if (!ranIntoWall) {
            print("Your location: ")
            print(position)
            println()
        }
        ranIntoWall = false
    }
}

fun main() {
    //w is short for wall
    println("Enter board length: ")
    val size = readln()
    val sizeInt = size.toInt()
    val position = mutableListOf(1, 1)
    println("Use WASD to move")
    print("Your location: ")
    print(position)
    var wUp: Boolean
    var wRight: Boolean
    var wDown: Boolean
    var wLeft: Boolean
    var ranIntoWall = false
    fun wCheck(x: Any, y: Any) {
        if (x==1) {wLeft = true}
        if (x==sizeInt) {wRight = true}
        if (y==1) {wDown = true}
        if (y==sizeInt) {wUp = true}
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

import kotlin.math.abs
import kotlin.random.Random
enum class VISQUARE {TRUE, TBV, FALSE}
fun main() {
    data class Square(var upW: VISQUARE = VISQUARE.TBV, var downW: VISQUARE = VISQUARE.TBV, var leftW: VISQUARE = VISQUARE.TBV, var rightW: VISQUARE = VISQUARE.TBV)
    data class Pos(var x: Int = Random.nextInt(0,5), var y: Int = Random.nextInt(0,5))
    data class XY(var x: Int, var y: Int)
    data class XYZ(var x: Int, var y: Int, var z: String)
    var pointerPos = Pos()
    var playerPos = Pos()
    var goalPos = Pos()
    var grid = MutableList(5) { MutableList(5) { Square() } }
    var visitedGrid = MutableList(5) { MutableList(5) { VISQUARE.FALSE } }
    var tbvList = mutableListOf(XY(0,0))
    tbvList.clear()
    var squaresVisited: Int
    fun squaresVisitedChecker(): Int {
        squaresVisited = 0
        var x = 0
        var y = 0
        repeat(5) {
            repeat(5) {
                if (visitedGrid[x][y] == VISQUARE.TRUE) {
                    squaresVisited++
                }
                x++
            }
            x = 0
            y++
        }
        return squaresVisited
    }
    val saveList = mutableListOf(XYZ(0,0,""))
    saveList.clear()
    fun visit() {
        visitedGrid[pointerPos.x][pointerPos.y] = VISQUARE.TRUE
        squaresVisitedChecker()
        saveList.remove(XYZ(pointerPos.x,pointerPos.y, "up"))
        saveList.remove(XYZ(pointerPos.x,pointerPos.y, "right"))
        saveList.remove(XYZ(pointerPos.x,pointerPos.y, "down"))
        saveList.remove(XYZ(pointerPos.x,pointerPos.y, "left"))
    }
    val choiceList = mutableListOf("up","right","down","left")
    fun visquareChecker() {
        val x = pointerPos.x
        val y = pointerPos.y
        if (x > 0) {
            if (visitedGrid[x-1][y] == VISQUARE.TRUE) {
                choiceList.remove("left")
            }
        }
        if (x < 4) {
            if (visitedGrid[x+1][y] == VISQUARE.TRUE) {
                choiceList.remove("right")
            }
        }
        if (y > 0) {
            if (visitedGrid[x][y-1] == VISQUARE.TRUE) {
                choiceList.remove("down")
            }
        }
        if (y < 4) {
            if (visitedGrid[x][y+1] == VISQUARE.TRUE) {
                choiceList.remove("up")
            }
        }
    }
    fun savePos(x: Int, y: Int, mChoice: String) {
        when (mChoice) {
            "up" -> when (choiceList[1]) {
                "down" -> saveList.add(XYZ(x,y,"down"))
                "right" -> saveList.add(XYZ(x,y,"right"))
                "left" -> saveList.add(XYZ(x,y,"left"))
            }
            "right" -> when (choiceList[0]) {
                "up" -> saveList.add(XYZ(x,y,"up"))
                "right" -> when (choiceList[1]) {
                    "down" -> saveList.add(XYZ(x,y,"down"))
                    "left" -> saveList.add(XYZ(x,y,"left"))
                }
            }
            "down" -> when (choiceList[0]) {
                "up" -> saveList.add(XYZ(x,y,"up"))
                "right" -> saveList.add(XYZ(x,y,"right"))
                "down" -> when(choiceList[1]) {
                    "left" -> saveList.add(XYZ(x,y,"left"))
                }

            }
            "left" -> when (choiceList[0]) {
                "up" -> saveList.add(XYZ(x,y,"up"))
                "down" -> saveList.add(XYZ(x,y,"down"))
                "right" -> saveList.add(XYZ(x,y,"right"))
            }
        }
    }
    fun falsifyWalls(x: Int, y: Int, oldX: Int, oldY: Int) {
        var varX = 0
        var varY = 0
        repeat(5) {
            repeat(5) {
                if (x == varX && y == varY) {
                    if (oldX == x + 1) {
                        grid[x][y].rightW = VISQUARE.FALSE
                        grid[oldX][oldY].leftW = VISQUARE.FALSE
                    }
                    if (oldX == x - 1) {
                        grid[x][y].leftW = VISQUARE.FALSE
                        grid[oldX][oldY].rightW = VISQUARE.FALSE
                    }
                    if (oldY == y + 1) {
                        grid[x][y].upW = VISQUARE.FALSE
                        grid[oldX][oldY].downW = VISQUARE.FALSE
                    }
                    if (oldY == y - 1) {
                        grid[x][y].downW = VISQUARE.FALSE
                        grid[oldX][oldY].upW = VISQUARE.FALSE
                    }
                }
                ++varX
            }
            ++varY
            varX = 0
        }
    }
    fun fakeMove() {
        visit()
        var save = false
        choiceList.clear()
        choiceList.add("up")
        choiceList.add("right")
        choiceList.add("down")
        choiceList.add("left")
        visquareChecker()
        if (pointerPos.x == 0 && pointerPos.y == 0) {
            choiceList.remove("down")
            choiceList.remove("left")
        }
        else if (pointerPos.x == 0 && pointerPos.y == 4) {
            choiceList.remove("left")
            choiceList.remove("up")
        }
        else if (pointerPos.x == 4 && pointerPos.y == 4) {
            choiceList.remove("right")
            choiceList.remove("up")
        }
        else if (pointerPos.x == 4 && pointerPos.y == 0) {
            choiceList.remove("right")
            choiceList.remove("down")
        }
        else if (pointerPos.x == 0) {choiceList.remove("left")}
        else if (pointerPos.y == 0) {choiceList.remove("down")}
        else if (pointerPos.y == 4) {choiceList.remove("up")}
        else if (pointerPos.x == 4) {choiceList.remove("right")}
        if (choiceList.size == 2) { save = true }
        if (choiceList.size > 0) {
            val ogX = pointerPos.x
            val ogY = pointerPos.y
            var moveChoosing = true
            var moveChoice = ""
            while (moveChoosing) {
                moveChoice = choiceList.random()
                when (moveChoice) {
                    "up" -> {
                        if (visitedGrid[pointerPos.x][pointerPos.y + 1] != VISQUARE.TRUE) {
                            ++pointerPos.y
                            moveChoosing = false
                        }
                    }
                    "down" -> {
                        if (visitedGrid[pointerPos.x][pointerPos.y - 1] != VISQUARE.TRUE) {
                            --pointerPos.y
                            moveChoosing = false
                        }
                    }
                    "left" -> {
                        if (visitedGrid[pointerPos.x - 1][pointerPos.y] != VISQUARE.TRUE) {
                            --pointerPos.x
                            moveChoosing = false
                        }
                    }
                    "right" -> {
                        if (visitedGrid[pointerPos.x + 1][pointerPos.y] != VISQUARE.TRUE) {
                            ++pointerPos.x
                            moveChoosing = false
                        }
                    }
                }
                falsifyWalls(pointerPos.x,pointerPos.y,ogX,ogY)
            }
            if (save) {savePos(ogX, ogY, moveChoice)}
        }
        visit()
        if (choiceList.size == 0) {
            visit()
            var tpChoosing = true
            while (tpChoosing) {
                val tpChoice = saveList.random()
                pointerPos.x = tpChoice.x
                pointerPos.y = tpChoice.y
                val ogX2 = pointerPos.x
                val ogY2 = pointerPos.y
                when (tpChoice.z) {
                    "up" -> {
                        ++pointerPos.y
                    }
                    "right" -> {
                        ++pointerPos.x
                    }
                    "down" -> {
                        --pointerPos.y
                    }
                    "left" -> {
                        --pointerPos.x
                    }
                }
                saveList.remove(tpChoice)
                if (visitedGrid[pointerPos.x][pointerPos.y] != VISQUARE.TRUE) {
                    when (tpChoice.z) {
                        "up" -> {
                            grid[ogX2][ogY2].upW = VISQUARE.FALSE
                            grid[pointerPos.x][pointerPos.y].downW = VISQUARE.FALSE
                        }
                        "right" -> {
                            grid[ogX2][ogY2].rightW = VISQUARE.FALSE
                            grid[pointerPos.x][pointerPos.y].leftW = VISQUARE.FALSE
                        }
                        "down" -> {
                            grid[ogX2][ogY2].downW = VISQUARE.FALSE
                            grid[pointerPos.x][pointerPos.y].upW = VISQUARE.FALSE
                        }
                        "left" -> {
                            grid[ogX2][ogY2].leftW = VISQUARE.FALSE
                            grid[pointerPos.x][pointerPos.y].rightW = VISQUARE.FALSE
                        }
                    }
                    tpChoosing = false
                }
            }
        }
        visit()
    }
    fun walls() {
        var x = 0
        var y = 0
        repeat(5) {
            repeat(5) {
                if (grid[x][y].upW != VISQUARE.FALSE) {grid[x][y].upW = VISQUARE.TRUE}
                if (grid[x][y].rightW != VISQUARE.FALSE) {grid[x][y].rightW = VISQUARE.TRUE}
                if (grid[x][y].downW != VISQUARE.FALSE) {grid[x][y].downW = VISQUARE.TRUE}
                if (grid[x][y].leftW != VISQUARE.FALSE) {grid[x][y].leftW = VISQUARE.TRUE}
                ++x
            }
            ++y
            x = 0
        }
    }
    fun mapUL() {
        var x = 0
        var y = 4
        repeat(5) {
            print(" ")
            if (grid[x][y].upW == VISQUARE.TRUE) {
                print("_")
            }
            else print(" ")
            ++x
        }
        --y
        x = 0
        println("")
        repeat(4) {
            repeat(5) {
                if (grid[x][y + 1].leftW == VISQUARE.TRUE) {
                    print("|")
                } else print(" ")
                if (grid[x][y].upW == VISQUARE.TRUE) {
                    print("_")
                } else print(" ")
                ++x
            }
            println("|")
            --y
            x = 0
        }
        y = 0
        repeat(5) {
            if (grid[x][y].leftW == VISQUARE.TRUE) {
                print("|")
            }
            else print(" ")
            print("_")
            ++x
        }
        println("|")
    }
    fun makeMaze() {
        grid = MutableList(5) { MutableList(5) { Square() } }
        visitedGrid = MutableList(5) { MutableList(5) { VISQUARE.FALSE } }
        tbvList = mutableListOf(XY(0,0))
        tbvList.clear()
        pointerPos = Pos()
        playerPos = Pos()
        goalPos = Pos()
        visit()
        repeat(24) {
            fakeMove()
        }
        walls()
    }
    println("Enter 'up', 'down', 'left', or 'right' to move")
    println("Or enter 'w', 'a', 's', or 'd'\n\n")
    makeMaze()
    while (true) {
        var hitWall = true
        val move = readln()
        when (move) {
            "up", "w" -> if (grid[playerPos.x][playerPos.y].upW == VISQUARE.FALSE) {
                ++playerPos.y
                hitWall = false
            }
            "right", "d" -> if (grid[playerPos.x][playerPos.y].rightW == VISQUARE.FALSE) {
                ++playerPos.x
                hitWall = false
            }
            "down", "s" -> if (grid[playerPos.x][playerPos.y].downW == VISQUARE.FALSE) {
                --playerPos.y
                hitWall = false
            }
            "left", "a" -> if (grid[playerPos.x][playerPos.y].leftW == VISQUARE.FALSE) {
                --playerPos.x
                hitWall = false
            }
            "map" -> mapUL()
            "player" -> println("Player: $playerPos")
            "goal" -> println("Goal: $goalPos")
        }
        val xDistance = abs(playerPos.x - goalPos.x)
        val yDistance = abs(playerPos.y - goalPos.y)
        val totalDistance = xDistance + yDistance
        if (hitWall) {println("There is a wall in that direction")}
        else println("The goal seems to be $totalDistance squares away")
        if (totalDistance == 0) {
            println("\nYou completed this maze!")
            Thread.sleep(2000)
            println("Ready to try another one?")
            makeMaze()
        }
    }
}

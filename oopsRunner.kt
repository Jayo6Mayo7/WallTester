import kotlin.random.Random

fun main() {
    class Wall(val id: Any, var on: Boolean, val square1: Any, val square2: Any)
    class Square(val id: Any, val north: Any, val east: Any, val south: Any, val west: Any)

    val s99 = Square(99, 99,99,99,99)
    val s00 = Square(0.0,36,17,99,99)
    val s10 = Square(10, 37,18,99,17)
    val s20 = Square(20, 38,19,99,18)
    val s30 = Square(30, 39,20,99,19)
    val s40 = Square(40, 40,99,99,20)
    val s01 = Square(0.1,31,13,36,99)
    val s11 = Square(11, 32,14,37,13)
    val s21 = Square(21, 33,15,38,14)
    val s31 = Square(31, 34,16,39,15)
    val s41 = Square(41, 35,99,40,16)
    val s02 = Square(0.2,26,9, 31,99)
    val s12 = Square(12, 27,10,32,9)
    val s22 = Square(22, 28,11,33,10)
    val s32 = Square(32, 29,12,34,11)
    val s42 = Square(42, 30,99,35,12)
    val s03 = Square(0.3,21,5, 26,99)
    val s13 = Square(13, 22,6, 27,5)
    val s23 = Square(23, 23,7, 28,6)
    val s33 = Square(33, 24,8, 29,7)
    val s43 = Square(43, 25,99,30,8)
    val s04 = Square(0.4,99,1, 21,99)
    val s14 = Square(14, 99,2, 22,1)
    val s24 = Square(24, 99,3, 23,2)
    val s34 = Square(34, 99,4, 24,3)
    val s44 = Square(44, 99,99,25,4)
    //square 1 = west/north, square 2 = east/south
    val w99 = Wall(99, false, 99, 99)
    val w1 = Wall(1, false, 0.4,14)
    val w2 = Wall(2, false, 14, 24)
    val w3 = Wall(3, false, 24, 34)
    val w4 = Wall(4, false, 34, 44)
    val w5 = Wall(5, false, 0.3, 13)
    val w6 = Wall(6, false, 13, 23)
    val w7 = Wall(7, false, 23, 33)
    val w8 = Wall(8, false, 33, 43)
    val w9 = Wall(9, false, 0.2, 12)
    val w10 = Wall(10, false, 12, 22)
    val w11 = Wall(11, false, 22, 32)
    val w12 = Wall(12, false, 32, 42)
    val w13 = Wall(13, false, 0.1, 11)
    val w14 = Wall(14, false, 11, 21)
    val w15 = Wall(15, false, 21, 31)
    val w16 = Wall(16, false, 13, 14)
    val w17 = Wall(17, false, 0.0, 10)
    val w18 = Wall(18, false, 10, 20)
    val w19 = Wall(19, false, 20, 30)
    val w20 = Wall(20, false, 30, 40)
    //
    val w21 = Wall(21, false, 0.4,0.3)
    val w22 = Wall(22, false, 14,13)
    val w23 = Wall(23, false, 24,23)
    val w24 = Wall(24, false, 34,33)
    val w25 = Wall(25, false, 44,43)
    val w26 = Wall(26, false, 0.3,0.2)
    val w27 = Wall(27, false, 13,12)
    val w28 = Wall(28, false, 23,22)
    val w29 = Wall(29, false, 33,32)
    val w30 = Wall(30, false, 43,42)
    val w31 = Wall(31, false, 0.2,0.1)
    val w32 = Wall(32, false, 12,11)
    val w33 = Wall(33, false, 22,21)
    val w34 = Wall(34, false, 32,31)
    val w35 = Wall(35, false, 42,41)
    val w36 = Wall(36, false, 0.1,0.0)
    val w37 = Wall(37, false, 11,10)
    val w38 = Wall(38, false, 21,20)
    val w39 = Wall(39, false, 31,30)
    val w40 = Wall(40, false, 41,40)

    
    //drawer location
    val dLoc = mutableListOf(Random.nextInt(0,5),Random.nextInt(0,5))


    fun getSquare2(x: Int, y: Int): Any {
        when (x) {
            0 -> when (y) {
                0 -> return s00.id
                1 -> return s01.id
                2 -> return s02.id
                3 -> return s03.id
                4 -> return s04.id
            }
            1 -> when (y) {
                0 -> return s10.id
                1 -> return s11.id
                2 -> return s12.id
                3 -> return s13.id
                4 -> return s14.id
            }
            2 -> when (y) {
                0 -> return s20.id
                1 -> return s21.id
                2 -> return s22.id
                3 -> return s23.id
                4 -> return s24.id
            }
            3 -> when (y) {
                0 -> return s30.id
                1 -> return s31.id
                2 -> return s32.id
                3 -> return s33.id
                4 -> return s34.id
            }
            4 -> when (y) {
                0 -> return s40.id
                1 -> return s41.id
                2 -> return s42.id
                3 -> return s43.id
                4 -> return s44.id
            }
        }
        println("uh oh s99.id")
        return s99.id
    }

    fun getSquare1(x: Any): Square {
        when (x) {
            0.0 -> return s00
            0.1 -> return s01
            0.2 -> return s02
            0.3 -> return s03
            0.4 -> return s04
            10 -> return s10
            11 -> return s11
            12 -> return s12
            13 -> return s13
            14 -> return s14
            20 -> return s20
            21 -> return s21
            22 -> return s22
            23 -> return s23
            24 -> return s24
            30 -> return s30
            31 -> return s31
            32 -> return s32
            33 -> return s33
            34 -> return s34
            40 -> return s40
            41 -> return s41
            42 -> return s42
            43 -> return s43
            44 -> return s44
        }
        println("uh oh s99 2")
        return s99
    }

    fun getWall(x: Any): Wall {
        when (x) {
            1 -> return w1
            2 -> return w2
            3 -> return w3
            4 -> return w4
            5 -> return w5
            6 -> return w6
            7 -> return w7
            8 -> return w8
            9 -> return w9
            10 -> return w10
            11 -> return w11
            12 -> return w12
            13 -> return w13
            14 -> return w14
            15 -> return w15
            16 -> return w16
            17 -> return w17
            18 -> return w18
            19 -> return w19
            20 -> return w20
            21 -> return w21
            22 -> return w22
            23 -> return w23
            24 -> return w24
            25 -> return w25
            26 -> return w26
            27 -> return w27
            28 -> return w28
            29 -> return w29
            30 -> return w30
            31 -> return w31
            32 -> return w32
            33 -> return w33
            34 -> return w34
            35 -> return w35
            36 -> return w36
            37 -> return w37
            38 -> return w38
            39 -> return w39
            40 -> return w40
        }
        println("uh oh w99")
        return w99
    }


    val moveList = mutableListOf(s99.id)
    moveList.remove(s99.id)
    fun nearSquares(x: Int, y: Int) {
        var location = getSquare2(x,y)
        location = getSquare1(location)
        if (location.north!=99) {
            val touchingWallA = getWall(location.north)

            val squareA = getSquare1(touchingWallA.square1)
            val squareB = getSquare1(touchingWallA.square2)
            if (location==squareA) {
                moveList.add(squareB.id)
            }
            else if (location==squareB) {
                moveList.add(squareA.id)
            }
        } else if (location.north==99) moveList.add(99)
        if (location.east!=99) {
            val touchingWallB = getWall(location.east)
            val squareC = getSquare1(touchingWallB.square1)
            val squareD = getSquare1(touchingWallB.square2)
            if (location==squareC) {
                moveList.add(squareD.id)
            }
            else if (location==squareD) {
                moveList.add(squareC.id)
            }
        } else if (location.east==99) moveList.add(99)
        if (location.south!=99) {
            val touchingWallC = getWall(location.south)
            val squareE = getSquare1(touchingWallC.square1)
            val squareF = getSquare1(touchingWallC.square2)
            if (location==squareE) {
                moveList.add(squareF.id)
            }
            else if (location==squareF) {
                moveList.add(squareE.id)
            }
        } else if (location.south==99) moveList.add(99)
        if (location.west!=99) {
            val touchingWallD = getWall(location.west)
            val squareG = getSquare1(touchingWallD.square1)
            val squareH = getSquare1(touchingWallD.square2)
            if (location==squareG) {
                moveList.add(squareH.id)
            }
            else if (location==squareH) {
                moveList.add(squareG.id)
            }
        } else if (location.west==99) moveList.add(99)
    }





}

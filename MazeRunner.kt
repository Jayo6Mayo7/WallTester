import kotlin.math.abs
import kotlin.random.Random

enum class WALLDIRECTION {
    VERTICAL, HORIZONTAL, TELEPORT
}

enum class MOVEOPTIONS {
    UPMOVE, DOWNMOVE, LEFTMOVE, RIGHTMOVE
}
enum class WALL {
    TRUE, FALSE, TOUCH, NA
}
enum class SQUARE {
    VST, TBV, NTV
    //VST: Visited
    //TBV: To be visited
    //NTV: Not visted (and not to be visited)
}
fun main() {
    while (true) {
        //w is short for wall
        //yes I definitely should have abbreviated point to p
        var playing = true
        //TODO should player position be random?
        val position = mutableListOf(Random.nextInt(-2, 2), Random.nextInt(-2, 2))
        val finishPosition = mutableListOf(Random.nextInt(-2, 2), Random.nextInt(-2, 2))
        val pointerPosition = mutableListOf(Random.nextInt(0,5),Random.nextInt(0,5))
        val previousPointerPosition = mutableListOf(Random.nextInt(0,5),Random.nextInt(0,5))
        var wUp: Boolean
        var wRight: Boolean
        var wDown: Boolean
        var wLeft: Boolean
        var w1 = WALL.NA
        var w2 = WALL.NA
        var w3 = WALL.NA
        var w4 = WALL.NA
        var w5 = WALL.NA
        var w6 = WALL.NA
        var w7 = WALL.NA
        var w8 = WALL.NA
        var w9 = WALL.NA
        var w10 = WALL.NA
        var w11 = WALL.NA
        var w12 = WALL.NA
        var w13 = WALL.NA
        var w14 = WALL.NA
        var w15 = WALL.NA
        var w16 = WALL.NA
        var w17 = WALL.NA
        var w18 = WALL.NA
        var w19 = WALL.NA
        var w20 = WALL.NA
        var w21 = WALL.NA
        var w22 = WALL.NA
        var w23 = WALL.NA
        var w24 = WALL.NA
        var w25 = WALL.NA
        var w26 = WALL.NA
        var w27 = WALL.NA
        var w28 = WALL.NA
        var w29 = WALL.NA
        var w30 = WALL.NA
        var w31 = WALL.NA
        var w32 = WALL.NA
        var w33 = WALL.NA
        var w34 = WALL.NA
        var w35 = WALL.NA
        var w36 = WALL.NA
        var w37 = WALL.NA
        var w38 = WALL.NA
        var w39 = WALL.NA
        var w40 = WALL.NA
        val square00 = mutableListOf(SQUARE.NTV, 0, 0)
        val square01 = mutableListOf(SQUARE.NTV, 0, 1)
        val square02 = mutableListOf(SQUARE.NTV, 0, 2)
        val square03 = mutableListOf(SQUARE.NTV, 0, 3)
        val square04 = mutableListOf(SQUARE.NTV, 0, 4)
        val square10 = mutableListOf(SQUARE.NTV, 1, 0)
        val square11 = mutableListOf(SQUARE.NTV, 1, 1)
        val square12 = mutableListOf(SQUARE.NTV, 1, 2)
        val square13 = mutableListOf(SQUARE.NTV, 1, 3)
        val square14 = mutableListOf(SQUARE.NTV, 1, 4)
        val square20 = mutableListOf(SQUARE.NTV, 2, 0)
        val square21 = mutableListOf(SQUARE.NTV, 2, 1)
        val square22 = mutableListOf(SQUARE.NTV, 2, 2)
        val square23 = mutableListOf(SQUARE.NTV, 2, 3)
        val square24 = mutableListOf(SQUARE.NTV, 2, 4)
        val square30 = mutableListOf(SQUARE.NTV, 3, 0)
        val square31 = mutableListOf(SQUARE.NTV, 3, 1)
        val square32 = mutableListOf(SQUARE.NTV, 3, 2)
        val square33 = mutableListOf(SQUARE.NTV, 3, 3)
        val square34 = mutableListOf(SQUARE.NTV, 3, 4)
        val square40 = mutableListOf(SQUARE.NTV, 4, 0)
        val square41 = mutableListOf(SQUARE.NTV, 4, 1)
        val square42 = mutableListOf(SQUARE.NTV, 4, 2)
        val square43 = mutableListOf(SQUARE.NTV, 4, 3)
        val square44 = mutableListOf(SQUARE.NTV, 4, 4)

        /*
        list all squares
        start on [-2,-2]
        move once in random direction
        keep track of discovered/to be discovered


        define all squares + squares they connect to
        if on square -> visited
        if near square -> to be visited
        else -> not visited
        if to be visited squares exist -> pick random one to go to
         */

        var i = 0
        var teleportCount = 0
        var wallCount = 0

        fun visit(w: Any) {
            when (w) {
                0.0 -> square00[0]=SQUARE.VST
                0.1 -> square01[0]=SQUARE.VST
                0.2 -> square02[0]=SQUARE.VST
                0.3 -> square03[0]=SQUARE.VST
                0.4 -> square04[0]=SQUARE.VST
                10 -> square10[0]=SQUARE.VST
                11 -> square11[0]=SQUARE.VST
                12 -> square12[0]=SQUARE.VST
                13 -> square13[0]=SQUARE.VST
                14 -> square14[0]=SQUARE.VST
                20 -> square20[0]=SQUARE.VST
                21 -> square21[0]=SQUARE.VST
                22 -> square22[0]=SQUARE.VST
                23 -> square23[0]=SQUARE.VST
                24 -> square24[0]=SQUARE.VST
                30 -> square30[0]=SQUARE.VST
                31 -> square31[0]=SQUARE.VST
                32 -> square32[0]=SQUARE.VST
                33 -> square33[0]=SQUARE.VST
                34 -> square34[0]=SQUARE.VST
                40 -> square40[0]=SQUARE.VST
                41 -> square41[0]=SQUARE.VST
                42 -> square42[0]=SQUARE.VST
                43 -> square43[0]=SQUARE.VST
                44 -> square44[0]=SQUARE.VST
            }
        }
        fun visitSquare (x: Int, y: Int) {
            when (x) {
                0 -> when (y) {
                    0 -> visit(0.0)
                    1 -> visit(0.1)
                    2 -> visit(0.2)
                    3 -> visit(0.3)
                    4 -> visit(0.4)
                }
                1 -> when (y) {
                    0 -> visit(10)
                    1 -> visit(11)
                    2 -> visit(12)
                    3 -> visit(13)
                    4 -> visit(14)
                }
                2 -> when (y) {
                    0 -> visit(20)
                    1 -> visit(21)
                    2 -> visit(22)
                    3 -> visit(23)
                    4 -> visit(24)
                }
                3 -> when (y) {
                    0 -> visit(30)
                    1 -> visit(31)
                    2 -> visit(32)
                    3 -> visit(33)
                    4 -> visit(34)
                }
                4 -> when (y) {
                    0 -> visit(40)
                    1 -> visit(41)
                    2 -> visit(42)
                    3 -> visit(43)
                    4 -> visit(44)
                }
            }
        }

        fun tbvVisit(w: Any) {
            when (w) {
                0.0 -> {
                    if (w36==WALL.NA) {
                        if (square10[0]!=SQUARE.VST) {
                            square10[0]=SQUARE.TBV
                        }
                    }
                    if (w17==WALL.NA) {
                        if (square01[0]!=SQUARE.VST) {
                            square01[0]=SQUARE.TBV
                        }
                    }
                }
                0.1 -> {
                    //SHOULD BE INVERTED
                    if (w36 == WALL.NA) {
                        if (square00[0]!=SQUARE.VST) {
                            square00[0]=SQUARE.TBV
                        }
                    }
                    if (w31 == WALL.NA) {
                        if (square02[0]!=SQUARE.VST) {
                            square02[0]=SQUARE.TBV
                        }
                    }
                    if (w13 == WALL.NA) {
                        if (square11[0]!=SQUARE.VST) {
                            square11[0]=SQUARE.TBV
                        }
                    }
                }
                0.2 -> {
                    if (w26==WALL.NA) {
                        if (square03[0]!==SQUARE.VST) {
                            square03[0]=SQUARE.TBV
                        }
                    }
                    if (w9==WALL.NA) {
                        if (square12[0]!==SQUARE.VST) {
                            square12[0]=SQUARE.TBV
                        }
                    }
                    if (w31==WALL.NA) {
                        if (square01[0]!==SQUARE.VST) {
                            square01[0]=SQUARE.TBV
                        }
                    }
                }
                0.3 -> {
                    if (w21==WALL.NA) {
                        if (square04[0]!==SQUARE.VST) {
                            square04[0]=SQUARE.TBV
                        }
                    }
                    if (w5==WALL.NA) {
                        if (square13[0]!==SQUARE.VST) {
                            square13[0]=SQUARE.TBV
                        }
                    }
                    if (w26==WALL.NA) {
                        if (square02[0]!==SQUARE.VST) {
                            square02[0]=SQUARE.TBV
                        }
                    }
                }
                0.4 -> {
                    if (w1==WALL.NA) {
                        if (square14[0]!==SQUARE.VST) {
                            square14[0]=SQUARE.TBV
                        }
                    }
                    if (w21==WALL.NA) {
                        if (square03[0]!==SQUARE.VST) {
                            square03[0]=SQUARE.TBV
                        }
                    }
                }
                10 -> {
                    if (w37==WALL.NA) {
                        if (square20[0]!==SQUARE.VST) {
                            square20[0]=SQUARE.TBV
                        }
                    }
                    if (w18==WALL.NA) {
                        if (square11[0]!==SQUARE.VST) {
                            square11[0]=SQUARE.TBV
                        }
                    }
                    if (w17==WALL.NA) {
                        if (square00[0]!==SQUARE.VST) {
                            square00[0]=SQUARE.TBV
                        }
                    }
                }
                11 -> {
                    if (w32==WALL.NA) {
                        if (square12[0]!==SQUARE.VST) {
                            square12[0]=SQUARE.TBV
                        }
                    }
                    if (w10==WALL.NA) {
                        if (square21[0]!==SQUARE.VST) {
                            square21[0]=SQUARE.TBV
                        }
                    }
                    if (w32==WALL.NA) {
                        if (square10[0]!==SQUARE.VST) {
                            square10[0]=SQUARE.TBV
                        }
                    }
                    if (w9==WALL.NA) {
                        if (square01[0]!==SQUARE.VST) {
                            square01[0]=SQUARE.TBV
                        }
                    }
                }
                12 -> {
                    if (w27==WALL.NA) {
                        if (square13[0]!==SQUARE.VST) {
                            square13[0]=SQUARE.TBV
                        }
                    }
                    if (w10==WALL.NA) {
                        if (square22[0]!==SQUARE.VST) {
                            square22[0]=SQUARE.TBV
                        }
                    }
                    if (w32==WALL.NA) {
                        if (square11[0]!==SQUARE.VST) {
                            square11[0]=SQUARE.TBV
                        }
                    }
                    if (w9==WALL.NA) {
                        if (square02[0]!==SQUARE.VST) {
                            square02[0]=SQUARE.TBV
                        }
                    }
                }
                13 -> {
                    if (w22==WALL.NA) {
                        if (square14[0]!==SQUARE.VST) {
                            square14[0]=SQUARE.TBV
                        }
                    }
                    if (w6==WALL.NA) {
                        if (square23[0]!==SQUARE.VST) {
                            square23[0]=SQUARE.TBV
                        }
                    }
                    if (w27==WALL.NA) {
                        if (square12[0]!==SQUARE.VST) {
                            square12[0]=SQUARE.TBV
                        }
                    }
                    if (w5==WALL.NA) {
                        if (square03[0]!==SQUARE.VST) {
                            square03[0]=SQUARE.TBV
                        }
                    }
                }
                14 -> {
                    if (w2==WALL.NA) {
                        if (square24[0]!==SQUARE.VST) {
                            square24[0]=SQUARE.TBV
                        }
                    }
                    if (w22==WALL.NA) {
                        if (square13[0]!==SQUARE.VST) {
                            square13[0]=SQUARE.TBV
                        }
                    }
                    if (w1==WALL.NA) {
                        if (square04[0]!==SQUARE.VST) {
                            square04[0]=SQUARE.TBV
                        }
                    }
                }
                20 -> {
                    if (w38==WALL.NA) {
                        if (square21[0]!==SQUARE.VST) {
                            square21[0]=SQUARE.TBV
                        }
                    }
                    if (w19==WALL.NA) {
                        if (square30[0]!==SQUARE.VST) {
                            square30[0]=SQUARE.TBV
                        }
                    }
                    if (w18==WALL.NA) {
                        if (square10[0]!==SQUARE.VST) {
                            square10[0]=SQUARE.TBV
                        }
                    }
                }
                21 -> {
                    if (w33==WALL.NA) {
                        if (square22[0]!==SQUARE.VST) {
                            square22[0]=SQUARE.TBV
                        }
                    }
                    if (w15==WALL.NA) {
                        if (square31[0]!==SQUARE.VST) {
                            square31[0]=SQUARE.TBV
                        }
                    }
                    if (w38==WALL.NA) {
                        if (square20[0]!==SQUARE.VST) {
                            square20[0]=SQUARE.TBV
                        }
                    }
                    if (w14==WALL.NA) {
                        if (square11[0]!==SQUARE.VST) {
                            square11[0]=SQUARE.TBV
                        }
                    }
                }
                22 -> {
                    if (w28==WALL.NA) {
                        if (square23[0]!==SQUARE.VST) {
                            square23[0]=SQUARE.TBV
                        }
                    }
                    if (w11==WALL.NA) {
                        if (square32[0]!==SQUARE.VST) {
                            square32[0]=SQUARE.TBV
                        }
                    }
                    if (w33==WALL.NA) {
                        if (square21[0]!==SQUARE.VST) {
                            square21[0]=SQUARE.TBV
                        }
                    }
                    if (w10==WALL.NA) {
                        if (square12[0]!==SQUARE.VST) {
                            square12[0]=SQUARE.TBV
                        }
                    }
                }
                23 -> {
                    if (w23==WALL.NA) {
                        if (square24[0]!==SQUARE.VST) {
                            square24[0]=SQUARE.TBV
                        }
                    }
                    if (w7==WALL.NA) {
                        if (square33[0]!==SQUARE.VST) {
                            square33[0]=SQUARE.TBV
                        }
                    }
                    if (w28==WALL.NA) {
                        if (square22[0]!==SQUARE.VST) {
                            square22[0]=SQUARE.TBV
                        }
                    }
                    if (w6==WALL.NA) {
                        if (square13[0]!==SQUARE.VST) {
                            square13[0]=SQUARE.TBV
                        }
                    }
                }
                24 -> {
                    if (w3==WALL.NA) {
                        if (square34[0]!==SQUARE.VST) {
                            square34[0]=SQUARE.TBV
                        }
                    }
                    if (w23==WALL.NA) {
                        if (square23[0]!==SQUARE.VST) {
                            square23[0]=SQUARE.TBV
                        }
                    }
                    if (w2==WALL.NA) {
                        if (square14[0]!==SQUARE.VST) {
                            square14[0]=SQUARE.TBV
                        }
                    }
                }
                30 -> {
                    if (w39==WALL.NA) {
                        if (square31[0]!==SQUARE.VST) {
                            square31[0]=SQUARE.TBV
                        }
                    }
                    if (w20==WALL.NA) {
                        if (square40[0]!==SQUARE.VST) {
                            square40[0]=SQUARE.TBV
                        }
                    }
                    if (w19==WALL.NA) {
                        if (square20[0]!==SQUARE.VST) {
                            square20[0]=SQUARE.TBV
                        }
                    }
                }
                31 -> {
                    if (w34==WALL.NA) {
                        if (square32[0]!==SQUARE.VST) {
                            square32[0]=SQUARE.TBV
                        }
                    }
                    if (w16==WALL.NA) {
                        if (square41[0]!==SQUARE.VST) {
                            square41[0]=SQUARE.TBV
                        }
                    }
                    if (w39==WALL.NA) {
                        if (square30[0]!==SQUARE.VST) {
                            square30[0]=SQUARE.TBV
                        }
                    }
                    if (w15==WALL.NA) {
                        if (square21[0]!==SQUARE.VST) {
                            square21[0]=SQUARE.TBV
                        }
                    }
                }
                32 -> {
                    if (w29==WALL.NA) {
                        if (square33[0]!==SQUARE.VST) {
                            square33[0]=SQUARE.TBV
                        }
                    }
                    if (w12==WALL.NA) {
                        if (square42[0]!==SQUARE.VST) {
                            square42[0]=SQUARE.TBV
                        }
                    }
                    if (w34==WALL.NA) {
                        if (square31[0]!==SQUARE.VST) {
                            square31[0]=SQUARE.TBV
                        }
                    }
                    if (w11==WALL.NA) {
                        if (square22[0]!==SQUARE.VST) {
                            square22[0]=SQUARE.TBV
                        }
                    }
                }
                33 -> {
                    if (w24==WALL.NA) {
                        if (square34[0]!==SQUARE.VST) {
                            square34[0]=SQUARE.TBV
                        }
                    }
                    if (w8==WALL.NA) {
                        if (square43[0]!==SQUARE.VST) {
                            square43[0]=SQUARE.TBV
                        }
                    }
                    if (w29==WALL.NA) {
                        if (square32[0]!==SQUARE.VST) {
                            square32[0]=SQUARE.TBV
                        }
                    }
                    if (w7==WALL.NA) {
                        if (square23[0]!==SQUARE.VST) {
                            square23[0]=SQUARE.TBV
                        }
                    }
                }
                34 -> {
                    if (w4==WALL.NA) {
                        if (square44[0]!==SQUARE.VST) {
                            square44[0]=SQUARE.TBV
                        }
                    }
                    if (w24==WALL.NA) {
                        if (square33[0]!==SQUARE.VST) {
                            square33[0]=SQUARE.TBV
                        }
                    }
                    if (w3==WALL.NA) {
                        if (square24[0]!==SQUARE.VST) {
                            square24[0]=SQUARE.TBV
                        }
                    }
                }
                40 -> {
                    if (w40==WALL.NA) {
                        if (square41[0]!==SQUARE.VST) {
                            square41[0]=SQUARE.TBV
                        }
                    }
                    if (w20==WALL.NA) {
                        if (square30[0]!==SQUARE.VST) {
                            square30[0]=SQUARE.TBV
                        }
                    }

                }
                41 -> {
                    if (w35==WALL.NA) {
                        if (square42[0]!==SQUARE.VST) {
                            square42[0]=SQUARE.TBV
                        }
                        if (w40==WALL.NA) {
                            if (square40[0]!==SQUARE.VST) {
                                square40[0]=SQUARE.TBV
                            }
                        }
                        if (w16==WALL.NA) {
                            if (square31[0]!==SQUARE.VST) {
                                square31[0]=SQUARE.TBV
                            }
                        }
                    }
                }
                42 -> {
                    if (w30==WALL.NA) {
                        if (square43[0]!==SQUARE.VST) {
                            square43[0]=SQUARE.TBV
                        }
                    }
                    if (w35==WALL.NA) {
                        if (square41[0]!==SQUARE.VST) {
                            square41[0]=SQUARE.TBV
                        }
                    }
                    if (w12==WALL.NA) {
                        if (square32[0]!==SQUARE.VST) {
                            square32[0]=SQUARE.TBV
                        }
                    }
                }
                43 -> {
                    if (w25==WALL.NA) {
                        if (square44[0]!==SQUARE.VST) {
                            square44[0]=SQUARE.TBV
                        }
                    }
                    if (w30==WALL.NA) {
                        if (square42[0]!==SQUARE.VST) {
                            square42[0]=SQUARE.TBV
                        }
                    }
                    if (w8==WALL.NA) {
                        if (square33[0]!==SQUARE.VST) {
                            square33[0]=SQUARE.TBV
                        }
                    }
                }
                44 -> {
                    if (w25==WALL.NA) {
                        if (square43[0]!==SQUARE.VST) {
                            square43[0]=SQUARE.TBV
                        }
                    }
                    if (w4==WALL.NA) {
                        if (square34[0]!==SQUARE.VST) {
                            square34[0]=SQUARE.TBV
                        }
                    }
                }
            }
        }
        fun tbvSquare(x: Int, y:Int) {
                when (x) {
                    0 -> when (y) {
                        0 -> tbvVisit(0.0)
                        1 -> tbvVisit(0.1)
                        2 -> tbvVisit(0.2)
                        3 -> tbvVisit(0.3)
                        4 -> tbvVisit(0.4)
                    }
                    1 -> when (y) {
                        0 -> tbvVisit(10)
                        1 -> tbvVisit(11)
                        2 -> tbvVisit(12)
                        3 -> tbvVisit(13)
                        4 -> tbvVisit(14)
                    }
                    2 -> when (y) {
                        0 -> tbvVisit(20)
                        1 -> tbvVisit(21)
                        2 -> tbvVisit(22)
                        3 -> tbvVisit(23)
                        4 -> tbvVisit(24)
                    }
                    3 -> when (y) {
                        0 -> tbvVisit(30)
                        1 -> tbvVisit(31)
                        2 -> tbvVisit(32)
                        3 -> tbvVisit(33)
                        4 -> tbvVisit(34)
                    }
                    4 -> when (y) {
                        0 -> tbvVisit(40)
                        1 -> tbvVisit(41)
                        2 -> tbvVisit(42)
                        3 -> tbvVisit(43)
                        4 -> tbvVisit(44)
                    }
                }
            }


        val placeholderVariable3: Any = -55
        val moveList = mutableListOf(placeholderVariable3)
        var moveChoiceVar: Any
        var placeholderVariable4: Int

        fun moveLister(x: Int, y: Int) {
            moveList.clear()
            //call after tbvVisit/tbvSquare because checks for TBV squares
            when (x) {
                0 -> when (y) {
                    0 -> {
                        if (square01[0] == SQUARE.TBV) {
                            moveList.add(0.1)
                        }
                        if (square10[0] == SQUARE.TBV) {
                            moveList.add(10)
                        }
                    }

                    1 -> {
                        if (square02[0] == SQUARE.TBV) {
                            moveList.add(0.2)
                        }
                        if (square11[0]==SQUARE.TBV) {
                            moveList.add(11)
                        }
                        if (square00[0]==SQUARE.TBV) {
                            moveList.add(0.0)
                        }
                    }
                    2 -> {
                        if (square03[0]==SQUARE.TBV) {
                            moveList.add(0.3)
                        }
                        if (square12[0]==SQUARE.TBV) {
                            moveList.add(12)
                        }
                        if (square01[0]==SQUARE.TBV) {
                            moveList.add(0.1)
                        }
                    }
                    3 -> {
                        if (square04[0]==SQUARE.TBV) {
                            moveList.add(0.4)
                        }
                        if (square13[0]==SQUARE.TBV) {
                            moveList.add(13)
                        }
                        if (square02[0]==SQUARE.TBV) {
                            moveList.add(0.2)
                        }
                    }
                    4 -> {
                        if (square14[0]==SQUARE.TBV) {
                            moveList.add(14)
                        }
                        if (square03[0]==SQUARE.TBV) {
                            moveList.add(0.3)
                        }
                    }
                }

                1 -> when (y) {
                    0 -> {
                        if (square11[0]==SQUARE.TBV) {
                            moveList.add(11)
                        }
                        if (square00[0]==SQUARE.TBV) {
                            moveList.add(0.0)
                        }
                        if (square20[0]==SQUARE.TBV) {
                            moveList.add(20)
                        }
                    }
                    1 -> {
                        if (square12[0] == SQUARE.TBV) {
                            moveList.add(12)
                        }
                        if (square21[0] == SQUARE.TBV) {
                            moveList.add(21)
                        }
                        if (square10[0] == SQUARE.TBV) {
                            moveList.add(10)
                        }
                        if (square01[0] == SQUARE.TBV) {
                            moveList.add(0.1)
                        }
                    }

                    2 -> {
                        if (square13[0] == SQUARE.TBV) {
                            moveList.add(13)
                        }
                        if (square11[0] == SQUARE.TBV) {
                            moveList.add(11)
                        }
                        if (square22[0] == SQUARE.TBV) {
                            moveList.add(22)
                        }
                        if (square02[0] == SQUARE.TBV) {
                            moveList.add(0.2)
                        }
                    }

                    3 -> {
                        if (square14[0] == SQUARE.TBV) {
                            moveList.add(14)
                        }
                        if (square12[0] == SQUARE.TBV) {
                            moveList.add(12)
                        }
                        if (square23[0] == SQUARE.TBV) {
                            moveList.add(23)
                        }
                        if (square03[0] == SQUARE.TBV) {
                            moveList.add(0.3)
                        }
                    }

                    4 -> {
                        if (square13[0]==SQUARE.TBV) {
                            moveList.add(13)
                        }
                        if (square04[0]==SQUARE.TBV) {
                            moveList.add(0.4)
                        }
                        if (square24[0]==SQUARE.TBV) {
                            moveList.add(24)
                        }
                    }
                }

                2 -> when (y) {
                    0 -> {
                        if (square21[0]==SQUARE.TBV) {
                            moveList.add(21)
                        }
                        if (square30[0]==SQUARE.TBV) {
                            moveList.add(30)
                        }
                        if (square10[0]==SQUARE.TBV) {
                            moveList.add(10)
                        }
                    }
                    1 -> {
                        if (square22[0] == SQUARE.TBV) {
                            moveList.add(22)
                        }
                        if (square31[0] == SQUARE.TBV) {
                            moveList.add(31)
                        }
                        if (square20[0] == SQUARE.TBV) {
                            moveList.add(20)
                        }
                        if (square11[0] == SQUARE.TBV) {
                            moveList.add(11)
                        }
                    }

                    2 -> {
                        if (square23[0] == SQUARE.TBV) {
                            moveList.add(23)
                        }
                        if (square21[0] == SQUARE.TBV) {
                            moveList.add(21)
                        }
                        if (square32[0] == SQUARE.TBV) {
                            moveList.add(32)
                        }
                        if (square12[0] == SQUARE.TBV) {
                            moveList.add(12)
                        }
                    }

                    3 -> {
                        if (square24[0] == SQUARE.TBV) {
                            moveList.add(24)
                        }
                        if (square22[0] == SQUARE.TBV) {
                            moveList.add(22)
                        }
                        if (square33[0] == SQUARE.TBV) {
                            moveList.add(33)
                        }
                        if (square13[0] == SQUARE.TBV) {
                            moveList.add(13)
                        }
                    }

                    4 -> {
                        if (square14[0]==SQUARE.TBV) {
                            moveList.add(14)
                        }
                        if (square23[0]==SQUARE.TBV) {
                            moveList.add(23)
                        }
                        if (square34[0]==SQUARE.TBV) {
                            moveList.add(34)
                        }
                    }
                }

                3 -> when (y) {
                    0 -> {
                        if (square31[0]==SQUARE.TBV) {
                            moveList.add(31)
                        }
                        if (square20[0]==SQUARE.TBV) {
                            moveList.add(20)
                        }
                        if (square40[0]==SQUARE.TBV) {
                            moveList.add(40)
                        }
                    }
                    1 -> {
                        if (square32[0] == SQUARE.TBV) {
                            moveList.add(32)
                        }
                        if (square41[0] == SQUARE.TBV) {
                            moveList.add(41)
                        }
                        if (square30[0] == SQUARE.TBV) {
                            moveList.add(30)
                        }
                        if (square21[0] == SQUARE.TBV) {
                            moveList.add(21)
                        }
                    }

                    2 -> {
                        if (square33[0] == SQUARE.TBV) {
                            moveList.add(33)
                        }
                        if (square31[0] == SQUARE.TBV) {
                            moveList.add(31)
                        }
                        if (square42[0] == SQUARE.TBV) {
                            moveList.add(42)
                        }
                        if (square22[0] == SQUARE.TBV) {
                            moveList.add(22)
                        }
                    }

                    3 -> {
                        if (square34[0] == SQUARE.TBV) {
                            moveList.add(34)
                        }
                        if (square32[0] == SQUARE.TBV) {
                            moveList.add(32)
                        }
                        if (square43[0] == SQUARE.TBV) {
                            moveList.add(43)
                        }
                        if (square23[0] == SQUARE.TBV) {
                            moveList.add(23)
                        }
                    }

                    4 -> {
                        if (square24[0]==SQUARE.TBV) {
                            moveList.add(24)
                        }
                        if (square44[0]==SQUARE.TBV) {
                            moveList.add(44)
                        }
                        if (square33[0]==SQUARE.TBV) {
                            moveList.add(33)
                        }
                    }
                }

                4 -> when (y) {
                    0 -> {
                        if (square41[0]==SQUARE.TBV) {
                            moveList.add(41)
                        }
                        if (square30[0]==SQUARE.TBV) {
                            moveList.add(30)
                        }
                    }
                    1 -> {
                        if (square40[0]==SQUARE.TBV) {
                            moveList.add(40)
                        }
                        if (square31[0]==SQUARE.TBV) {
                            moveList.add(31)
                        }
                        if (square42[0]==SQUARE.TBV) {
                            moveList.add(42)
                        }
                    }
                    2 -> {
                        if (square41[0]==SQUARE.TBV) {
                            moveList.add(41)
                        }
                        if (square43[0]==SQUARE.TBV) {
                            moveList.add(43)
                        }
                        if (square32[0]==SQUARE.TBV) {
                            moveList.add(32)
                        }
                    }
                    3 -> {
                        if (square44[0]==SQUARE.TBV) {
                            moveList.add(44)
                        }
                        if (square42[0]==SQUARE.TBV) {
                            moveList.add(42)
                        }
                        if (square33[0]==SQUARE.TBV) {
                            moveList.add(33)
                        }
                    }
                    4 -> {
                        if (square43[0]==SQUARE.TBV) {
                            moveList.add(43)
                        }
                        if (square34[0]==SQUARE.TBV) {
                            moveList.add(34)
                        }
                    }
                }
            }
        }
        fun moveChoice(): Any {
            placeholderVariable4 = moveList.size
            if(placeholderVariable4>=1) {
                val choice = Random.nextInt(0, placeholderVariable4 - 0)
                for (j in 0..placeholderVariable4) {
                    if (choice == j) {
                        return moveList[j]
                    }
                }
            }
            return "Bad error"
        }
        fun move(x: Any) {
            when (x) {
                0.0 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 0
                }

                0.1 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 1
                }

                0.2 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 2
                }

                0.3 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 3
                }

                0.4 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 4
                }

                10 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 0
                }

                11 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 1
                }

                12 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 2
                }

                13 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 3
                }

                14 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 4
                }

                20 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 0
                }

                21 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 1
                }

                22 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 2
                }

                23 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 3
                }

                24 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 4
                }

                30 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 0
                }

                31 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 1
                }

                32 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 2
                }

                33 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 3
                }

                34 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 4
                }

                40 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 0
                }

                41 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 1
                }

                42 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 2
                }

                43 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 3
                }

                44 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 4
                }
            }
        }


        val placeholderVariable: Any = -55
        val teleportList = mutableListOf(placeholderVariable)
        var tpChoiceVar: Any
        var placeholderVariable2: Int

        fun teleportLister() {
            teleportList.clear()
            if (square00[0] == SQUARE.TBV) {
                teleportList.add(0.0)
            }
            if (square01[0] == SQUARE.TBV) {
                teleportList.add(0.1)
            }
            if (square02[0] == SQUARE.TBV) {
                teleportList.add(0.2)
            }
            if (square03[0] == SQUARE.TBV) {
                teleportList.add(0.3)
            }
            if (square04[0] == SQUARE.TBV) {
                teleportList.add(0.4)
            }
            //
            if (square10[0] == SQUARE.TBV) {
                teleportList.add(10)
            }
            if (square11[0] == SQUARE.TBV) {
                teleportList.add(11)
            }
            if (square12[0] == SQUARE.TBV) {
                teleportList.add(12)
            }
            if (square13[0] == SQUARE.TBV) {
                teleportList.add(13)
            }
            if (square14[0] == SQUARE.TBV) {
                teleportList.add(14)
            }
            //
            if (square20[0] == SQUARE.TBV) {
                teleportList.add(20)
            }
            if (square21[0] == SQUARE.TBV) {
                teleportList.add(21)
            }
            if (square22[0] == SQUARE.TBV) {
                teleportList.add(22)
            }
            if (square23[0] == SQUARE.TBV) {
                teleportList.add(23)
            }
            if (square24[0] == SQUARE.TBV) {
                teleportList.add(24)
            }
            //
            if (square30[0] == SQUARE.TBV) {
                teleportList.add(30)
            }
            if (square31[0] == SQUARE.TBV) {
                teleportList.add(31)
            }
            if (square32[0] == SQUARE.TBV) {
                teleportList.add(32)
            }
            if (square33[0] == SQUARE.TBV) {
                teleportList.add(33)
            }
            if (square34[0] == SQUARE.TBV) {
                teleportList.add(34)
            }
            //
            if (square40[0] == SQUARE.TBV) {
                teleportList.add(40)
            }
            if (square41[0] == SQUARE.TBV) {
                teleportList.add(41)
            }
            if (square42[0] == SQUARE.TBV) {
                teleportList.add(42)
            }
            if (square43[0] == SQUARE.TBV) {
                teleportList.add(43)
            }
            if (square44[0] == SQUARE.TBV) {
                teleportList.add(44)
            }
        }
        fun teleportChoice(): Any {
            placeholderVariable2 = teleportList.size
            if(placeholderVariable2>1) {
                val choice = Random.nextInt(0, placeholderVariable2 - 0)
                for (i in 0..placeholderVariable2) {
                    if (choice == i) {
                        return teleportList[i]
                    }
                }
            }
            return "Bad error"
        }
        fun teleport(x: Any) {
            when (x) {
                0.0 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 0
                }

                0.1 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 1
                }

                0.2 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 2
                }

                0.3 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 3
                }

                0.4 -> {
                    pointerPosition[0] = 0
                    pointerPosition[1]= 4
                }

                10 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 0
                }

                11 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 1
                }

                12 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 2
                }

                13 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 3
                }

                14 -> {
                    pointerPosition[0] = 1
                    pointerPosition[1]= 4
                }

                20 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 0
                }

                21 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 1
                }

                22 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 2
                }

                23 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 3
                }

                24 -> {
                    pointerPosition[0] = 2
                    pointerPosition[1]= 4
                }

                30 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 0
                }

                31 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 1
                }

                32 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 2
                }

                33 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 3
                }

                34 -> {
                    pointerPosition[0] = 3
                    pointerPosition[1]= 4
                }

                40 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 0
                }

                41 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 1
                }

                42 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 2
                }

                43 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 3
                }

                44 -> {
                    pointerPosition[0] = 4
                    pointerPosition[1]= 4
                }
            }
        }


        fun verticalWall(px: Int, py: Int, x:Int, y:Int) {
            when (px) {
                0 -> when (py) {
                    0 -> {
                        if (w17==WALL.NA) {
                            w17=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w36=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w13==WALL.NA) {
                            w13=WALL.TRUE
 wallCount++
                        }
                        if (y==py+1) {
                            w31=WALL.FALSE
                        }
                        if (y==py-1) {
                            w36=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w9==WALL.NA) {
                            w9=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w26=WALL.FALSE
                        }
                        if (y==py-1) {
                            w31=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w5==WALL.NA) {
                            w5=WALL.TRUE
wallCount++
                        }
                        if (y==py+1) {
                            w21=WALL.FALSE
                        }
                        if (y==py-1) {
                            w26=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w1==WALL.NA) {
                            w1=WALL.TRUE
                            wallCount++
                        }
                        if (y==py-1) {
                            w21=WALL.FALSE
                        }
                    }
                }

                1 -> when (py) {
                    0 -> {
                        if (w17==WALL.NA) {
                            w17=WALL.TRUE
 wallCount++
                        }
                        if (w18==WALL.NA) {
                            w18=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w37=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w13==WALL.NA) {
                            w13=WALL.TRUE
                            wallCount++
                        }
                        if (w14==WALL.NA) {
                            w14=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w32=WALL.FALSE
                        }
                        if (y==py-1) {
                            w37=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w9==WALL.NA) {
                            w9=WALL.TRUE
                    wallCount++
                        }
                        if (w10==WALL.NA) {
                            w10=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w27=WALL.FALSE
                        }
                        if (y==py-1) {
                            w32=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w5==WALL.NA) {
                            w5=WALL.TRUE
                    wallCount++
                        }
                        if (w6==WALL.NA) {
                            w6=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w22=WALL.FALSE
                        }
                        if (y==py-1) {
                            w27=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w1==WALL.NA) {
                            w1=WALL.TRUE
                            wallCount++
                        }
                        if (w2==WALL.NA) {
                            w2=WALL.TRUE
                        wallCount++
                        }
                        if (y==py-1) {
                            w22=WALL.FALSE
                        }
                    }
                }

                2 -> when (py) {
                    0 -> {
                        if (w18==WALL.NA) {
                            w18=WALL.TRUE
                            wallCount++
                        }
                        if (w19==WALL.NA) {
                            w19=WALL.TRUE
                        wallCount++
                        }
                        if (y==py+1) {
                            w38=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w14==WALL.NA) {
                            w14=WALL.TRUE
                            wallCount++
                        }
                        if (w15==WALL.NA) {
                            w15=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w33=WALL.FALSE
                        }
                        if (y==py-1) {
                            w38=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w10==WALL.NA) {
                            w10=WALL.TRUE
                            wallCount++
                        }
                        if (w11==WALL.NA) {
                            w11=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w28=WALL.FALSE
                        }
                        if (y==py-1) {
                            w33=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w6==WALL.NA) {
                            w6=WALL.TRUE
                            wallCount++
                        }
                        if (w7==WALL.NA) {
                            w7=WALL.TRUE
                        wallCount++
                        }
                        if (y==py+1) {
                            w23=WALL.FALSE
                        }
                        if (y==py-1) {
                            w28=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w2==WALL.NA) {
                            w2=WALL.TRUE
                            wallCount++
                        }
                        if (w3==WALL.NA) {
                            w3=WALL.TRUE
                    wallCount++
                        }
                        if (y==py-1) {
                            w23=WALL.FALSE
                        }
                    }
                }

                3 -> when (py) {
                    0 -> {
                        if (w19==WALL.NA) {
                            w19=WALL.TRUE
                            wallCount++
                        }
                        if (w20==WALL.NA) {
                            w20=WALL.TRUE
                    wallCount++
                        }
                        if (y==py+1) {
                            w39=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w15==WALL.NA) {
                            w15=WALL.TRUE
 wallCount++
                        }
                        if (w16==WALL.NA) {
                            w16=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w34=WALL.FALSE
                        }
                        if (y==py-1) {
                            w39=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w11==WALL.NA) {
                            w11=WALL.TRUE
                            wallCount++
                        }
                        if (w12==WALL.NA) {
                            w12=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w29=WALL.FALSE
                        }
                        if (y==py-1) {
                            w34=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w7==WALL.NA) {
                            w7=WALL.TRUE
                            wallCount++
                        }
                        if (w8==WALL.NA) {
                            w8=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w24=WALL.FALSE
                        }
                        if (y==py-1) {
                            w29=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w3==WALL.NA) {
                            w3=WALL.TRUE
                        wallCount++
                        }
                        if (w4==WALL.NA) {
                            w4=WALL.TRUE
                        wallCount++
                        }
                        if (y==py-1) {
                            w24=WALL.FALSE
                        }
                    }
                }

                4 -> when (py) {
                    0 -> {
                        if (w20==WALL.NA) {
                            w20=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w40=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w16==WALL.NA) {
                            w16=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w35=WALL.FALSE
                        }
                        if (y==py-1) {
                            w40=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w12==WALL.NA) {
                            w12=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w30=WALL.FALSE
                        }
                        if (y==py-1) {
                            w35=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w8==WALL.NA) {
                            w8=WALL.TRUE
                            wallCount++
                        }
                        if (y==py+1) {
                            w25=WALL.FALSE
                        }
                        if (y==py-1) {
                            w30=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w4==WALL.NA) {
                            w4=WALL.TRUE
                            wallCount++
                        }
                        if (y==py-1) {
                            w25=WALL.FALSE
                        }
                    }
                }
            }
        }
        fun horizontalWall(px: Int, py:Int, x:Int, y: Int) {
            when (py) {
                0 -> when (px) {
                    0 -> {
                        if (w36 == WALL.NA) {
                            w36 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w17=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w37 == WALL.NA) {
                            w37 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w18=WALL.FALSE
                        }
                        if (x==px-1) {
                            w17=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w38 == WALL.NA) {
                            w38 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w19=WALL.FALSE
                        }
                        if (x==px-1) {
                            w18=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w39 == WALL.NA) {
                            w39 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w20=WALL.FALSE
                        }
                        if (x==px-1) {
                            w19=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w40 == WALL.NA) {
                            w40 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px-1) {
                            w20=WALL.FALSE
                        }
                    }
                }

                1 -> when (px) {
                    0 -> {
                        if (w31 == WALL.NA) {
                            w31 = WALL.TRUE
 wallCount++
                        }
                        if (w36 == WALL.NA) {
                            w36 = WALL.TRUE
                        wallCount++
                        }
                        if (x==px+1) {
                            w13=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w32 == WALL.NA) {
                            w32 = WALL.TRUE
                            wallCount++
                        }
                        if (w37 == WALL.NA) {
                            w37 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w14=WALL.FALSE
                        }
                        if (x==px-1) {
                            w13=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w33 == WALL.NA) {
                            w33 = WALL.TRUE
                            wallCount++
                        }
                        if (w38 == WALL.NA) {
                            w38 = WALL.TRUE
                        wallCount++
                        }
                        if (x==px+1) {
                            w15=WALL.FALSE
                        }
                        if (x==px-1) {
                            w14=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w34 == WALL.NA) {
                            w34 = WALL.TRUE
                            wallCount++
                        }
                        if (w39 == WALL.NA) {
                            w39 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w16=WALL.FALSE
                        }
                        if (x==px-1) {
                            w15=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w35 == WALL.NA) {
                            w35 = WALL.TRUE
                            wallCount++
                        }
                        if (w40 == WALL.NA) {
                            w40 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px-1) {
                            w16=WALL.FALSE
                        }
                    }
                }

                2 -> when (px) {
                    0 -> {
                        if (w26 == WALL.NA) {
                            w26 = WALL.TRUE
                            wallCount++
                        }
                        if (w31 == WALL.NA) {
                            w31 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w9=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w27 == WALL.NA) {
                            w27 = WALL.TRUE
                            wallCount++
                        }
                        if (w32 == WALL.NA) {
                            w32 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w10=WALL.FALSE
                        }
                        if (x==px-1) {
                            w9=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w28 == WALL.NA) {
                            w28 = WALL.TRUE
                            wallCount++
                        }
                        if (w33 == WALL.NA) {
                            w33 = WALL.TRUE
                        wallCount++
                        }
                        if (x==px+1) {
                            w11=WALL.FALSE
                        }
                        if (x==px-1) {
                            w10=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w29 == WALL.NA) {
                            w29 = WALL.TRUE
                        wallCount++
                        }
                        if (w34 == WALL.NA) {
                            w34 = WALL.TRUE
 wallCount++
                        }
                        if (x==px+1) {
                            w12=WALL.FALSE
                        }
                        if (x==px-1) {
                            w11=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w30 == WALL.NA) {
                            w30 = WALL.TRUE
                            wallCount++
                        }
                        if (w35 == WALL.NA) {
                            w35 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px-1) {
                            w12=WALL.FALSE
                        }
                    }
                }

                3 -> when (px) {
                    0 -> {
                        if (w21 == WALL.NA) {
                            w21 = WALL.TRUE
                            wallCount++
                        }
                        if (w26 == WALL.NA) {
                            w26 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w5=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w22 == WALL.NA) {
                            w22 = WALL.TRUE
                            wallCount++
                        }
                        if (w27 == WALL.NA) {
                            w27 = WALL.TRUE
 wallCount++
                        }
                        if (x==px+1) {
                            w6=WALL.FALSE
                        }
                        if (x==px-1) {
                            w5=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w23 == WALL.NA) {
                            w23 = WALL.TRUE
                            wallCount++
                        }
                        if (w28 == WALL.NA) {
                            w28 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w7=WALL.FALSE
                        }
                        if (x==px-1) {
                            w6=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w24 == WALL.NA) {
                            w24 = WALL.TRUE
                            wallCount++
                        }
                        if (w29 == WALL.NA) {
                            w29 = WALL.TRUE
                        wallCount++
                        }
                        if (x==px+1) {
                            w8=WALL.FALSE
                        }
                        if (x==px-1) {
                            w7=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w25 == WALL.NA) {
                            w25 = WALL.TRUE
                            wallCount++
                        }
                        if (w30 == WALL.NA) {
                            w30 = WALL.TRUE
                        wallCount++
                        }
                        if (x==px-1) {
                            w8=WALL.FALSE
                        }
                    }
                }

                4 -> when (px) {
                    0 -> {
                        if (w21 == WALL.NA) {
                            w21 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w1=WALL.FALSE
                        }
                    }
                    1 -> {
                        if (w22 == WALL.NA) {
                            w22 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w2=WALL.FALSE
                        }
                        if (x==px-1) {
                            w1=WALL.FALSE
                        }
                    }
                    2 -> {
                        if (w23 == WALL.NA) {
                            w23 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w3=WALL.FALSE
                        }
                        if (x==px-1) {
                            w2=WALL.FALSE
                        }
                    }
                    3 -> {
                        if (w24 == WALL.NA) {
                            w24 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px+1) {
                            w4=WALL.FALSE
                        }
                        if (x==px-1) {
                            w3=WALL.FALSE
                        }
                    }
                    4 -> {
                        if (w25 == WALL.NA) {
                            w25 = WALL.TRUE
                            wallCount++
                        }
                        if (x==px-1) {
                            w4=WALL.FALSE
                        }
                    }
                }
            }
        }
        fun teleportWall(px: Int, py: Int,x: Int, y:Int) {
            val placeholder = Random.nextInt(0,2)
            when (placeholder) {
                0 -> verticalWall(px,py,x,y)
                1 -> horizontalWall(px,py,x,y)
            }
        }

        fun moveWall(x: Int, y: Int, px: Int, py: Int) {
            //TODO note: var move is the LAST made move
            var move = WALLDIRECTION.TELEPORT
            //x = current x
            //y = current y
            //px = past x
            //py = past
            if (x!=px) {move = WALLDIRECTION.HORIZONTAL}
            if (y!=py) {move = WALLDIRECTION.VERTICAL}
            if (x!=px&&y!=py) {move = WALLDIRECTION.TELEPORT}
            ///print("Move: "); println(move)

            when (move) {
                WALLDIRECTION.VERTICAL -> verticalWall(px, py, x, y)
                WALLDIRECTION.HORIZONTAL -> horizontalWall(px, py, x, y)
                WALLDIRECTION.TELEPORT -> {
                    ///println("ADMIN: MOVE = TELEPORT")
                    //TODO fix teleportWall
                    //teleportWall(px,py,x,y)
                    teleportCount++
                }
            }

        }

        fun realerWallGenerator() {
            //FINISHED: moveLister [adds possible moves to a list]
            //TODO create walls after teleport
            //TODO square 25
            repeat(24) {
                i++
                ///println(i)
                ///print("Pointer position: ")
                ///println(pointerPosition)
                ///print("Previous pointer position: ")
                ///println(previousPointerPosition)

                //sets current square as SQUARE.VST
                visitSquare(pointerPosition[0], pointerPosition[1])

                //sets touching squares as SQUARE.TBV (ALSO INCLUDES PREVIOUSLY TOUCHING SQUARES)
                tbvSquare(pointerPosition[0], pointerPosition[1])
                teleportLister()

                //sets touching squares as move locations (DOES NOT INCLUDE PREVIOUSLY TOUCHING SQUARES)
                moveLister(pointerPosition[0],pointerPosition[1])
                ///print("Move list: ")
                ///println(moveList)

                previousPointerPosition[0] = pointerPosition[0]
                previousPointerPosition[1] = pointerPosition[1]

                if (moveList.size>=1) {
                    //randomly picks a nearby TBV square to move to
                    moveChoiceVar = moveChoice()
                    ///print("Move Choice Var: ")
                    ///println(moveChoiceVar)
                    move(moveChoiceVar)
                }
                else {
                    //randomly picks a TBV square to teleport to
                    tpChoiceVar = teleportChoice()
                    teleport(tpChoiceVar)
                }
                //generates necessary walls
                if (i>1) {
                    moveWall(pointerPosition[0], pointerPosition[1], previousPointerPosition[0], previousPointerPosition[1])
                }

                ///print("Teleport list: ")
                ///println(teleportList)
                ///println()

            }
            ///println(teleportCount)
            ///println(wallCount)

            //25th square
            /*
            println(i+1)
            teleport(teleportList[0])
            visitSquare(pointerPosition[0], pointerPosition[1])
            print("Pointer position: ")
            println(pointerPosition)
            teleportList.clear()
            print("Teleport list: ")
            println(teleportList)
             */

            if (wallCount==15) {
            }
            else {
                playing = false
            }
        }


        realerWallGenerator()









        fun columnwCheck(x: Int, y: Int, a: Double, b: Double) {
            if (x.toDouble() == a - 0.5 && y.toDouble() == b) {
                wRight = true
            } else if (x.toDouble() == a + 0.5 && y.toDouble() == b) {
                wLeft = true
            }
        }

        fun rowwCheck(x: Int, y: Int, a: Double, b: Double) {
            if (x.toDouble() == a && y.toDouble() == b + 0.5) {
                wDown = true
            } else if (x.toDouble() == a && y.toDouble() == b - 0.5) {
                wUp = true
            }
        }

        fun borderCheck(x: Int, y: Int) {
            when (x) {
                -2 -> wLeft = true
                2 -> wRight = true
            }
            when (y) {
                2 -> wUp = true
                -2 -> wDown = true
            }
        }

        fun realerwCheck(x: Int, y: Int) {
            borderCheck(x, y)
            var placeholderA: Double
            var placeholderB: Double
            if (WALL.TRUE==w1) {
                placeholderA = -1.5
                placeholderB = 2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w2) {
                placeholderA = -0.5
                placeholderB = 2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w3) {
                placeholderA = 0.5
                placeholderB = 2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w4) {
                placeholderA = 1.5
                placeholderB = 2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w5) {
                placeholderA = -1.5
                placeholderB = 1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w6) {
                placeholderA = -0.5
                placeholderB = 1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w7) {
                placeholderA = 0.5
                placeholderB = 1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w8) {
                placeholderA = 1.5
                placeholderB = 1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w9) {
                placeholderA = -1.5
                placeholderB = 0.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w10) {
                placeholderA = -0.5
                placeholderB = 0.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w11) {
                placeholderA = 0.5
                placeholderB = 0.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w12) {
                placeholderA = 1.5
                placeholderB = 0.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w13) {
                placeholderA = -1.5
                placeholderB = -1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w14) {
                placeholderA = -0.5
                placeholderB = -1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w15) {
                placeholderA = 0.5
                placeholderB = -1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w16) {
                placeholderA = 1.5
                placeholderB = -1.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w17) {
                placeholderA = -1.5
                placeholderB = -2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w18) {
                placeholderA = -0.5
                placeholderB = -2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w19) {
                placeholderA = 0.5
                placeholderB = -2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w20) {
                placeholderA = 1.5
                placeholderB = -2.0
                columnwCheck(x, y, placeholderA, placeholderB)
            }
            //
            if (WALL.TRUE==w21) {
                placeholderA = -2.0
                placeholderB = 1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w22) {
                placeholderA = -1.0
                placeholderB = 1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w23) {
                placeholderA = 0.0
                placeholderB = 1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w24) {
                placeholderA = 1.0
                placeholderB = 1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w25) {
                placeholderA = 2.0
                placeholderB = 1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w26) {
                placeholderA = -2.0
                placeholderB = 0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w27) {
                placeholderA = -1.0
                placeholderB = 0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w28) {
                placeholderA = 0.0
                placeholderB = 0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w29) {
                placeholderA = 1.0
                placeholderB = 0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w30) {
                placeholderA = 2.0
                placeholderB = 0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w31) {
                placeholderA = -2.0
                placeholderB = -0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w32) {
                placeholderA = -1.0
                placeholderB = -0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w33) {
                placeholderA = 0.0
                placeholderB = -0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w34) {
                placeholderA = 1.0
                placeholderB = -0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w35) {
                placeholderA = 2.0
                placeholderB = -0.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w36) {
                placeholderA = -2.0
                placeholderB = -1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w37) {
                placeholderA = -1.0
                placeholderB = -1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w38) {
                placeholderA = 0.0
                placeholderB = -1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w39) {
                placeholderA = 1.0
                placeholderB = -1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
            if (WALL.TRUE==w40) {
                placeholderA = 2.0
                placeholderB = -1.5
                rowwCheck(x, y, placeholderA, placeholderB)
            }
        }

        fun poopy() {
            val pointerPosition = mutableListOf(-2, 2)
            fun wallLeft(x: Int, y: Int) {
                when (x) {
                    -1 -> when (y) {
                        -2 -> w17 = WALL.TRUE
                        -1 -> w13 = WALL.TRUE
                        0 -> w9 = WALL.TRUE
                        1 -> w5 = WALL.TRUE
                        2 -> w1 = WALL.TRUE
                    }

                    0 -> when (y) {
                        -2 -> w18 = WALL.TRUE
                        -1 -> w14 = WALL.TRUE
                        0 -> w10 = WALL.TRUE
                        1 -> w6 = WALL.TRUE
                        2 -> w2 = WALL.TRUE
                    }

                    1 -> when (y) {
                        -2 -> w19 = WALL.TRUE
                        -1 -> w15 = WALL.TRUE
                        0 -> w11 = WALL.TRUE
                        1 -> w7 = WALL.TRUE
                        2 -> w3 = WALL.TRUE
                    }

                    2 -> when (y) {
                        -2 -> w20 = WALL.TRUE
                        -1 -> w16 = WALL.TRUE
                        0 -> w12 = WALL.TRUE
                        1 -> w8 = WALL.TRUE
                        2 -> w4 = WALL.TRUE
                    }
                }
            }

            fun wallRight(x: Int, y: Int) {
                when (x) {
                    -2 -> when (y) {
                        -2 -> w17 = WALL.TRUE
                        -1 -> w13 = WALL.TRUE
                        0 -> w9 = WALL.TRUE
                        1 -> w5 = WALL.TRUE
                        2 -> w1 = WALL.TRUE
                    }

                    -1 -> when (y) {
                        -2 -> w18 = WALL.TRUE
                        -1 -> w14 = WALL.TRUE
                        0 -> w10 = WALL.TRUE
                        1 -> w6 = WALL.TRUE
                        2 -> w2 = WALL.TRUE
                    }

                    0 -> when (y) {
                        -2 -> w19 = WALL.TRUE
                        -1 -> w15 = WALL.TRUE
                        0 -> w11 = WALL.TRUE
                        1 -> w7 = WALL.TRUE
                        2 -> w3 = WALL.TRUE
                    }

                    1 -> when (y) {
                        -2 -> w20 = WALL.TRUE
                        -1 -> w16 = WALL.TRUE
                        0 -> w12 = WALL.TRUE
                        1 -> w8 = WALL.TRUE
                        2 -> w4 = WALL.TRUE
                    }
                }
            }

            fun wallUp(x: Int, y: Int) {
                when (y) {
                    -2 -> when (x) {
                        -2 -> w36 = WALL.TRUE
                        -1 -> w37 = WALL.TRUE
                        0 -> w38 = WALL.TRUE
                        1 -> w39 = WALL.TRUE
                        2 -> w40 = WALL.TRUE
                    }

                    -1 -> when (x) {
                        -2 -> w31 = WALL.TRUE
                        -1 -> w32 = WALL.TRUE
                        0 -> w33 = WALL.TRUE
                        1 -> w34 = WALL.TRUE
                        2 -> w35 = WALL.TRUE
                    }

                    0 -> when (x) {
                        -2 -> w26 = WALL.TRUE
                        -1 -> w27 = WALL.TRUE
                        0 -> w28 = WALL.TRUE
                        1 -> w29 = WALL.TRUE
                        2 -> w30 = WALL.TRUE
                    }

                    1 -> when (x) {
                        -2 -> w21 = WALL.TRUE
                        -1 -> w22 = WALL.TRUE
                        0 -> w23 = WALL.TRUE
                        1 -> w24 = WALL.TRUE
                        2 -> w25 = WALL.TRUE
                    }
                }
            }

            fun wallDown(x: Int, y: Int) {
                when (y) {
                    -1 -> when (x) {
                        -2 -> w36 = WALL.TRUE
                        -1 -> w37 = WALL.TRUE
                        0 -> w38 = WALL.TRUE
                        1 -> w39 = WALL.TRUE
                        2 -> w40 = WALL.TRUE
                    }

                    0 -> when (x) {
                        -2 -> w31 = WALL.TRUE
                        -1 -> w32 = WALL.TRUE
                        0 -> w33 = WALL.TRUE
                        1 -> w34 = WALL.TRUE
                        2 -> w35 = WALL.TRUE
                    }

                    1 -> when (x) {
                        -2 -> w26 = WALL.TRUE
                        -1 -> w27 = WALL.TRUE
                        0 -> w28 = WALL.TRUE
                        1 -> w29 = WALL.TRUE
                        2 -> w30 = WALL.TRUE
                    }

                    2 -> when (x) {
                        -2 -> w21 = WALL.TRUE
                        -1 -> w22 = WALL.TRUE
                        0 -> w23 = WALL.TRUE
                        1 -> w24 = WALL.TRUE
                        2 -> w25 = WALL.TRUE
                    }
                }
            }

            fun delLeft(x: Int, y: Int) {
                when (x) {
                    -1 -> when (y) {
                        -2 -> w17 = WALL.FALSE
                        -1 -> w13 = WALL.FALSE
                        0 -> w9 = WALL.FALSE
                        1 -> w5 = WALL.FALSE
                        2 -> w1 = WALL.FALSE
                    }

                    0 -> when (y) {
                        -2 -> w18 = WALL.FALSE
                        -1 -> w14 = WALL.FALSE
                        0 -> w10 = WALL.FALSE
                        1 -> w6 = WALL.FALSE
                        2 -> w2 = WALL.FALSE
                    }

                    1 -> when (y) {
                        -2 -> w19 = WALL.FALSE
                        -1 -> w15 = WALL.FALSE
                        0 -> w11 = WALL.FALSE
                        1 -> w7 = WALL.FALSE
                        2 -> w3 = WALL.FALSE
                    }

                    2 -> when (y) {
                        -2 -> w20 = WALL.FALSE
                        -1 -> w16 = WALL.FALSE
                        0 -> w12 = WALL.FALSE
                        1 -> w8 = WALL.FALSE
                        2 -> w4 = WALL.FALSE
                    }
                }
            }

            fun delRight(x: Int, y: Int) {
                when (x) {
                    -2 -> when (y) {
                        -2 -> w17 = WALL.FALSE
                        -1 -> w13 = WALL.FALSE
                        0 -> w9 = WALL.FALSE
                        1 -> w5 = WALL.FALSE
                        2 -> w1 = WALL.FALSE
                    }

                    -1 -> when (y) {
                        -2 -> w18 = WALL.FALSE
                        -1 -> w14 = WALL.FALSE
                        0 -> w10 = WALL.FALSE
                        1 -> w6 = WALL.FALSE
                        2 -> w2 = WALL.FALSE
                    }

                    0 -> when (y) {
                        -2 -> w19 = WALL.FALSE
                        -1 -> w15 = WALL.FALSE
                        0 -> w11 = WALL.FALSE
                        1 -> w7 = WALL.FALSE
                        2 -> w3 = WALL.FALSE
                    }

                    1 -> when (y) {
                        -2 -> w20 = WALL.FALSE
                        -1 -> w16 = WALL.FALSE
                        0 -> w12 = WALL.FALSE
                        1 -> w8 = WALL.FALSE
                        2 -> w4 = WALL.FALSE
                    }
                }
            }

            fun delUp(x: Int, y: Int) {
                when (y) {
                    -2 -> when (x) {
                        -2 -> w36 = WALL.FALSE
                        -1 -> w37 = WALL.FALSE
                        0 -> w38 = WALL.FALSE
                        1 -> w39 = WALL.FALSE
                        2 -> w40 = WALL.FALSE
                    }

                    -1 -> when (x) {
                        -2 -> w31 = WALL.FALSE
                        -1 -> w32 = WALL.FALSE
                        0 -> w33 = WALL.FALSE
                        1 -> w34 = WALL.FALSE
                        2 -> w35 = WALL.FALSE
                    }

                    0 -> when (x) {
                        -2 -> w26 = WALL.FALSE
                        -1 -> w27 = WALL.FALSE
                        0 -> w28 = WALL.FALSE
                        1 -> w29 = WALL.FALSE
                        2 -> w30 = WALL.FALSE
                    }

                    1 -> when (x) {
                        -2 -> w21 = WALL.FALSE
                        -1 -> w22 = WALL.FALSE
                        0 -> w23 = WALL.FALSE
                        1 -> w24 = WALL.FALSE
                        2 -> w25 = WALL.FALSE
                    }
                }
            }

            fun delDown(x: Int, y: Int) {
                when (y) {
                    -1 -> when (x) {
                        -2 -> w36 = WALL.FALSE
                        -1 -> w37 = WALL.FALSE
                        0 -> w38 = WALL.FALSE
                        1 -> w39 = WALL.FALSE
                        2 -> w40 = WALL.FALSE
                    }

                    0 -> when (x) {
                        -2 -> w31 = WALL.FALSE
                        -1 -> w32 = WALL.FALSE
                        0 -> w33 = WALL.FALSE
                        1 -> w34 = WALL.FALSE
                        2 -> w35 = WALL.FALSE
                    }

                    1 -> when (x) {
                        -2 -> w26 = WALL.FALSE
                        -1 -> w27 = WALL.FALSE
                        0 -> w28 = WALL.FALSE
                        1 -> w29 = WALL.FALSE
                        2 -> w30 = WALL.FALSE
                    }

                    2 -> when (x) {
                        -2 -> w21 = WALL.FALSE
                        -1 -> w22 = WALL.FALSE
                        0 -> w23 = WALL.FALSE
                        1 -> w24 = WALL.FALSE
                        2 -> w25 = WALL.FALSE
                    }
                }
            }

            var moveOn = false
            var goodMoveCount = 0
            //TODO IN POOPY!!!!!!!!! IGNORE YELLOW TRIANGLE!!!!!!!!
            while (moveOn) {
                //TODO IN POOPY!!!!!!!!! IGNORE YELLOW TRIANGLE!!!!!!!!
                val options =
                    mutableListOf(MOVEOPTIONS.UPMOVE, MOVEOPTIONS.DOWNMOVE, MOVEOPTIONS.LEFTMOVE, MOVEOPTIONS.RIGHTMOVE)
                wLeft = false
                wRight = false
                wUp = false
                wDown = false
                var goodMove = false
                realerwCheck(pointerPosition[0], pointerPosition[1])
                val pointerMove = options.random()
                when (pointerMove) {
                    MOVEOPTIONS.UPMOVE -> if (!wUp) {goodMove = true}
                    MOVEOPTIONS.DOWNMOVE -> if (!wDown) {goodMove = true}
                    MOVEOPTIONS.LEFTMOVE -> if (!wLeft) {goodMove = true}
                    MOVEOPTIONS.RIGHTMOVE -> if (!wRight) {goodMove = true}
                    else -> println("Error: pointerMove set to TELEPORT")
                }
                if (goodMove) {
                    goodMoveCount++
                    var sillyHaha = 0
                    when (pointerMove) {
                        MOVEOPTIONS.UPMOVE -> {
                            wallLeft(pointerPosition[0], pointerPosition[1])
                            wallRight(pointerPosition[0], pointerPosition[1])
                            delUp(pointerPosition[0], pointerPosition[1])
                        }

                        MOVEOPTIONS.DOWNMOVE -> {
                            wallLeft(pointerPosition[0], pointerPosition[1])
                            wallRight(pointerPosition[0], pointerPosition[1])
                            delDown(pointerPosition[0], pointerPosition[1])
                        }

                        MOVEOPTIONS.LEFTMOVE -> {
                            wallUp(pointerPosition[0], pointerPosition[1])
                            wallDown(pointerPosition[0], pointerPosition[1])
                            delLeft(pointerPosition[0], pointerPosition[1])
                        }

                        MOVEOPTIONS.RIGHTMOVE -> {
                            wallUp(pointerPosition[0], pointerPosition[1])
                            wallDown(pointerPosition[0], pointerPosition[1])
                            delRight(pointerPosition[0], pointerPosition[1])
                        }
                        else -> println("Error: pointerMove set to TELEPORT")
                    }
                    when (pointerMove) {
                        MOVEOPTIONS.UPMOVE -> {
                            pointerPosition[1] = pointerPosition[1] + 1
                            sillyHaha++
                        }
                        MOVEOPTIONS.DOWNMOVE -> {
                            pointerPosition[1] = pointerPosition[1] - 1
                            sillyHaha++
                        }
                        MOVEOPTIONS.LEFTMOVE -> {
                            pointerPosition[0] = pointerPosition[0] - 1
                            sillyHaha++
                        }
                        MOVEOPTIONS.RIGHTMOVE -> {
                            pointerPosition[0] = pointerPosition[0] + 1
                            sillyHaha++
                        }
                        else -> println("Error: pointerMove set to TELEPORT")
                    }
                    if (goodMoveCount>=30) {moveOn=true}
                }
            }
        }

        fun adminWallMap() {
            println("ADMIN WALL MAP")
            println(" _ _ _ _ _ ")
            print("|")
            if (WALL.TRUE==w21) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w1) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w22) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w2) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w23) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w3) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w24) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w4) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w25) {
                print("_")
            } else print(" ")
            println("|")
            //
            print("|")
            if (WALL.TRUE==w26) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w5) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w27) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w6) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w28) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w7) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w29) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w8) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w30) {
                print("_")
            } else print(" ")
            println("|")
            //
            print("|")
            if (WALL.TRUE==w31) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w9) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w32) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w10) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w33) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w11) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w34) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w12) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w35) {
                print("_")
            } else print(" ")
            println("|")
            //
            print("|")
            if (WALL.TRUE==w36) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w13) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w37) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w14) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w38) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w15) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w39) {
                print("_")
            } else print(" ")
            if (WALL.TRUE==w16) {
                print("|")
            } else print(" ")
            if (WALL.TRUE==w40) {
                print("_")
            } else print(" ")
            println("|")
            //
            print("|_")
            if (WALL.TRUE==w17) {
                print("|")
            } else print(" ")
            print("_")
            if (WALL.TRUE==w18) {
                print("|")
            } else print(" ")
            print("_")
            if (WALL.TRUE==w19) {
                print("|")
            } else print(" ")
            print("_")
            if (WALL.TRUE==w20) {
                print("|")
            } else print(" ")
            println("_|")
        }

        fun adminPrintTrueWalls() {
            println("ADMIN: PRINT TRUE WALLS")
            if (WALL.TRUE==w1) {
                println("w1")
            }
            if (WALL.TRUE==w2) {
                println("w2")
            }
            if (WALL.TRUE==w3) {
                println("w3")
            }
            if (WALL.TRUE==w4) {
                println("w4")
            }
            if (WALL.TRUE==w5) {
                println("w5")
            }
            if (WALL.TRUE==w6) {
                println("w6")
            }
            if (WALL.TRUE==w7) {
                println("w7")
            }
            if (WALL.TRUE==w8) {
                println("w8")
            }
            if (WALL.TRUE==w9) {
                println("w9")
            }
            if (WALL.TRUE==w10) {
                println("w10")
            }
            if (WALL.TRUE==w11) {
                println("w11")
            }
            if (WALL.TRUE==w12) {
                println("w12")
            }
            if (WALL.TRUE==w13) {
                println("w13")
            }
            if (WALL.TRUE==w14) {
                println("w14")
            }
            if (WALL.TRUE==w15) {
                println("w15")
            }
            if (WALL.TRUE==w16) {
                println("w16")
            }
            if (WALL.TRUE==w17) {
                println("w17")
            }
            if (WALL.TRUE==w18) {
                println("w18")
            }
            if (WALL.TRUE==w19) {
                println("w19")
            }
            if (WALL.TRUE==w20) {
                println("w20")
            }
            println("halfway")
            if (WALL.TRUE==w21) {
                println("w21")
            }
            if (WALL.TRUE==w22) {
                println("w22")
            }
            if (WALL.TRUE==w23) {
                println("w23")
            }
            if (WALL.TRUE==w24) {
                println("w24")
            }
            if (WALL.TRUE==w25) {
                println("w25")
            }
            if (WALL.TRUE==w26) {
                println("w26")
            }
            if (WALL.TRUE==w27) {
                println("w27")
            }
            if (WALL.TRUE==w28) {
                println("w28")
            }
            if (WALL.TRUE==w29) {
                println("w29")
            }
            if (WALL.TRUE==w30) {
                println("w30")
            }
            if (WALL.TRUE==w31) {
                println("w31")
            }
            if (WALL.TRUE==w32) {
                println("w32")
            }
            if (WALL.TRUE==w33) {
                println("w33")
            }
            if (WALL.TRUE==w34) {
                println("w34")
            }
            if (WALL.TRUE==w35) {
                println("w35")
            }
            if (WALL.TRUE==w36) {
                println("w36")
            }
            if (WALL.TRUE==w37) {
                println("w37")
            }
            if (WALL.TRUE==w38) {
                println("w38")
            }
            if (WALL.TRUE==w39) {
                println("w39")
            }
            if (WALL.TRUE==w40) {
                println("w40")
            }
        }

        fun finishDistance(): Int {
            val placeholder = abs(position[0]-finishPosition[0])+abs(position[1]-finishPosition[1])
            print("\nThe finish seems to be ")
            print(placeholder)
            println(" squares away.")
            return placeholder
        }

        if (playing) {
            println("Enter \"w\", \"a\", \"s\", or \"d\" to move")
            println("If you\'d like to give up, enter \"quit\".")
            //println("Your location: $position")
        }
        while (playing) {
            wUp = false
            wRight = false
            wDown = false
            wLeft = false
            realerwCheck(position[0],position[1])
            val move = readlnOrNull()
            when (move) {
                "a" -> if (!wLeft) {
                    position[0] = position[0] - 1
                } else println("You ran into a wall")

                "d" -> if (!wRight) {
                    position[0] = position[0] + 1
                } else println("You ran into a wall")

                "w" -> if (!wUp) {
                    position[1] = position[1] + 1
                } else println("You ran into a wall")

                "s" -> if (!wDown) {
                    position[1] = position[1] - 1
                } else println("You ran into a wall")

                "quit" -> playing = false
                ///admin commands
                "map" -> adminWallMap()
                "reset" -> playing = false
                "location" -> println(position)
            }
            if (playing) {
                //println("Your location: $position")
                val placeholderVariable5 = finishDistance()
                if (placeholderVariable5==0) {
                    println("You won!\n\n\n\n\n")
                    Thread.sleep(1000)
                    playing = false
                }
            }
        }
    }
}

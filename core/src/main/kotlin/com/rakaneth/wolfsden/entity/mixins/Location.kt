package com.rakaneth.wolfsden.entity.mixins

import squidpony.squidmath.Coord

interface DefaultMover {
    val pos: Coord
    fun rawMove(x: Int, y: Int)



}
package com.rakaneth.wolfsden.entity

import squidpony.squidmath.SquidID

class GameObject(var name: String) {
    val id = SquidID.randomUUID().toString()
    protected var x = 0
    protected var y = 0

    fun rawMove(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}
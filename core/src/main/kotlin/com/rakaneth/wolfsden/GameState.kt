package com.rakaneth.wolfsden

import com.rakaneth.wolfsden.screen.WolfScreen
import squidpony.squidmath.LightRNG

class GameState(private val debug: Boolean,
                val seed: Long? = null) {
    private val screens: MutableMap<String, WolfScreen>  = mutableMapOf()
    val rng = if (seed != null) LightRNG(seed) else LightRNG()
    var curScreen: WolfScreen? = null
    var clock = 0
    fun setScreen(screenName: String) {
        require(screens.containsKey(screenName), {"Screen $screenName does not exist"})
        curScreen?.exit()
        curScreen = screens[screenName]!!
        curScreen?.enter()
    }

    fun registerScreens(vararg _screens: WolfScreen) {
        _screens.forEach {
            screens[it.name] = it
        }
    }

    fun log(tag: String, message: String) {
        if (debug) {
            println("$clock: [$tag]$message")
        }
    }


}
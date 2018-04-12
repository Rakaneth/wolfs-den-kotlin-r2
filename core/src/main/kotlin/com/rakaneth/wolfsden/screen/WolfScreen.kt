package com.rakaneth.wolfsden.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.rakaneth.wolfsden.GameState
import squidpony.squidgrid.gui.gdx.SquidInput

const val cellWidth = 15f
const val cellHeight = 20f
const val fullGridW = 120
const val fullGridH = 40
const val fullPixelW = fullGridW * cellWidth
const val fullPixelH = fullGridH * cellHeight

abstract class WolfScreen(val name: String,
                          protected val batch: SpriteBatch,
                          protected val state: GameState) {
    abstract val stage: Stage
    abstract var input: SquidInput
    abstract val vport: StretchViewport
    abstract fun render()

    open fun enter() {
        state.log("Screen", "Entered $name screen")
    }

    open fun exit() {
        state.log("Screen", "Exited $name screen")
    }

    fun activateInput(stage: Stage, input: InputProcessor) {
        Gdx.input.inputProcessor = InputMultiplexer(stage, input)
    }

}
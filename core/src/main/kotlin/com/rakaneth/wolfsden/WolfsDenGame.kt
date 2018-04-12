package com.rakaneth.wolfsden

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.rakaneth.wolfsden.screen.TestScreen
import squidpony.squidgrid.gui.gdx.SColor

class WolfsDenGame : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private val bgColor = SColor.DARK_SLATE_GRAY
    private val game =  GameState(true, 0xDEADBEEF)

    override fun create() {
        batch = SpriteBatch()
        game.registerScreens(
                TestScreen(batch, game)
        )
        game.setScreen("test")
    }

    override fun render() {
        Gdx.gl.glClearColor(bgColor.r / 255f, bgColor.g / 255f, bgColor.b / 255f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        game.curScreen?.render()
    }

    override fun resize(width: Int, height: Int) {
        game.curScreen?.vport?.update(width, height, false)
    }
}
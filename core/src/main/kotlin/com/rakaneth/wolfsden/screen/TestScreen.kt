package com.rakaneth.wolfsden.screen

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.rakaneth.wolfsden.GameState
import com.rakaneth.wolfsden.setUp
import squidpony.squidgrid.gui.gdx.DefaultResources
import squidpony.squidgrid.gui.gdx.SquidInput
import squidpony.squidgrid.gui.gdx.SquidPanel

class TestScreen(batch: SpriteBatch, gameState: GameState) : WolfScreen("test", batch, gameState) {
    override val vport = StretchViewport(fullPixelW, fullPixelH)
    override val stage = Stage(vport, batch)
    override var input = SquidInput({ key, alt, ctrl, shift ->
        println("Key: $key Alt: $alt Ctrl: $ctrl Shift: $shift")
    })
    private val testPanel = SquidPanel(120, 40,
            DefaultResources.getSlabFamily().setUp(cellWidth, cellHeight, 1.1f, 1.1f))

    init {
        testPanel.setBounds(0f, 0f, fullPixelW, fullPixelH)
        stage.addActor(testPanel)
    }

    override fun render() {
        testPanel.putBorders()
        testPanel.put(1, 1, "Hello Again SquidLib")
        stage.act()
        stage.draw()
    }

}
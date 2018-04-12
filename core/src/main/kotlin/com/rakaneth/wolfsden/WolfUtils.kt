package com.rakaneth.wolfsden

import com.badlogic.gdx.graphics.Color
import squidpony.panel.IColoredString
import squidpony.squidgrid.gui.gdx.GDXMarkup
import squidpony.squidgrid.gui.gdx.TextCellFactory

fun TextCellFactory.setUp(w: Float, h: Float, tw: Float, th: Float) = also {
    it.width(w).height(h).tweakWidth(w * tw).tweakHeight(h * th).initBySize()
}

fun String.toICString(): IColoredString<Color> {
    return GDXMarkup.instance.colorString(this)
}

val fibs = intArrayOf(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946)


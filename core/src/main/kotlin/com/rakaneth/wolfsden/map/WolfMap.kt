package com.rakaneth.wolfsden.map

import com.rakaneth.wolfsden.between
import com.rakaneth.wolfsden.betweenExclusive
import com.rakaneth.wolfsden.colorFloat
import squidpony.ArrayTools
import squidpony.squidgrid.gui.gdx.SColor
import squidpony.squidgrid.mapping.DungeonUtility
import squidpony.squidmath.Coord
import squidpony.squidmath.GreasedRegion
import java.io.Serializable

data class TileData(val walk: Boolean,
                    val see: Boolean,
                    val display: Char,
                    val fg: Float = 0f,
                    val bg: Float = 0f)

val TILES: Map<Char, TileData> = mapOf(
        '#' to TileData(false, false, '#'),
        '.' to TileData(true, true, '.'),
        ':' to TileData(true, true,':'),
        '+' to TileData(false, false, '+', "White".colorFloat(), "Sepia".colorFloat()),
        '/' to TileData(true, true, '\'', "White".colorFloat(), "Sepia".colorFloat()),
        ',' to TileData(true, true, ' ', bg = "Light Blue".colorFloat()),
        '~' to TileData(false, true, ' ', bg = "Blue".colorFloat()),
        'x' to TileData(false, false, 'x')
)

class WolfMap(val id: String,
              val name: String,
              var baseMap: Array<CharArray>,
              var light: Boolean = true): Serializable {
    var displayMap: Array<CharArray> = ArrayTools.fill('#', baseMap.size, baseMap[0].size)
    var resistances: Array<DoubleArray> = DungeonUtility.generateResistances(baseMap)
    var floors: GreasedRegion = GreasedRegion(baseMap, '.')
    private var tempRegion: GreasedRegion = floors.copy()
    var bgFloats: Array<FloatArray> = ArrayTools.fill("Transparent".colorFloat(), baseMap.size, baseMap[0].size)
    var fgFloats: Array<FloatArray> = ArrayTools.fill("Transparent".colorFloat(), baseMap.size, baseMap[0].size)
    val width
        get() = baseMap.size
    val height
        get() = baseMap[0].size

    init {
        for ((x, row) in baseMap.withIndex()) {
            for ((y, c) in row.withIndex()) {
                val tileData = TILES[c]!!
                displayMap[x][y] = tileData.display
                bgFloats[x][y] = tileData.bg
                fgFloats[x][y] = tileData.fg
            }
        }
    }

    fun isIB(x: Int, y: Int): Boolean {
        return x.betweenExclusive(0, width) && y.betweenExclusive(0, height)
    }

    fun isIB(c: Coord): Boolean {
        return isIB(c.x, c.y)
    }

    fun getTile(x: Int, y: Int): Pair<Char, TileData> {
         return if (!isIB(x, y)) {
             'x' to TILES['x']!!
         } else {
             baseMap[x][y] to TILES[baseMap[x][y]]!!
         }
    }

    fun getTile(c: Coord): Pair<Char, TileData> {
        return getTile(c.x, c.y)
    }
}
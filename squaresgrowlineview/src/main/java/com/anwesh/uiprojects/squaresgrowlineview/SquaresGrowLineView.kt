package com.anwesh.uiprojects.squaresgrowlineview

/**
 * Created by anweshmishra on 28/09/19.
 */

import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.view.View
import android.view.MotionEvent

val colors : Array<String> = arrayOf("#673AB7", "#E65100", "#4CAF50", "#f44336", "#0D47A1")
val scGap : Float = 0.05f
val strokeFactor : Float = 90f
val parts : Int = 6
val delay : Long = 40
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

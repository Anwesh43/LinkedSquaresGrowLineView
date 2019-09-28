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

fun Canvas.drawSquare(i : Int, gap : Float, sc : Float, paint : Paint) {
    save()
    translate(gap * 2 * i + 1.5f * gap, 0f)
    drawRect(RectF(-gap / 2, 0f, gap / 2, gap * sc.divideScale(i + 1, parts)), paint)
    restore()
}

fun Canvas.drawLineGrowSquare(w : Float, sc : Float, paint : Paint) {
    val gap : Float = w / 2 * (parts - 2) + 1
    drawLine(0f, 0f, w * sc, 0f, paint)
    for (j in 0..(parts - 3)) {
        drawSquare(j, gap, sc, paint)
    }
}

fun Canvas.drawSGLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val hGap : Float = h / (colors.size + 1)
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(0f, hGap * (i + 1))
    drawLineGrowSquare(w, scale, paint)
    restore()
}

class SquaresGrowLineView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    
    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
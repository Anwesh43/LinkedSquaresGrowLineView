package com.anwesh.uiprojects.linkedsquaresgrowlineview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.squaresgrowlineview.SquaresGrowLineView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SquaresGrowLineView.create(this)
    }
}

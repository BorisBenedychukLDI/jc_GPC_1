package com.citys.jackpotys.com

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

fun MainActivity2wlkzg1e.clickSetup2wlkzq1e (
    uiComponents2wlkzg1e: ( view2wlkzg1e : View ) -> Unit
) {
    findViewById<View>(R.id.v_2wlkzg1e).setOnClickListener {
        uiComponents2wlkzg1e(it)
    }
    findViewById<TextView>(R.id.tv_start_2wlkzg1e).setOnClickListener {
        uiComponents2wlkzg1e(it)
    }
}

fun MainActivity2wlkzg1e.animationBackGround2wlkzg1e () {
    ValueAnimator.ofArgb(resources.getColor(R.color.black_2wlkzg1e), resources.getColor(R.color.theme_2_2wlkzg1e)).run {
        setEvaluator(ArgbEvaluator())
        duration = 5000
        addUpdateListener { findViewById<ConstraintLayout>(R.id.cl_second_2wlkzg1e).setBackgroundColor(it.animatedValue.toString().toInt()) }
        start()
    }
}
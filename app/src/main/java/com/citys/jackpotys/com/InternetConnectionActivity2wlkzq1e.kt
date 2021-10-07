package com.citys.jackpotys.com

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.animation.doOnEnd
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.lifecycleScope
import com.citys.jackpotys.com.Utilities2wlkzq1e.internetChecker2wlkzg1e
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InternetConnectionActivity2wlkzq1e : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_connection_activity2wlkzq1e)
        lifecycleScope.launch {
            delay(500)
            ObjectAnimator.ofFloat(findViewById(R.id.tv_internet_2wlkzg1e), View.ALPHA, 0f, 1f)
                .run {
                    duration = 400
                    start()
                }
            ObjectAnimator.ofFloat(findViewById(R.id.b_internet_2wlkzg1e), View.ALPHA, 0f, 1f)
                .run {
                    duration = 400
                    start()
                }
        }
        findViewById<Button>(R.id.b_internet_2wlkzg1e).setOnClickListener {
            if (internetChecker2wlkzg1e()) {
                ObjectAnimator.ofFloat(findViewById(R.id.tv_internet_2wlkzg1e), View.ALPHA, 1f, 0f)
                    .run {
                        duration = 400
                        start()
                    }
                ObjectAnimator.ofFloat(findViewById(R.id.b_internet_2wlkzg1e), View.ALPHA, 1f, 0f)
                    .run {
                        duration = 400
                        start()
                        doOnEnd {
                            startActivity(
                                Intent(
                                    this@InternetConnectionActivity2wlkzq1e,
                                    WebActivity2wlkzq1e::class.java
                                ),
                                ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    this@InternetConnectionActivity2wlkzq1e,
                                    findViewById(R.id.v_web_2wlkzg1e2),
                                    "view_in"
                                ).toBundle()
                            )
                        }
                    }
            }
        }
    }

    override fun onStop() {
        finish()
        super.onStop()
    }
}
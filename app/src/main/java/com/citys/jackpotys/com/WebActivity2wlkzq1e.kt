package com.citys.jackpotys.com

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.citys.jackpotys.com.Utilities2wlkzq1e.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WebActivity2wlkzq1e : AppCompatActivity() {


    private lateinit var wv2wlkzg1e: WebView
    private lateinit var view2wlkzg1e2: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_activity2wlkzq1e)
        wv2wlkzg1e = findViewById(R.id.wv_2wlkzg1e)
        view2wlkzg1e2 = findViewById(R.id.v_web_2wlkzg1e2)
        setupWebView2wlkzq1e()
        circleCkecker2wlkzq1e()
    }

    override fun onBackPressed() =
        if (wv2wlkzg1e.canGoBack() && wv2wlkzg1e.isFocused) wv2wlkzg1e.goBack() else super.onBackPressed()

    override fun onActivityResult(
        requestCode2wlkzq1e: Int,
        resultCode2wlkzq1e: Int,
        data2wlkzq1e: Intent?
    ) {
        if (filePathCallBack2wlkzq1e != null && requestCode2wlkzq1e == 0) {
            val uriResult2wlkzg1e =
                if (data2wlkzq1e == null || resultCode2wlkzq1e != RESULT_OK) null else data2wlkzq1e.data
            if (uriResult2wlkzg1e != null) {
                filePathCallBack2wlkzq1e?.onReceiveValue(arrayOf(uriResult2wlkzg1e))
            } else {
                filePathCallBack2wlkzq1e?.onReceiveValue(arrayOf(uriView2wlkzq1e))
            }
            filePathCallBack2wlkzq1e = null
        }
        super.onActivityResult(requestCode2wlkzq1e, resultCode2wlkzq1e, data2wlkzq1e)
    }

    private fun splashAnimation2wlkzq1e() {
        findViewById<View>(R.id.v_web_2wlkzg1e2).let { circleWeb2wlkzg1e ->
            AnimatorSet().play(
                ObjectAnimator.ofPropertyValuesHolder(
                    circleWeb2wlkzg1e, PropertyValuesHolder.ofFloat(
                        View.SCALE_X, 1f, 0.5f
                    ), PropertyValuesHolder.ofFloat(
                        View.SCALE_Y, 1f, 0.5f
                    )
                ).apply {
                    duration = 500
                    start()
                }
            ).before(
                ObjectAnimator.ofFloat(circleWeb2wlkzg1e, View.ALPHA, 1f, 0f).apply {
                    duration = 500
                    start()
                }
            ).with(
                ObjectAnimator.ofPropertyValuesHolder(
                    circleWeb2wlkzg1e, PropertyValuesHolder.ofFloat(
                        View.SCALE_X, 1f, 25f
                    ), PropertyValuesHolder.ofFloat(
                        View.SCALE_Y, 1f, 25f
                    )
                ).apply {
                    duration = 500
                    start()
                }
            )

        }
    }

    private fun returnCircle2wlkzq1e() {
        findViewById<View>(R.id.v_web_2wlkzg1e2).run {
            animate().alpha(1f).run { duration = 500 }
            animate().scaleX(1f).run { duration = 500 }
            animate().scaleY(1f).run { duration = 500 }
        }
    }

    private fun WebActivity2wlkzq1e.circleCkecker2wlkzq1e() {
        lifecycleScope.launch {
            delay(500)
            splashAnimation2wlkzq1e()
        }
    }

    private fun setupWebView2wlkzq1e() {
        wv2wlkzg1e = findViewById(R.id.wv_2wlkzg1e)
        wv2wlkzg1e.run {
            settings.run {
                loadWithOverviewMode = true
                displayZoomControls = false
                useWideViewPort = true
                javaScriptEnabled = true
                loadsImagesAutomatically = true
                cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                builtInZoomControls = true
                displayZoomControls = false
                domStorageEnabled = true
                mediaPlaybackRequiresUserGesture = false
            }

            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view2wlkzg1e: WebView?,
                    request2wlkzg1e: WebResourceRequest?
                ): Boolean {
                    if (!internetChecker2wlkzg1e()) {
                        lifecycleScope.launch {
                            visibility = View.INVISIBLE
                            returnCircle2wlkzq1e()
                            delay(500)
                            startActivity(
                                Intent(
                                    this@WebActivity2wlkzq1e,
                                    InternetConnectionActivity2wlkzq1e::class.java
                                ),
                                ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    this@WebActivity2wlkzq1e,
                                    view2wlkzg1e2,
                                    "view_internet"
                                ).toBundle()
                            )
                            finish()
                        }
                    }
                    val prohibitedLinks2wlkzg1e = listOf("instagram", "linkedin")
                    val modifiedLinks2wlkzg1e = listOf("mailto:", "tel:")
                    return when {
                        prohibitedLinks2wlkzg1e.find {
                            request2wlkzg1e?.url.toString().contains(it)
                        } != null -> true
                        modifiedLinks2wlkzg1e.find {
                            request2wlkzg1e
                                ?.url.toString().startsWith(it)
                        } != null -> {
                            view2wlkzg1e?.context?.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    request2wlkzg1e?.url
                                )
                            )
                            true
                        }
                        else -> false
                    }
                }

                override fun onPageFinished(view2wlkzg1e: WebView?, url2wlkzg1e: String?) {
                    getSharedPreferences("SP_2wlkzg1e", MODE_PRIVATE).edit()
                        .putString("Last_Page_2wlkzq1e", url2wlkzg1e ?: return).apply()
                    super.onPageFinished(view2wlkzg1e, url2wlkzg1e)
                }

                override fun onReceivedSslError(
                    view2wlkzg1e: WebView?,
                    handler2wlkzg1e: SslErrorHandler?,
                    error2wlkzg1e: SslError?
                ) {
                    handler2wlkzg1e?.proceed()
                    super.onReceivedSslError(view2wlkzg1e, handler2wlkzg1e, error2wlkzg1e)
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onShowFileChooser(
                    webView2wlkzg1e: WebView?,
                    filePathCallback2wlkzg1es: ValueCallback<Array<Uri>>?,
                    fileChooserParams2wlkzg1e: FileChooserParams?
                ): Boolean {
                    checkPermissions2wlkzq1e()
                    filePathCallBack2wlkzq1e = filePathCallback2wlkzg1es
                    val captureIntent2wlkzg1e = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (captureIntent2wlkzg1e.resolveActivity(packageManager) != null) {
                        val providedFile2wlkzg1e = createTempFile2wlkzq1e()
                        uriView2wlkzq1e = FileProvider.getUriForFile(
                            this@WebActivity2wlkzq1e,
                            "${packageName}.provider",
                            providedFile2wlkzg1e
                        )
                        captureIntent2wlkzg1e.run {
                            putExtra(MediaStore.EXTRA_OUTPUT, uriView2wlkzq1e)
                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        }
                        val actionIntent2wlkzg1e = Intent(Intent.ACTION_GET_CONTENT).apply {
                            addCategory(Intent.CATEGORY_OPENABLE)
                            type = "image/*"
                        }
                        val intentChooser2wlkzg1e = Intent(Intent.ACTION_CHOOSER).apply {
                            putExtra(Intent.EXTRA_INTENT, captureIntent2wlkzg1e)
                            putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(actionIntent2wlkzg1e))
                        }
                        startActivityForResult(intentChooser2wlkzg1e, 0)
                        return true

                    }
                    return super.onShowFileChooser(
                        webView2wlkzg1e,
                        filePathCallback2wlkzg1es,
                        fileChooserParams2wlkzg1e
                    )
                }
            }
            getSharedPreferences("SP_2wlkzg1e", MODE_PRIVATE).getString("Last_Page_2wlkzq1e", null)
                ?.let {
                    loadUrl(it)
                    Log.d("TEST_URL", it)
                    return@run
                }
            loadUrl(parsedURL2wlkzq1e ?: return)

        }

        findViewById<SwipeRefreshLayout>(R.id.srl_2wlkzg1e)?.let {
            it.setOnRefreshListener {
                wv2wlkzg1e.loadUrl(wv2wlkzg1e.url ?: return@setOnRefreshListener)
                it.isRefreshing = false
            }
        }

    }

}
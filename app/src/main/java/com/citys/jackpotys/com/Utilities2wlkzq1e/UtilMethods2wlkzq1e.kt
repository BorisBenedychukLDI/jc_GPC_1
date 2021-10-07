package com.citys.jackpotys.com.Utilities2wlkzq1e

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Environment
import android.util.Base64
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun Context.checkPermissions2wlkzq1e () {
    Dexter.withContext(this)
        .withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
        .withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {

            }
        }).check()
}

fun Context.createTempFile2wlkzq1e (): File {
    val date2wlkzq1e = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        .format(Date())
    val fileDir2wlkzq1e = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile("TMP${date2wlkzq1e}_2wlkzq1e", ".jpg", fileDir2wlkzq1e)
}

fun String.decodeStrings2wlkzg1e () = String(Base64.decode(this, Base64.DEFAULT))

fun Context.internetChecker2wlkzg1e (): Boolean {
    val connectivityManager2wlkzq1e = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val networkCapabilities2wlkzq1e = connectivityManager2wlkzq1e.getNetworkCapabilities(connectivityManager2wlkzq1e.activeNetwork) ?: return false
        return networkCapabilities2wlkzq1e.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    } else {
        for (network2wlkzq1e in connectivityManager2wlkzq1e.allNetworks) {
            connectivityManager2wlkzq1e.getNetworkInfo(network2wlkzq1e)?.let {
                if (it.isConnected) return true
            }
        }
        return false
    }
}
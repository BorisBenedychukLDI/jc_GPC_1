package com.citys.jackpotys.com.Application2wlkzq1e

import android.content.Context
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.citys.jackpotys.com.Utilities2wlkzq1e.*
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun Context.mobileAdsSetup2wlkzq1e () {
    com.google.android.gms.ads.MobileAds.initialize(this)
    CoroutineScope(kotlinx.coroutines.Dispatchers.IO).launch {
        try {
            AID2wlkzq1e =
                com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(this@mobileAdsSetup2wlkzq1e)?.id
        } catch (e2wlkzq1e: Exception) {

        }
    }
}

fun Context.oneSignalSetup2wlkzg1e () {
    OneSignal.initWithContext(this)
    OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    OneSignal.setAppId(CODED_ONESIGNAL_2wlkzq1e.decodeStrings2wlkzg1e())
}

fun Context.appsFlyerSetup2wlkzg1e () {
    val appsFlyerConversion2wlkzq1e = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(dataMap2wlkzq1e: MutableMap<String, Any>?) {
            dataMap2wlkzq1e?.run {

                status2wlkzq1e =
                    if (getValue(APPSFLYER_STATUS_TAG_2wlkzq1e).toString() == "Organic") "Organic" else "Non-organic"

                val paramsArray2wlkzq1e = mutableListOf<String>()
                getValue(APPSFLYER_CAMPAIGN_TAG_2wlkzq1e)
                    .toString()
                    .split("||").drop(1)
                    .map {
                        paramsArray2wlkzq1e.add(it.split(":")[1])
                    }

                key2wlkzq1e = if (paramsArray2wlkzq1e.size >= 1) paramsArray2wlkzq1e[0] else "empty"
                sub22wlkzq1e = if (paramsArray2wlkzq1e.size >= 2) paramsArray2wlkzq1e[1] else "empty"
                sub32wlkzq1e = if (paramsArray2wlkzq1e.size >= 3) paramsArray2wlkzq1e[2] else "empty"


                mediaSource2wlkzq1e = getValue(APPSFLYER_MEDIA_SOURCE_TAG_2wlkzq1e).toString()
                afChannel2wlkzq1e = getValue(APPSFLYER_AF_CHANNEL_TAG_2wlkzq1e).toString()
                adGroup2wlkzq1e = getValue(APPSFLYER_ADGROUP_TAG_2wlkzq1e).toString()
                adSet22wlkzq1e = getValue(APPSFLYER_ADSET_TAG_2wlkzq1e).toString()



            }
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
    AppsFlyerLib.getInstance().run {
        uid2wlkzq1e = getAppsFlyerUID(this@appsFlyerSetup2wlkzg1e)
        init(
            CODE_APPSFLYER_2wlkzq1e.decodeStrings2wlkzg1e(),
            appsFlyerConversion2wlkzq1e,
            this@appsFlyerSetup2wlkzg1e
        )
        start(this@appsFlyerSetup2wlkzg1e)
    }
}
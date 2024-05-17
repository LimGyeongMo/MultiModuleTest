package com.project.widget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.project.daeguromultimodule.MainSplashActivity
import com.project.taxi.TaxiSplashActivity

class DataReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        TODO("Not yet implemented")
        val message = intent?.getStringExtra("deepLink")

        if (intent != null) {
            if (intent.action == "com.project.taxi") {
                val taxiIntent: Intent = Intent(context, TaxiSplashActivity::class.java).apply {
                    putExtra("deepLink", message)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // 새 태스크에서 Activity 시작
                }

                context?.startActivity(taxiIntent)
            } else {
                val mainIntent: Intent = Intent(context, MainSplashActivity::class.java).apply {
                    putExtra("deepLink", message)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // 새 태스크에서 Activity 시작
                }

                context?.startActivity(mainIntent) // Intent 시작
            }
        }
    }
}
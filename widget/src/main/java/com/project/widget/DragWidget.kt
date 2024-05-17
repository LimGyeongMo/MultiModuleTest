package com.project.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import com.project.daeguromultimodule.MainSplashActivity
import com.project.taxi.TaxiSplashActivity
import com.project.taxi.databinding.TaxiActivitySplashBindingImpl

/**
 * Implementation of App Widget functionality.
 */
class DragWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.drag_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

//    val message = "dd"
//    val intent: Intent = if (context.packageName.toString() == "com.project.taxi") {
//        Intent(context, TaxiSplashActivity::class.java)
//            .putExtra("deepLink", message)
//    } else {
//        Intent(context, MainSplashActivity::class.java)
//            .putExtra("deepLink", message)
//    }
//
//    val pe = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
//
//    views.setOnClickPendingIntent(R.id.appwidget_text, pe)

    val intent = Intent(context, DataReceiver::class.java).apply {
        action = "com.example.ACTION"
        putExtra("deepLink", "dd")
    }
    val pendingIntent = PendingIntent.getBroadcast(context, appWidgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent)


    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
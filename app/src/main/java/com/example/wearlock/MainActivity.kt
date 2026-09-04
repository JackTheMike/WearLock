package com.example.wearlock

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if our custom background service is currently active
        val activeService = LockService.instance

        if (activeService != null) {
            // Service is active: Lock the screen immediately!
            activeService.lockWatchScreen()
            finish() // Close the app instantly
        } else {
            // Service is inactive: Notify and redirect the user to settings
            Toast.makeText(
                this,
                "Enable WearLock in Accessibility settings first!",
                Toast.LENGTH_LONG
            ).show()

            // Open the watch's Accessibility Settings page
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(intent)
            finish() // Close our app setup window
        }
    }
}
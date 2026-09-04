package com.example.wearlock

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class LockService : AccessibilityService() {

    // A static global variable to let our main app talk directly to this service
    companion object {
        var instance: LockService? = null
    }

    // Runs automatically when you enable this service in your watch settings
    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
    }

    // Runs if the service is turned off or stopped
    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

    // Mandatory functions required by Android, left empty as we don't need them
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}

    // The actual execution function to lock the screen
    fun lockWatchScreen() {
        performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)
    }
}
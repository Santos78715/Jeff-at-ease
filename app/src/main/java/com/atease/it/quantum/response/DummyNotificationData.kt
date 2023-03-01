package com.atease.it.quantum.response

data class DummyNotificationData(
    val notification_text: String,
    val notification_status: String,
    val notification_image_category: String,
    val timestamp: String,
    var seen: Boolean
)

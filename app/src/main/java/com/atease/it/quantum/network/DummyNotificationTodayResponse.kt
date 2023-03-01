package com.atease.it.quantum.network

import com.atease.it.quantum.response.DummyNotificationData

class DummyNotificationTodayResponse {
    var notificationData: ArrayList<DummyNotificationData> = ArrayList()

    fun setDummyNotificationData(): ArrayList<DummyNotificationData> {
        notificationData.add(
            DummyNotificationData(
                "You have new vet request",
                "Connection request",
                "Connection request",
                "2h ago",
                true
            )
        )

        return notificationData
    }
}
package com.atease.it.quantum.network

import com.atease.it.quantum.response.DummyNotificationData

class DummyNotificationEarlierResponse {
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
        notificationData.add(
            DummyNotificationData(
                "Someone Posted in need help",
                "Application status",
                "Application status",
                "2w ago",
                true
            )
        )
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
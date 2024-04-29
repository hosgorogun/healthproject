package com.inuceng.evdesaglik.ui.dashboard.fragments
import com.inuceng.evdesaglik.R
import com.inuceng.evdesaglik.data.Appointment
object MockList {
    fun getMockedItemList(): List<Appointment> {
        val itemModel1 = Appointment(
            doctor = "Dr.Ogün Hoşgör",
            date = "10.01.2024",
            time = "10:00",
            user = "12345678933"
        )
        val itemModel2 = Appointment(
            doctor = "Dr.Ulaş Can Yazıcı",
            date = "11.01.2024",
            time = "11:00",
            user = "12345678922"
        )
        val itemModel3 = Appointment(
            doctor = "Dr.Umut Çalışkan",
            date = "12.01.2024",
            time = "12:00",
            user = "12345678911"
        )

        val itemList: ArrayList<Appointment> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)

        return itemList
    }

}
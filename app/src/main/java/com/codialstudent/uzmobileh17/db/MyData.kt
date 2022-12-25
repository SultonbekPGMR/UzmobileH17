package com.codialstudent.uzmobileh17.db

import com.codialstudent.uzmobileh17.models.InfoData
import java.math.RoundingMode

object MyData {

    private val infoList = ArrayList<InfoData>()

    fun getData3(): ArrayList<InfoData> {
        infoList.clear()
        infoList.add(InfoData("1024", "1", "9000"))
        generateListItems(infoList)
        return infoList
    }

    fun getData2(): ArrayList<InfoData> {
        infoList.clear()
        infoList.add(InfoData("100", "100", "4000"))
        generateItem2List(infoList)
        return infoList
    }

    fun getData4(): ArrayList<InfoData> {
        infoList.clear()
        infoList.add(InfoData("60", "60", "3200"))
        generateItem2List(infoList)
        return infoList
    }

    fun getData5(): ArrayList<InfoData> {
        infoList.clear()
        for (i in 0 until 2) {
            infoList.add(
                InfoData(
                    "*105#",
                    "Limit qoldig'i va balansingizni bilib oling",
                    "Limit qoldig'i va balans tekshirish"
                )
            )
            infoList.add(
                InfoData(
                    "*199#",
                    "barcha kontent xizmatlarni o'chirishingiz mumkin",
                    "barcha kontent xizmatlarni o'chirish"
                )
            )
            infoList.add(InfoData("*100*4#", "Raqamingizni bilib oling", "Mening raqamim"))
            infoList.add(InfoData("*43#", "Kutib turish funksiyanini yoqing", "Kutib turish"))
            infoList.add(InfoData("*#06#", "Telefon IMEI-KOD ini bilib oling", "IMEI-KOD"))
        }

        return infoList
    }

    fun getData1(): ArrayList<InfoData> {
        infoList.clear()
        for (i in 0 until 2) {
            infoList.add(InfoData("8400", "Telefon raqamni o'zgartirish", "ingiz mumkin"))
            infoList.add(InfoData("4200", "Ta'rif rejasini almashtirish", "ingiz mumkin"))
            infoList.add(InfoData("8400", "Qo‘ng‘iroqlar tafsiloti", "ni ko'rishingiz   mumkin"))
            infoList.add(InfoData("12500", "Shartnomani tiklash", "ingiz mumkin"))
        }

        return infoList
    }

    fun getData0(): ArrayList<InfoData> {
        infoList.clear()
        for (i in 0 until 2) {
            infoList.add(InfoData("Oddiy", "daqiqalar: 250\n internet:500 MB\n SMS:250", "9900"))
            infoList.add(
                InfoData(
                    "Optimal", "daqiqalar: 350\n" +
                            " internet: 350 MB\n" +
                            " SMS:350", "20900"
                )
            )
            infoList.add(InfoData("Obod", "daqiqalar: 150", "6300"))
            infoList.add(
                InfoData(
                    "Ajoyib", "daqiqalar: cheksiz\n" +
                            " internet:1000 MB\n" +
                            " SMS:1000", "39900"
                )
            )
            infoList.add(InfoData("CDMA-180", "daqiqalar: 150", "6300"))
        }

        return infoList
    }

    private fun generateItem2List(infoList: ArrayList<InfoData>) {
        var name: Int
        var price: Int
        for (i in 0 until 10) {
            name = infoList[i].name.toInt()
            price = infoList[i].price.toInt()
            infoList.add(
                InfoData(
                    (name + 25).toString(),
                    (name + 25).toString(),
                    (price + 1300).toString()
                )
            )
        }
    }


    private fun generateListItems(infoList: ArrayList<InfoData>): ArrayList<InfoData> {
        var name: Int
        var secondName: Double
        var price: Int
        for (i in 0 until 10) {
            name = infoList[i].name.toInt()
            secondName = infoList[i].secondName.toDouble()
            price = infoList[i].price.toInt()
            infoList.add(
                InfoData(
                    (name + name / 4).toString(),
                    (secondName + secondName / 4).toBigDecimal().setScale(1, RoundingMode.UP)
                        .toDouble().toString(),
                    (price + price / 7).toString()
                )
            )
        }

        return infoList
    }


}
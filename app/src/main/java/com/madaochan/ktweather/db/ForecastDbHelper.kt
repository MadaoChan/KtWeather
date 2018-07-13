package com.madaochan.ktweather.db

import android.database.sqlite.SQLiteDatabase
import com.madaochan.ktweather.App
import org.jetbrains.anko.db.*

class ForecastDbHelper(): ManagedSQLiteOpenHelper(
        App.instance, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        /*
         createTable()方法
         参数1: 表名
         参数2: 为true的时候，创建的时候会检查在不在
         参数3: 相当于SQL在建表时候的声明，用Pair对象来包裹
                而Pair又可以通过anko简化为A to B
         */

        // 例如：以下的建表操作
//        db?.createTable(CityForecastTable.NAME,
//                true,
//                Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
//                Pair(CityForecastTable.CITY, TEXT),
//                Pair(CityForecastTable.COUNTRY, TEXT))
        // 可以简化为：
        db!!.createTable(CityForecastTable.NAME,
                true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME,
                true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }


}








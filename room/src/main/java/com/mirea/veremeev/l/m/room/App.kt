package com.mirea.veremeev.l.m.room

import android.app.Application
import androidx.room.Room


class App : Application() {
    private var database: AppDatabase? = null
    private var instance: App? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    fun getDatabase() : AppDatabase {
        return database!!
    }

    fun getInstance() : App {
        return instance!!
    }
}
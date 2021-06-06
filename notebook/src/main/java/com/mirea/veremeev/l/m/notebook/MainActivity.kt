package com.mirea.veremeev.l.m.notebook

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var text: EditText
    private lateinit var name: EditText
    private lateinit var sharedPreferences: SharedPreferences
    val APP_PREFERENCES = "SETTINGS"
    var APP_PREFERENCES_NAME = "NAME"
    var APP_PREFERENCES_TEXT = "TEXT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        text = findViewById(R.id.text)
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        try {
            if (sharedPreferences.contains(APP_PREFERENCES_NAME)) {
                name.setText(sharedPreferences.getString(APP_PREFERENCES_NAME, "ERROR"))
            }
            if (sharedPreferences.contains(APP_PREFERENCES_TEXT)) {
                text.setText(sharedPreferences.getString(APP_PREFERENCES_TEXT, "ERROR"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun onClick(view: View?) {
        val strName = name.text.toString()
        val strText = text.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString(APP_PREFERENCES_NAME, strName)
        editor.putString(APP_PREFERENCES_TEXT, strText)
        editor.apply()
        Toast.makeText(this, "Заметка сохранена", Toast.LENGTH_SHORT).show()
    }
}
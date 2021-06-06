package com.mirea.veremeev.l.m.practice6

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var editText : EditText
    private lateinit var textView : TextView
    private lateinit var preferences : SharedPreferences
    val SAVED_TEXT : String = "saved_text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        preferences = getPreferences(MODE_PRIVATE)
    }

    fun onSaveText(view: View?) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(SAVED_TEXT, editText.getText().toString())
        editor.apply()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }

    fun onLoadText(view: View?) {
        val text = preferences.getString(SAVED_TEXT, "Empty")
        textView.setText(text)
    }
}
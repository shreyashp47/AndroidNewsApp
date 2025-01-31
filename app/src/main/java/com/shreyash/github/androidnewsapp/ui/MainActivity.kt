package com.shreyash.github.androidnewsapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shreyash.github.androidnewsapp.MainViewModel
import com.shreyash.github.androidnewsapp.R

class MainActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val counterText = findViewById<TextView>(R.id.counterText)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)

        mainViewModel.count.observe(this, Observer { count ->
            counterText.text = count.toString()
        })

        incrementButton.setOnClickListener {
            mainViewModel.incrementCount()
        }

        decrementButton.setOnClickListener {
            mainViewModel.decrementCount()
        }
    }
}
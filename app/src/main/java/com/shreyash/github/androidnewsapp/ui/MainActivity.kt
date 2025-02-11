package com.shreyash.github.androidnewsapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shreyash.github.androidnewsapp.R
import com.shreyash.github.androidnewsapp.ui.userlist.UserListActivity
import com.shreyash.github.androidnewsapp.ui.filter.FilterActivity
import com.shreyash.github.androidnewsapp.ui.search.SearchActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val counterText = findViewById<TextView>(R.id.counterText)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        val filterBtn = findViewById<Button>(R.id.filterBtn)
        val singleApi = findViewById<Button>(R.id.singleApi)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        singleApi.setOnClickListener(this)

        mainViewModel.count.observe(this, Observer { count ->
            counterText.text = count.toString()
        })

        incrementButton.setOnClickListener {
            mainViewModel.incrementCount()
        }

        decrementButton.setOnClickListener {
            mainViewModel.decrementCount()
        }
        filterBtn.setOnClickListener(this)
        searchBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.singleApi -> {
                startActivity(Intent(this@MainActivity, UserListActivity::class.java))
            }

            R.id.filterBtn -> {
                startActivity(Intent(this@MainActivity, FilterActivity::class.java))
            }

            R.id.searchBtn -> {
                startActivity(Intent(this@MainActivity, SearchActivity::class.java))
            }

        }
    }
}
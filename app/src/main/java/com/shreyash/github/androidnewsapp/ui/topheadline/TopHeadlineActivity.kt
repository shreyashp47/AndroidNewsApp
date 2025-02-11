package com.shreyash.github.androidnewsapp.ui.topheadline

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shreyash.github.androidnewsapp.NewsApplication
import com.shreyash.github.androidnewsapp.R
import com.shreyash.github.androidnewsapp.databinding.ActivityTopHeadlineBinding
import com.shreyash.github.androidnewsapp.di.component.DaggerActivityComponent
import com.shreyash.github.androidnewsapp.di.module.ActivityModule

class TopHeadlineActivity : AppCompatActivity() {

    lateinit var activityModule: ActivityModule

    private lateinit var binding : ActivityTopHeadlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_headline)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        injectDependencies()
    }


    fun injectDependencies(){
        DaggerActivityComponent.builder()
            .applicationComponent((application as NewsApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build().inject(this)
    }
}
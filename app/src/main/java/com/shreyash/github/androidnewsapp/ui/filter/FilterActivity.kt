package com.shreyash.github.androidnewsapp.ui.filter

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shreyash.github.androidnewsapp.R
import com.shreyash.github.androidnewsapp.data.APIHelperImp
import com.shreyash.github.androidnewsapp.data.RetrofitBuilder
import com.shreyash.github.androidnewsapp.ui.base.UiState
import com.shreyash.github.androidnewsapp.ui.base.ViewModelFactory
import com.shreyash.github.androidnewsapp.ui.userlist.UserListViewModel
import com.shreyash.github.androidnewsapp.utils.DefaultDispatcherProvider
import kotlinx.coroutines.launch
class FilterActivity : AppCompatActivity() {

    private lateinit var viewModel: FilterViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_running_task)
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.textView)
        setupViewModel()
        setupLongRunningTask()
    }

    private fun setupLongRunningTask() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            progressBar.visibility = View.GONE
                            textView.text = it.data
                            textView.visibility = View.VISIBLE
                        }
                        is UiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                            textView.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
                            progressBar.visibility = View.GONE
                            Toast.makeText(this@FilterActivity, it.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
        viewModel.startFilterTask()
    }
    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                APIHelperImp(RetrofitBuilder.apiServices),
                DefaultDispatcherProvider()
            )
        )[FilterViewModel::class.java]
    }
}

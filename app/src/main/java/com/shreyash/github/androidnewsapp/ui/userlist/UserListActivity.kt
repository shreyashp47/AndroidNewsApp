package com.shreyash.github.androidnewsapp.ui.userlist

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shreyash.github.androidnewsapp.R
import com.shreyash.github.androidnewsapp.data.APIHelper
import com.shreyash.github.androidnewsapp.data.APIHelperImp
import com.shreyash.github.androidnewsapp.data.APIUsers
import com.shreyash.github.androidnewsapp.data.RetrofitBuilder
import com.shreyash.github.androidnewsapp.ui.adapter.UserAdapter
import com.shreyash.github.androidnewsapp.ui.base.UiState
import com.shreyash.github.androidnewsapp.ui.base.ViewModelFactory
import com.shreyash.github.androidnewsapp.utils.DefaultDispatcherProvider
import kotlinx.coroutines.launch

class UserListActivity : AppCompatActivity() {

    private lateinit var viewModel: UserListViewModel
    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        setupViewModel()
        setUpUI()
        setupObserver()


    }

    fun setUpUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter

    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }

                        is UiState.Error -> {
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@UserListActivity,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        is UiState.Success -> {
                            progressBar.visibility = View.GONE
                            renderList(it.data)
                            recyclerView.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }


    }

    private fun renderList(users: List<APIUsers>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                APIHelperImp(RetrofitBuilder.apiServices),
                DefaultDispatcherProvider()
            )
        )[UserListViewModel::class.java]
    }


}
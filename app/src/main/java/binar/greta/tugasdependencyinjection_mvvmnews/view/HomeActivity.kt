package binar.greta.tugasdependencyinjection_mvvmnews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.tugasdependencyinjection_mvvmnews.R
import binar.greta.tugasdependencyinjection_mvvmnews.viewmodel.VMNews
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val viewModel : VMNews by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getHome()
    }

    fun getHome(){
        viewModel.getApiNews()
        viewModel.liveDataNews.observe(this){ get ->
            rv_news.layoutManager = LinearLayoutManager(this)
            rv_news.adapter = AdapterNews(get)
        }
    }
}
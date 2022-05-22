package binar.greta.tugasdependencyinjection_mvvmnews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.tugasdependencyinjection_mvvmnews.R
import binar.greta.tugasdependencyinjection_mvvmnews.viewmodel.VMNews
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: VMNews by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getHomee()
    }
    fun getHomee(){
        val newsadapter = AdapterNews(){
            val pindah = Intent(this, DetailActivity::class.java)
            pindah.putExtra("detailnews", it)
            startActivity(pindah)
        }
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsadapter

        val viewmodel = ViewModelProvider(this).get(VMNews::class.java)
        viewmodel.news.observe(this,{
            if(it != null){
                newsadapter.setdataNews(it)
                newsadapter.notifyDataSetChanged()
            }
        })
    }
}


//    fun getHome(){
//        viewModel.getApiNews()
//        viewModel.liveDataNews.observe(this){ get ->
//            rv_news.layoutManager = LinearLayoutManager(this)
//            rv_news.adapter = AdapterNews(get)
//        }
//    }

package binar.greta.tugasdependencyinjection_mvvmnews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.tugasdependencyinjection_mvvmnews.R
import binar.greta.tugasdependencyinjection_mvvmnews.model.GetAllNewsItem
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail.*

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailnews = intent.getParcelableExtra<GetAllNewsItem>("detailnews")

        txt_titleDetail.text = detailnews?.title
        txt_tanggalDetail.text = detailnews?.createdAt
        txt_authorDetail.text = detailnews?.author

        Glide.with(this).load(detailnews?.image).into(img_detail)

    }
}
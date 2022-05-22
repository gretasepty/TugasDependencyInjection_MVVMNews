package binar.greta.tugasdependencyinjection_mvvmnews.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.greta.tugasdependencyinjection_mvvmnews.R
import binar.greta.tugasdependencyinjection_mvvmnews.model.GetAllNews
import binar.greta.tugasdependencyinjection_mvvmnews.model.GetAllNewsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class AdapterNews(private var onclick : (GetAllNewsItem)-> Unit): RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    private var datanews : List<GetAllNewsItem>?= null
    fun setdataNews(news : List<GetAllNewsItem>){
        this.datanews = news
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_author.text = datanews!![position].author
        holder.itemView.txt_tanggal.text = datanews!![position].createdAt
        holder.itemView.txt_judul.text = datanews!![position].title

        Glide.with(holder.itemView.context).load(datanews!![position].image)
            .into(holder.itemView.img_news)

        holder.itemView.cardNews.setOnClickListener{
            onclick(datanews!![position])
        }
    }

    override fun getItemCount(): Int {
        if(datanews == null){
            return 0
        }else{
            return datanews!!.size
        }

    }
}
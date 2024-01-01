package com.example.newsmandiri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsmandiri.response.ArticlesItem

class MainAdapter ( private val listener: (ArticlesItem) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var news = listOf<ArticlesItem>()

    fun setnews(news:List<ArticlesItem>){
        this.news = news
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_main,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount() = news.size

    class ViewHolder (val itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(news: ArticlesItem) {
            val judul = itemView.findViewById<TextView>(R.id.judullistberita)
            judul.text = news.title

            val penerbit = itemView.findViewById<TextView>(R.id.penerbitlistberita)
            penerbit.text = news.author

            val tgl = itemView.findViewById<TextView>(R.id.tanggallistberita)
            tgl.text = news.publishedAt

            val layout = itemView.findViewById<ConstraintLayout>(R.id.constraintadapter)
            layout.setOnClickListener{
                listener(news)
            }

            Glide.with(itemView.context)
                .load(news.urlToImage)
                .apply { RequestOptions().dontTransform().placeholder(R.drawable.loading) }
                .into(itemView.findViewById(R.id.imagelist))

        }

        private fun listener(news: ArticlesItem) {

        }

    }

}
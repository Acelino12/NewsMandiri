package com.example.newsmandiri

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsmandiri.response.ArticlesItem

class DetailActivity : AppCompatActivity() {

    companion object{
        val Extra_News = "extraNews"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_main)

        val news = intent.getParcelableExtra<ArticlesItem>(Extra_News)

        val judul = findViewById<TextView>(R.id.juduldetail)
        val content = findViewById<TextView>(R.id.isidetail)
        val penerbit = findViewById<TextView>(R.id.penerbitlistberita)
        val tanggal = findViewById<TextView>(R.id.tanggallistberita)

        content.text = news!!.content
        judul.text = news.title
        penerbit.text = news.author
        tanggal.text = news.publishedAt


    }

}
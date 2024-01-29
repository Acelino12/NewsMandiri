package com.example.newsmandiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmandiri.DetailActivity.Companion.Extra_News
import com.example.newsmandiri.response.ArticlesItem
import com.example.newsmandiri.response.NewsResponse
import com.example.newsmandiri.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAPIEveryting()
        recyclerViewEveryting()

    }

    private fun getAPIEveryting() {
        ApiService.create().getdata().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
                    val articel : List<ArticlesItem> = response.body()?.articles as List<ArticlesItem>
                    adapter.setnews(articel)
                }

            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun recyclerViewEveryting() {
        val rv = findViewById<RecyclerView>(R.id.listrecycler)
        adapter = MainAdapter {
            moveActivityEveryting(it)
        }
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

    private fun moveActivityEveryting(news: ArticlesItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Extra_News, news)
        startActivity(intent)
    }

}
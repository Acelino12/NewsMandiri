package com.example.newsmandiri.retrofit

import com.example.newsmandiri.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET ("everything?domains=techcrunch.com,thenextweb.com&apiKey=e5e147f4b3ea4cec821213ecb51a9563")
    fun getdata() : Call <NewsResponse>

}
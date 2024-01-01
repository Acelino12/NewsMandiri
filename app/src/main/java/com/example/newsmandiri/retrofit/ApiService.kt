package com.example.newsmandiri.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    var BASE_URL:String="https://newsapi.org/v2/"

        fun create(): ApiEndPoint {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build()

            return retrofit.create(ApiEndPoint::class.java)

        }

    private fun okHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()

            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }
}


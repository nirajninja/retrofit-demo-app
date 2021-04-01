package com.example.retrofit4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        btn1.setOnClickListener {
            val name=ettext.text.toString()
            val platform=plttext.text.toString()
            //val platform="codechef"
            getMyData(platform,name)
            }


    }

    private fun getMyData(platform:String,username: String) {
        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://competitive-coding-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData=retrofitBuilder.getFullData(platform,username)

        retrofitData.enqueue(object : Callback<cp_data?> {
            override fun onFailure(call: Call<cp_data?>, t: Throwable) {

                Log.d("TAG","fuck off")
            }

            override fun onResponse(call: Call<cp_data?>, response: Response<cp_data?>) {

             val response=response.body()!!
              Log.d("TAG","No fuck  up")
                tv1.text=response.user_details.name
                tv2.text=response.user_details.city
                tv3.text=response.user_details.country
                tv4.text=response.user_details.institution
                tv5.text=response.rating.toString()
                tv6.text=response.country_rank.toString()
                tv7.text=response.stars
            }
        })


    }
}
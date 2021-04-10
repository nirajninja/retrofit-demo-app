package com.example.retrofit4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.retrofit4.leetcode.leetCode
import com.example.retrofit4.viewModel.NameViewModel
import kotlinx.android.synthetic.main.activity_codechef.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val model: NameViewModel by viewModels()

    lateinit var userName:String
    lateinit var institution:String
    lateinit var Rating:String
    lateinit var  star:String
    lateinit var  fullSolved:String
    lateinit var  partiallySolved:String
    lateinit var  globalRank:String
    lateinit var  countryRank:String
    lateinit var  city:String
    lateinit var highestRank:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameObserver = Observer<String> { newName ->

            // Update the UI, in this case, a TextView.
            tv1.text = newName
        }
        val cityObserver = Observer<String> { cityname ->

            // Update the UI, in this case, a TextView.
            tv2.text = cityname
        }
        val collegeNameObserver = Observer<String> { collegeName ->

            // Update the UI, in this case, a TextView.
            tv3.text = collegeName
        }
        val RatingObserver = Observer<String> { Rating ->

            // Update the UI, in this case, a TextView.
            tv4.text = Rating
        }
        model.username.observe(this, usernameObserver)

        model.city.observe(this, cityObserver)

        model.institution.observe(this, collegeNameObserver)

        model.rank.observe(this, RatingObserver)





        btn1.setOnClickListener {
            val name = ettext.text.toString()
            val platform = plttext.text.toString()
            //val platform="codechef"
            val cc = "codechef"
            val leetcode="leetcode"

            getMyData(cc, name)
        }








    }

    private fun getMyData(platform: String, username: String) {


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://competitive-coding-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        if(platform=="leetcode")
        {
            val retrofitData = retrofitBuilder.getleetcodeData(platform, username)
            retrofitData.enqueue(object : Callback<leetCode?> {
                override fun onFailure(call: Call<leetCode?>, t: Throwable) {

                    Log.d("TAG", "nikal leetcode")

                }

                override fun onResponse(call: Call<leetCode?>, response: Response<leetCode?>) {

                    val response = response.body()!!
                    Log.d("TAG", "mat nikal leetcode")
                    //tv1.text = response.ranking
                    //tv2.text = response.total_problems_solved


                }
            })

        }


        if(platform=="codechef")
        {


            val retrofitData = retrofitBuilder.getFullData(platform, username)

            retrofitData.enqueue(object : Callback<cp_data?> {
                override fun onFailure(call: Call<cp_data?>, t: Throwable) {

                    Log.d("TAG", "nikal")
                }

                override fun onResponse(call: Call<cp_data?>, response: Response<cp_data?>) {
                    val response = response.body()!!
                    Log.d("TAG", "mat nikal")


                     userName=response.user_details.username
                     institution =response.user_details.institution
                     Rating=response.rating.toString()
                     star=response.stars
                     fullSolved=response.fully_solved.toString()
                     partiallySolved=response.partially_solved.toString()
                     globalRank=response.global_rank.toString()
                     countryRank=response.country_rank.toString()
                     city=response.user_details.city
                    highestRank=response.highest_rating.toString()





                    model.username.setValue(userName)
                    model.city.setValue(city)
                    model.institution.setValue(institution)
                    model.rank.setValue(Rating)




                        val data=codechefdata(userName,institution,Rating,star,fullSolved,partiallySolved,globalRank,countryRank,city,highestRank)

                      /*val intent=Intent(applicationContext,codechef::class.java)

                            intent.putExtra("ExtraData",data)
                            startActivity(intent)*/
                    }





            })
        }



    }



}



/*
        if (platform == "codechef") {

            val retrofitData = retrofitBuilder.getFullData(platform, username)

            retrofitData.enqueue(object : Callback<cp_data?> {
                override fun onFailure(call: Call<cp_data?>, t: Throwable) {

                    Log.d("TAG", "nikal")
                }

                override fun onResponse(call: Call<cp_data?>, response: Response<cp_data?>) {
                    val response = response.body()!!
                    Log.d("TAG", "mat nikal")
                    tv1.text = response.stars
                    tv2.text = response.user_details.username
                    tv3.text = response.user_details.country
                    tv4.text = response.highest_rating.toString()


                }

            })


        }

        if (platform == "leetcode") {

            val retrofitData = retrofitBuilder.getleetcodeData(platform, username)
            retrofitData.enqueue(object : Callback<leetCode?> {
                override fun onFailure(call: Call<leetCode?>, t: Throwable) {

                    Log.d("TAG", "nikal leetcode")

                }

                override fun onResponse(call: Call<leetCode?>, response: Response<leetCode?>) {

                    val response = response.body()!!
                    Log.d("TAG", "mat nikal leetcode")
                    tv1.text = response.ranking
                    tv2.text = response.total_problems_solved


                }
            })


        }
        */

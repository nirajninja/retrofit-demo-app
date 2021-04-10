package com.example.retrofit4

import com.example.retrofit4.leetcode.leetCode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
/*

    @GET("api/codechef/pranshuduke")
    fun getData(): Call<cp_data>

    @GET("api/codechef/{username}")
    fun getUserData(@Path("username")username:String): Call<cp_data>
*/

    @GET("api/{platform_name}/{username}")
    fun getFullData(@Path("platform_name")platform_name:String, @Path("username")username:String):Call<cp_data>

    @GET("api/{platform_name}/{username}")
    fun getleetcodeData(@Path("platform_name")platform_name:String, @Path("username")username:String):Call<leetCode>

/*
    @GET("v2/top-headlines?&apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String, @Query("page")page:Int):Call<News>*/


}
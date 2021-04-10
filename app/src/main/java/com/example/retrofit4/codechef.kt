package com.example.retrofit4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_codechef.*

class codechef : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codechef)

        val data=intent.getSerializableExtra("ExtraData") as codechefdata

        usernameId.text=data.username
        institutionId.text=data.institution
        RatingId.text=data.rating
        StarId.text=data.star
        //FullySOlved.text=data.fullSolved
        //partiallySolvedId.text=data.partiallySolved
        GlobalRankId.text=data.globalRank
        CountryRankId.text=data.countryRank
        HIghesRatingId.text=data.highestRank



    }
}
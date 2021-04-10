package com.example.retrofit4

import java.io.Serializable

data class codechefdata (

    val username:String,
    val institution:String,
    val rating:String,
    val star:String,
    val fullSolved:String,
    val partiallySolved:String,
    val globalRank:String,
    val countryRank:String,
    val city:String,
    val highestRank:String
):Serializable

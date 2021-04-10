package com.example.retrofit4.codeforces

data class codeforces(
    val contests: List<Contest>,
    //val max rank: String,
   // val max rating: Int,
    val platform: String,
    val rank: String,
    val rating: Int,
    val status: String,
    val username: String
)
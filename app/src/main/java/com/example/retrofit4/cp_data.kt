package com.example.retrofit4

data class cp_data(
    val contest_ratings: List<ContestRating>,
    val contests: List<Contest>,
    val country_rank: Int,
    val fully_solved: FullySolved,
    val global_rank: Int,
    val highest_rating: Int,
    val partially_solved: PartiallySolved,
    val rating: Int,
    val stars: String,
    val status: String,
    val user_details: UserDetails
)
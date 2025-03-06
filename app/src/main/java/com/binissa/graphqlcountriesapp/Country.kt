package com.binissa.graphqlcountriesapp

data class Country(
    val name: String = "",
    val code: String = "",
    val emoji: String = "",
    val capital: String? = null,
    val currency: String? = null,
    val continent: String? = null,
    val languages: List<String>? = null

)
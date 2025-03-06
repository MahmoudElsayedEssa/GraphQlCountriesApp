package com.binissa.graphqlcountriesapp

import com.apollographql.apollo.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery

class CountryClient(private val apolloClient: ApolloClient) {
    suspend fun getCountries(): List<Country> {
        return apolloClient.query(CountriesQuery()).execute().data?.toCounties() ?: emptyList()
    }

    suspend fun getCountry(id: String): Country {
        return apolloClient.query(CountryQuery(id)).execute().data?.toCountry() ?: Country()
    }

}

private fun CountryQuery.Data.toCountry(): Country? {
    return country?.let {
        Country(
            name = it.name,
            code = it.code,
            emoji = it.emoji,
            capital = it.capital,
            currency = it.currency,
            continent = it.continent.name,
            languages = it.languages.map { it.name }
        )
    }

}


private fun CountriesQuery.Data.toCounties(): List<Country> {
    return countries.map { country ->
        Country(
            name = country.name,
            code = country.code,
            emoji = country.emoji,
            capital = country.capital
        )
    }
}



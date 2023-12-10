package com.chirag_redij.graphql_eg.data

import com.chirag_redij.CountriesQuery
import com.chirag_redij.CountryQuery
import com.chirag_redij.graphql_eg.domain.DetailedCountry
import com.chirag_redij.graphql_eg.domain.ListCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toListCountry(): ListCountry {
    return ListCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}
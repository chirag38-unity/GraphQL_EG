package com.chirag_redij.graphql_eg.data

import com.apollographql.apollo3.ApolloClient
import com.chirag_redij.CountriesQuery
import com.chirag_redij.CountryQuery
import com.chirag_redij.graphql_eg.domain.CountryClient
import com.chirag_redij.graphql_eg.domain.DetailedCountry
import com.chirag_redij.graphql_eg.domain.ListCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<ListCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map {
                it.toListCountry()
            }?.sortedBy { it.name } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}
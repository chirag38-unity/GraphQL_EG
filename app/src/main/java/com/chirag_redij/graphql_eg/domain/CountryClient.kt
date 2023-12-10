package com.chirag_redij.graphql_eg.domain

interface CountryClient {
    suspend fun getCountries(): List<ListCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}
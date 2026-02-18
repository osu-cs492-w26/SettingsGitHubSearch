package edu.oregonstate.cs492.settingsgithubsearch.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface GitHubService {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars"
    ): Response<GitHubSearchResults>

    companion object {
        private val BASE_URL = "https://api.github.com/"

        // GitHubService.create()
        fun create(): GitHubService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(GitHubService::class.java)
        }
    }
}
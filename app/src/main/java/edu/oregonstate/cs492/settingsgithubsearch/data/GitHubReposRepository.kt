package edu.oregonstate.cs492.settingsgithubsearch.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GitHubReposRepository(
    private val service: GitHubService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun loadReposSearch(query: String, sort: String): Result<List<GitHubRepo>> =
        withContext(ioDispatcher) {
            try {
                val res = service.searchRepositories(query, sort)
                if (res.isSuccessful) {
                    Result.success(res.body()?.items ?: listOf())
                } else {
                    Result.failure(Exception(res.errorBody()?.string()))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
}
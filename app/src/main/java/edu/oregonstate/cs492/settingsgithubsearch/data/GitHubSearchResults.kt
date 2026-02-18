package edu.oregonstate.cs492.settingsgithubsearch.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubSearchResults(
    val items: List<GitHubRepo>
)
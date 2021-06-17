package com.eugene.androidpopularlibraries.cache

import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.model.GithubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface GithubRepositoriesCache {
    fun getUserRepos(user: GithubUser): Single<List<GitHubRepo>>
    fun putUserRepos(user: GithubUser, repos: List<GitHubRepo>): Completable
}
package com.eugene.androidpopularlibraries.model

import com.eugene.androidpopularlibraries.api.IDataSource
import com.eugene.androidpopularlibraries.cache.GithubRepositoriesCache
import com.eugene.androidpopularlibraries.network.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.RuntimeException

class RetrofitGithubRepositoriesRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val githubReposCache: GithubRepositoriesCache
): IGithubRepositoriesRepo {

    override fun getRepositories(user: GithubUser): Single<List<GitHubRepo>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                    user.reposUrl?.let { url ->
                        api.getRepo(url)
                            .flatMap { repos ->
                                githubReposCache.putUserRepos(user, repos).toSingleDefault(repos)
                            }
                    } ?: Single.error<List<GitHubRepo>>(RuntimeException("No user in cache"))
                        .subscribeOn(Schedulers.io())
                } else {
                    githubReposCache.getUserRepos(user)
                }
        }.subscribeOn(Schedulers.io())
}
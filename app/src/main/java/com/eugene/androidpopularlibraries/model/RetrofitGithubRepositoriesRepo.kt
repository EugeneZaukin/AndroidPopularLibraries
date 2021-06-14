package com.eugene.androidpopularlibraries.model

import com.eugene.androidpopularlibraries.api.IDataSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.RuntimeException

class RetrofitGithubRepositoriesRepo(val api: IDataSource): IGithubRepositoriesRepo {
    override fun getRepositories(user: GithubUser): Single<List<GitHubRepo>> =
        user.reposUrl?.let { url -> api.getRepo(url).subscribeOn(Schedulers.io())
        } ?: Single
            .error<List<GitHubRepo>>(RuntimeException("Failed repos list"))
            .subscribeOn(Schedulers.io())
}
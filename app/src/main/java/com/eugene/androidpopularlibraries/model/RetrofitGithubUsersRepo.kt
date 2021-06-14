package com.eugene.androidpopularlibraries.model

import com.eugene.androidpopularlibraries.api.IDataSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.RuntimeException

class RetrofitGithubUsersRepo(val api: IDataSource): IGithubUsersRepo {
    override fun getUsers(): Single<List<GithubUser>> =
        api.getUsers().subscribeOn(Schedulers.io()) ?: Single
                                                       .error<List<GithubUser>>(RuntimeException("Users not load"))
                                                       .subscribeOn(Schedulers.io())
}
package com.eugene.androidpopularlibraries.api

import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.model.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET
    fun getRepo(@Url url: String): Single<List<GitHubRepo>>
}
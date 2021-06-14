package com.eugene.androidpopularlibraries.api

import com.eugene.androidpopularlibraries.model.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>
}
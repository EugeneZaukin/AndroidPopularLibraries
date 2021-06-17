package com.eugene.androidpopularlibraries.cache

import com.eugene.androidpopularlibraries.model.GithubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface GithubUsersCache {
    fun getUsers(): Single<List<GithubUser>>
    fun putUsers(users: List<GithubUser>): Completable
}
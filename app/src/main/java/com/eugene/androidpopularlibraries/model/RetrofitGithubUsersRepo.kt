package com.eugene.androidpopularlibraries.model

import com.eugene.androidpopularlibraries.api.IDataSource
import com.eugene.androidpopularlibraries.cache.GithubUsersCache
import com.eugene.androidpopularlibraries.network.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val githubUsersCache: GithubUsersCache
): IGithubUsersRepo {

    override fun getUsers(): Single<List<GithubUser>> =
        networkStatus.isOnlineSingle()
            .flatMap { isOnline ->
                if (isOnline) {
                    api.getUsers()
                        .flatMap { users ->
                            githubUsersCache.putUsers(users).toSingleDefault(users)
                        }
                } else {
                    githubUsersCache.getUsers()
                }
            }.subscribeOn(Schedulers.io())
}
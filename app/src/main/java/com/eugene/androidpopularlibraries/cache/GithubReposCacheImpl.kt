package com.eugene.androidpopularlibraries.cache

import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.model.GithubUser
import com.eugene.androidpopularlibraries.room.Database
import com.eugene.androidpopularlibraries.room.RoomGithubRepo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.RuntimeException

class GithubReposCacheImpl(private val db: Database): GithubRepositoriesCache {

    override fun getUserRepos(user: GithubUser): Single<List<GitHubRepo>> =
        Single.fromCallable {
            val roomUsers = user.login?.let { db.userDao.findByLogin(it) } ?: throw RuntimeException("No user in cache")

            return@fromCallable db.repositoryDao.findForUser(roomUsers.id).map {
                GitHubRepo(it.id, it.name, it.forksCount)
            }
        }.subscribeOn(Schedulers.io())

    override fun putUserRepos(user: GithubUser, repos: List<GitHubRepo>): Completable =
        Completable.fromAction {
            val roomUser = user.login?.let { db.userDao.findByLogin(it) } ?: throw RuntimeException("No user in cache")
            val roomRepos = repos.map {
                RoomGithubRepo(it.id ?: "", it.name ?: "", it.forksCount ?: 0, roomUser.id)
            }
            db.repositoryDao.insert(roomRepos)
        }.subscribeOn(Schedulers.io())
}
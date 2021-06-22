package com.eugene.androidpopularlibraries.di

import android.content.Context
import androidx.room.Room
import com.eugene.androidpopularlibraries.cache.GithubReposCacheImpl
import com.eugene.androidpopularlibraries.cache.GithubRepositoriesCache
import com.eugene.androidpopularlibraries.cache.GithubUsersCache
import com.eugene.androidpopularlibraries.cache.GithubUsersCacheImpl
import com.eugene.androidpopularlibraries.model.IGithubRepositoriesRepo
import com.eugene.androidpopularlibraries.model.IGithubUsersRepo
import com.eugene.androidpopularlibraries.model.RetrofitGithubRepositoriesRepo
import com.eugene.androidpopularlibraries.model.RetrofitGithubUsersRepo
import com.eugene.androidpopularlibraries.room.Database
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
interface UserModule {
    @Singleton
    @Binds
    fun usersRepo(retrofitGithubUsersRepo: RetrofitGithubUsersRepo): IGithubUsersRepo

    @Singleton
    @Binds
    fun usersCache(githubUsersCacheImpl: GithubUsersCacheImpl): GithubUsersCache

    @Singleton
    @Binds
    fun githubReposCache(githubReposCacheImpl: GithubReposCacheImpl): GithubRepositoriesCache

    @Singleton
    @Binds
    fun iGitReposRepo(retrofitGithubRepositoriesRepo: RetrofitGithubRepositoriesRepo): IGithubRepositoriesRepo

    companion object {
        @Singleton
        @Provides
        fun database(context: Context): Database =
            Room.databaseBuilder(context, Database::class.java, Database.DB_NAME).build()
    }
}
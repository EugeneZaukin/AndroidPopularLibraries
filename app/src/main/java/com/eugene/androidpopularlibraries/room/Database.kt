package com.eugene.androidpopularlibraries.room

import androidx.room.RoomDatabase

@androidx.room.Database(
    entities = [RoomGithubUser::class, RoomGithubRepo::class],
    version = 1
)

abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: RepositoryDao

    companion object {
        const val DB_NAME = "database.db"
    }
}
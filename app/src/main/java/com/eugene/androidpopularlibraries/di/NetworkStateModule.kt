package com.eugene.androidpopularlibraries.di

import com.eugene.androidpopularlibraries.network.AndroidNetworkStatus
import com.eugene.androidpopularlibraries.network.INetworkStatus
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NetworkStateModule {
    @Singleton
    @Binds
    fun networkStatus(androidNetworkStatus: AndroidNetworkStatus): INetworkStatus
}
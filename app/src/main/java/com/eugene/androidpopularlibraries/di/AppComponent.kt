package com.eugene.androidpopularlibraries.di

import com.eugene.androidpopularlibraries.MainActivity
import com.eugene.androidpopularlibraries.presenter.MainPresenter
import com.eugene.androidpopularlibraries.presenter.RepoPresenter
import com.eugene.androidpopularlibraries.presenter.UserPresenter
import com.eugene.androidpopularlibraries.presenter.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetworkStateModule::class, UserModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userPresenter: UserPresenter)
    fun inject(repoPresenter: RepoPresenter)
}
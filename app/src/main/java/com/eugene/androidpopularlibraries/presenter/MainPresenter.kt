package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.AndroidScreens
import com.eugene.androidpopularlibraries.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AndroidScreens.UsersScreen().getFragment())
    }

    fun backClicked() {
        router.exit()
    }
}
package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.AndroidScreens
import com.eugene.androidpopularlibraries.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AndroidScreens.users())
    }

    fun backClicked() {
        router.exit()
    }
}
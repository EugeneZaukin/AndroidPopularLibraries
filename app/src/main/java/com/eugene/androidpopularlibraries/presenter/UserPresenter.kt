package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.model.GithubUser
import com.eugene.androidpopularlibraries.view.UserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val router: Router, private val user: GithubUser) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        user.login?.let { viewState.setLogin(it) }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
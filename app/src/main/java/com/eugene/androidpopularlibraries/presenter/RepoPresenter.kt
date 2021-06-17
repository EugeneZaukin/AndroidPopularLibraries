package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.view.RepoView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepoPresenter(
    private val router: Router,
    private val gitHubRepo: GitHubRepo
): MvpPresenter<RepoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setId(gitHubRepo.id ?: "")
        viewState.setTitle(gitHubRepo.name ?: "")
        viewState.setForksCount((gitHubRepo.forksCount ?: 0).toString())
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.view.RepoView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class RepoPresenter(private val gitHubRepo: GitHubRepo): MvpPresenter<RepoView>() {
    @Inject
    lateinit var router: Router

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
package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.AndroidScreens
import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.model.GithubUser
import com.eugene.androidpopularlibraries.model.IGithubRepositoriesRepo
import com.eugene.androidpopularlibraries.view.UserView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(private val user: GithubUser) : MvpPresenter<UserView>() {
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var uiScheduler: Scheduler
    @Inject
    lateinit var iGithubRepositoriesRepo: IGithubRepositoriesRepo

    class RepoListPresenter: IRepoListPresenter {
        val repos = mutableListOf<GitHubRepo>()
        override var itemClickListener: ((RepoItemView) -> Unit)? = null
        override fun getCount() = repos.size
        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            repo.name?.let { view.setName(it) }
        }
    }

    val reposListPresenter = RepoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        user.login?.let { viewState.setLogin(it) }
        loadData()

        reposListPresenter.itemClickListener = { itemView ->
            val repo = reposListPresenter.repos[itemView.pos]
            router.navigateTo(AndroidScreens.RepositoryScreen(repo).getFragment())
        }
    }

    fun loadData() {
        iGithubRepositoriesRepo.getRepositories(user)
            .observeOn(uiScheduler)
            .subscribe({ repos -> updateRepos(repos) }, { it.printStackTrace() })
    }

    fun updateRepos(reposList: List<GitHubRepo>) {
        reposListPresenter.repos.clear()
        reposListPresenter.repos.addAll(reposList)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
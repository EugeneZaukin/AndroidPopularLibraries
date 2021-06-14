package com.eugene.androidpopularlibraries

import com.eugene.androidpopularlibraries.fragments.RepositoryFragment
import com.eugene.androidpopularlibraries.fragments.UserFragment
import com.eugene.androidpopularlibraries.fragments.UsersFragment
import com.eugene.androidpopularlibraries.model.GitHubRepo
import com.eugene.androidpopularlibraries.model.GithubUser
import com.eugene.androidpopularlibraries.presenter.IScreen
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AndroidScreens {
    class UsersScreen: IScreen {
        override fun getFragment(): Screen = FragmentScreen { UsersFragment.newInstance() }

    }

    class UserScreen(private val user: GithubUser): IScreen {
        override fun getFragment(): Screen = FragmentScreen { UserFragment.newInstance(user) }
    }

    class RepositoryScreen(private val repo: GitHubRepo) : IScreen {
        override fun getFragment(): Screen = FragmentScreen { RepositoryFragment.newInstance(repo) }
    }
}
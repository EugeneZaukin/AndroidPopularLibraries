package com.eugene.androidpopularlibraries

import com.eugene.androidpopularlibraries.fragments.UserFragment
import com.eugene.androidpopularlibraries.fragments.UsersFragment
import com.eugene.androidpopularlibraries.model.GithubUser
import com.eugene.androidpopularlibraries.presenter.IScreens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }

    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
}
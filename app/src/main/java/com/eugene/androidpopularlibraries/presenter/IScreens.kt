package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.model.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}
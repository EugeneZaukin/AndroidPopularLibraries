package com.eugene.androidpopularlibraries.presenter

import com.github.terrakok.cicerone.Screen

interface IScreen {
    fun getFragment(): Screen
}
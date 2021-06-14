package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.view.IItemView

interface RepoItemView: IItemView {
    fun setName(name: String)
}
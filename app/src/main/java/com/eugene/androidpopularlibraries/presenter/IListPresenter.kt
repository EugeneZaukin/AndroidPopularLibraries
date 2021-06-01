package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.view.IItemView
import com.eugene.androidpopularlibraries.view.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>
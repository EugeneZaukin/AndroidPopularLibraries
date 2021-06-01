package com.eugene.androidpopularlibraries.presenter

import com.eugene.androidpopularlibraries.view.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
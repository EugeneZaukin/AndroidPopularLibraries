package com.eugene.androidpopularlibraries.view

interface UserItemView: IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url:String)
}
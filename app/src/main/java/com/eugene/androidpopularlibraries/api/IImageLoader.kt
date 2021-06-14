package com.eugene.androidpopularlibraries.api

interface IImageLoader<T> {
    fun loadIntro(url: String, container: T)
}
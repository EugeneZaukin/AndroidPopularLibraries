package com.eugene.androidpopularlibraries.presenter

import android.graphics.Bitmap
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {
    fun init()
    fun setImage(imageBitmap: Bitmap?)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openImage()
    fun showSuccess()
    fun showError()
}
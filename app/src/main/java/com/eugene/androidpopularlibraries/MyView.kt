package com.eugene.androidpopularlibraries

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MyView: MvpView {
    fun setButtonOneText(text: String)
    fun setButtonTwoText(text: String)
    fun setButtonThreeText(text: String)
}
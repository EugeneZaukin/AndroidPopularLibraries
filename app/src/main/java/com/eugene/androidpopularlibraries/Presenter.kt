package com.eugene.androidpopularlibraries

import moxy.MvpPresenter

class Presenter(val model: Model): MvpPresenter<MyView>() {

    fun counterOneClick() {
        val nextValue = model.next(0)
        viewState.setButtonOneText(nextValue.toString())
    }

    fun counterTwoClick() {
        val nextValue = model.next(1)
        viewState.setButtonTwoText(nextValue.toString())
    }

    fun counterThreeClick() {
        val nextValue = model.next(2)
        viewState.setButtonThreeText(nextValue.toString())
    }
}
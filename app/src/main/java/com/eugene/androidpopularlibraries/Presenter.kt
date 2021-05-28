package com.eugene.androidpopularlibraries

class Presenter(val view: MyView) {
    val model = Model()

    fun counterClick(buttonNumber: ButtonIdCounter) {
        when (buttonNumber) {
            ButtonIdCounter.ONE -> setButtonText(0)
            ButtonIdCounter.TWO -> setButtonText(1)
            ButtonIdCounter.THREE -> setButtonText(2)
        }
    }

    fun setButtonText(index: Int) {
        val nextValue = model.next(index)
        view.setButtonText(index, "$nextValue")
    }
}
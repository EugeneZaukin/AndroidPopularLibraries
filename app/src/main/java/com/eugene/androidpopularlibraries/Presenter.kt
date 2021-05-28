package com.eugene.androidpopularlibraries

class Presenter(val view: MyView) {
    val model = Model()

    fun counterClick(id: Int) {
        when(id) {
            R.id.button_counter1 -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.button_counter2 -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.button_counter3 -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}
package com.eugene.androidpopularlibraries

import android.os.Bundle
import com.eugene.androidpopularlibraries.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MyView {

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter { Presenter(Model()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.buttonCounter1?.setOnClickListener { presenter.counterOneClick() }
        vb?.buttonCounter2?.setOnClickListener { presenter.counterTwoClick() }
        vb?.buttonCounter3?.setOnClickListener { presenter.counterThreeClick() }
    }

    override fun setButtonOneText(text: String) {
        vb?.buttonCounter1?.text = text
    }

    override fun setButtonTwoText(text: String) {
        vb?.buttonCounter2?.text = text
    }

    override fun setButtonThreeText(text: String) {
        vb?.buttonCounter3?.text = text
    }
}
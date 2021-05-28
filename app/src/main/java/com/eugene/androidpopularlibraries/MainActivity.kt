package com.eugene.androidpopularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eugene.androidpopularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyView {

    private var vb: ActivityMainBinding? = null
    val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        with(vb) {
            this?.buttonCounter1?.setOnClickListener { presenter.counterClick(ButtonIdCounter.ONE) }
            this?.buttonCounter2?.setOnClickListener { presenter.counterClick(ButtonIdCounter.TWO) }
            this?.buttonCounter3?.setOnClickListener { presenter.counterClick(ButtonIdCounter.THREE) }
        }
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> vb?.buttonCounter1?.text = text
            1 -> vb?.buttonCounter2?.text = text
            2 -> vb?.buttonCounter3?.text = text
        }
    }
}
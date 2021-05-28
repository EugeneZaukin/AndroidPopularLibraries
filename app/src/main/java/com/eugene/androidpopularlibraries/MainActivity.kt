package com.eugene.androidpopularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eugene.androidpopularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyView {

    private var vb: ActivityMainBinding? = null
    val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        vb?.buttonCounter1?.setOnClickListener(listener)
        vb?.buttonCounter2?.setOnClickListener(listener)
        vb?.buttonCounter3?.setOnClickListener(listener)
    }

    override fun setButtonText(index: Int, text: String) {
        when(index) {
            0 -> vb?.buttonCounter1?.text = text
            1 -> vb?.buttonCounter2?.text = text
            2 -> vb?.buttonCounter3?.text = text
        }
    }
}
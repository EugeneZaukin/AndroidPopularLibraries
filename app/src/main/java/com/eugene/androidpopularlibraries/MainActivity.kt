package com.eugene.androidpopularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.eugene.androidpopularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var vb: ActivityMainBinding? = null
    val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.buttonCounter1?.setOnClickListener {
            vb?.buttonCounter1?.text = (++counters[0]).toString()
        }

        vb?.buttonCounter2?.setOnClickListener {
            vb?.buttonCounter2?.text = (++counters[1]).toString()
        }

        vb?.buttonCounter3?.setOnClickListener {
            vb?.buttonCounter3?.text = (++counters[2]).toString()
        }

        initViews()
    }

    fun initViews() {
        vb?.buttonCounter1?.text = counters[0].toString()
        vb?.buttonCounter2?.text = counters[1].toString()
        vb?.buttonCounter3?.text = counters[2].toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putIntArray("counters", counters.toIntArray())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArray = savedInstanceState.getIntArray("counters")
        countersArray?.toList()?.let {
            counters.clear()
            counters.addAll(it)
        }
        initViews()
    }
}
package com.eugene.androidpopularlibraries

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import com.eugene.androidpopularlibraries.databinding.ActivityMainBinding
import com.eugene.androidpopularlibraries.model.ImageConverter
import com.eugene.androidpopularlibraries.model.ImagePicker
import com.eugene.androidpopularlibraries.presenter.MainPresenter
import com.eugene.androidpopularlibraries.presenter.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private var disposable: Disposable? = null
    private val presenter: MainPresenter by moxyPresenter { MainPresenter(ImageConverter(this),
                                                                          AndroidSchedulers.mainThread()) }
    private var binding: ActivityMainBinding? = null
    private val launcher = registerForActivityResult(MainActivityContract()) { data -> getImage(data) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    fun getImage(data: Intent) {
        val imagePick = ImagePicker()
        disposable = imagePick.pick(data, contentResolver)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ bitmap -> presenter.setImage(bitmap) }, {error -> "Error"})
    }

    override fun init() {
        binding?.findButton?.setOnClickListener {
            presenter.findImage()
        }

        binding?.saveButton?.setOnClickListener {
            presenter.SaveImagepng()
        }
    }

    override fun setImage(imageBitmap: Bitmap?) {
        if (imageBitmap != null) {
            binding?.imageView?.setImageBitmap(imageBitmap)
        }
    }

    override fun openImage() {
        launcher.launch(null)
    }

    override fun showSuccess() {
        Toast.makeText(this, "Convert success", Toast.LENGTH_LONG).show()
    }

    override fun showError() {
        Toast.makeText(this, "Convert failed", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        binding = null
        if (disposable != null) disposable?.dispose()
        disposable = null
        super.onDestroy()
    }
}
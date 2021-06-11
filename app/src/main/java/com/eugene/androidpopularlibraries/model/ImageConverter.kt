package com.eugene.androidpopularlibraries.model

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment.DIRECTORY_DOWNLOADS
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File
import java.io.FileOutputStream

class ImageConverter(private val context: Context): Converter {
    override fun convert(bitmap: Bitmap?): Completable = Completable.fromAction {
        val file = File(context.getExternalFilesDir(DIRECTORY_DOWNLOADS), "image.png")

        FileOutputStream(file).use { stream -> bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream) }
    }.subscribeOn(Schedulers.io())
}
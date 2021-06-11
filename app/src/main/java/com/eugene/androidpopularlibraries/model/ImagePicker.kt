package com.eugene.androidpopularlibraries.model

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ImagePicker: Picker {

    override fun pick(data: Intent?, contentResolver: ContentResolver): Single<Bitmap?> = Single
        .fromCallable { getMyBitMap(data, contentResolver) }
        .subscribeOn(Schedulers.io())

    private fun getMyBitMap(data: Intent?, contentResolver: ContentResolver): Bitmap? {
        var bitmap: Bitmap? = null
        data?.data?.let { uri ->
            val bytes = contentResolver.openInputStream(uri)?.buffered()?.use { it.readBytes() }
            bytes?.let { arr -> bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.size) }
        }
        return bitmap
    }
}

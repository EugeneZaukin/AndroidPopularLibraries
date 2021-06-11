package com.eugene.androidpopularlibraries.model

import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Completable

interface Converter {
    fun convert(bitmap: Bitmap?): Completable
}
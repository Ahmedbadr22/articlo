package com.codersinvasion.articlo.app.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


@BindingAdapter("android:setImageRes")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("android:uploadSvgPath")
fun uploadSvgPath(imageView: ImageView, path: String) {
    imageView.load(path)
}
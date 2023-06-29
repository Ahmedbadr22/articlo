package com.codersinvasion.articlo.app.bindingAdapter

import android.widget.ImageView

import androidx.databinding.BindingAdapter


@BindingAdapter("android:setImageRes")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}
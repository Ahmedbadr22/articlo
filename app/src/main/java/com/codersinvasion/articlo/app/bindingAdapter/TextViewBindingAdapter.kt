package com.codersinvasion.articlo.app.bindingAdapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:setError")
fun setError(textView: TextView, msg: String) {
    textView.visibility =  if (msg.isNotEmpty()) View.VISIBLE
    else View.INVISIBLE
    textView.text = msg
}
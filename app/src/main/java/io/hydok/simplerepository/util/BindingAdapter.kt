package io.hydok.simplerepository.util

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("bind:src")
fun setImageViewResource(view: ImageView, resId: Int) {
    view.setBackgroundResource(resId)
}

@BindingAdapter("bind:imgUrl")
fun setImageViewUrl(view: ImageView, url: String) {
    GlideUtil.imageLoad(url, view)
}

@BindingAdapter("bind:adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("bind:isGone")
fun isGone(view: View, isGone: Boolean) {
    view.isVisible = !isGone
}




package io.hydok.simplerepository.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import io.hydok.simplerepository.MainApp

object GlideUtil {

    val context = MainApp.INSTANCE.applicationCtx

    fun roundImageLoad(url: String, imageView: ImageView) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .centerCrop()
            .into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap?) {
                    val circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.resources, resource)
                    circularBitmapDrawable.isCircular = true
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
    }

    fun roundImageLoad(
        url: String,
        imageView: ImageView,
        errorDrawable: Drawable
    ) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .centerCrop()
            .error(errorDrawable)
            .into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap?) {
                    val circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.resources, resource)
                    circularBitmapDrawable.isCircular = true
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
    }

    fun imageLoad(url: String?, imageView: ImageView) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transition(DrawableTransitionOptions().crossFade())
            .into(imageView)
    }

    fun imageLoad(url: String, imageView: ImageView, errorDrawable: Drawable) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transition(DrawableTransitionOptions().crossFade())
            .error(errorDrawable)
            .into(imageView)
    }

    fun roundedCornerImageLoad(url: String, imageView: ImageView, radius: Int) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transition(DrawableTransitionOptions().crossFade())
            .transform(CenterCrop(), RoundedCorners(radius))
            .into(imageView)
    }

    fun roundedCornerImageLoad(
        url: String,
        imageView: ImageView,
        radius: Int,
        errorDrawable: Drawable
    ) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transition(DrawableTransitionOptions().crossFade())
            .transform(CenterCrop(), RoundedCorners(radius))
            .error(errorDrawable)
            .into(imageView)
    }
}
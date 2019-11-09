package com.ginilab.tomafood.base.extensions


import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.Group
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ginilab.tomafood.R

fun AppCompatImageView.loadImage(uri: String) =
    Glide.with(this).load(uri).placeholder(R.mipmap.ic_launcher).into(this)

fun AppCompatImageView.loadCircularImage(uri: String) =
    Glide.with(this).load(uri).apply(RequestOptions.circleCropTransform()).placeholder(R.mipmap.ic_launcher).into(this)

fun AppCompatImageView.loadSquareImage(uri: String) =
    Glide.with(this).load(uri).apply(RequestOptions.centerCropTransform()).placeholder(R.mipmap.ic_launcher).into(this)


fun ImageView.loadImage(uri: String?) =
    Glide.with(this).load(uri).placeholder(R.mipmap.ic_launcher).into(this)

fun ImageView.loadCircularImage(uri: String?) =
    Glide.with(this).load(uri)
        .apply(RequestOptions.circleCropTransform())
        .placeholder(R.mipmap.ic_launcher)
        .into(this)

fun ImageView.loadSquareImage(uri: String?) =
    Glide.with(this).load(uri)
        .apply(RequestOptions.centerCropTransform())
        .placeholder(R.mipmap.ic_launcher)
        .into(this)

fun Group.setAllOnClickListener(listener: View.OnClickListener?) {
    post {
        referencedIds.forEach { id ->
            rootView.run { findViewById<View>(id).setOnClickListener(listener) }
        }
    }

}

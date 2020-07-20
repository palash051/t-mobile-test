package com.jahirul.tmobileexercise.util

import android.content.Context
import android.graphics.Color
import android.support.v4.widget.CircularProgressDrawable
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jahirul.tmobileexercise.R


fun getProgressDrawable(context: Context): CircularProgressDrawable {

    return CircularProgressDrawable(context).apply {
        strokeWidth = 0f
        centerRadius = 0f
        start()
    }
}

fun ImageView.loadImage(
    uri: String?,
    height: Int,
    width: Int,
    progressDrawable: CircularProgressDrawable
) {
    this.layoutParams.height = height
    this.layoutParams.width = width
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}

fun TextView.setValue(title: String, color: String, textSize: Int) {
    this.setText(title)
    this.setTextColor(Color.parseColor(color))
    this.setTextSize(
        TypedValue.COMPLEX_UNIT_SP, textSize.toFloat()
    )
}
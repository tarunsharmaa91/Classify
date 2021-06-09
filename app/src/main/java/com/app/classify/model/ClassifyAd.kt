package com.app.classify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClassifyAd(
    val results: List<Results>
) : Parcelable

@Parcelize
data class Results(
    val created_at: String,
    val price: String,
    val name: String,
    val uid: String,
    val image_ids: List<String>,
    val image_urls: List<String>,
    val image_urls_thumbnails: List<String>
) : Parcelable
package com.jahirul.tmobileexercise.businesslogic

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(var page: Page) : Parcelable

@Parcelize
data class Page(var cards: List<Cards>) : Parcelable

@Parcelize
data class Cards(
    var card_type: String,
    var card: Card
) : Parcelable

@Parcelize
data class Card(
    var image: Image,
    var title: Title,
    var description: Description,
    var value: String,
    var attributes: Attributes
) : Parcelable

@Parcelize
data class Image(
    var url: String,
    var size: Size
) : Parcelable

@Parcelize
data class Size(
    var width: Int,
    var height: Int
) : Parcelable

@Parcelize
data class Title(
    var value: String,
    var attributes: Attributes
) : Parcelable

@Parcelize
data class Description(
    var value: String,
    var attributes: Attributes
) : Parcelable

@Parcelize
data class Attributes(
    var text_color: String,
    var font: Font
) : Parcelable

@Parcelize
data class Font(var size: Int) : Parcelable
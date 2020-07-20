package com.jahirul.tmobileexercise.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jahirul.tmobileexercise.R
import com.jahirul.tmobileexercise.businesslogic.Cards
import com.jahirul.tmobileexercise.util.getProgressDrawable
import com.jahirul.tmobileexercise.util.loadImage
import com.jahirul.tmobileexercise.util.setValue
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoListAdapter(var cards: ArrayList<Cards>) :
    RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>() {

    companion object {
        const val CARD_TYPE_TEXT = "text"
        const val CARD_TYPE_TITLE_DESCRIPTION = "title_description"
        const val CARD_TYPE_IMAGE_TITLE_DESCRIPTION = "image_title_description"

    }

    fun updateCountries(newPhotoModels: List<Cards>) {
        cards.clear()
        cards.addAll(newPhotoModels)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = PhotoViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_photo, parent, false
        )
    )

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(cards[position])
    }


    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.title
        private val imageView = view.photo
        private val description = view.description
        private val progressDrawable = getProgressDrawable(view.context)

        fun bind(cards: Cards) {
            when (cards.card_type) {
                CARD_TYPE_TEXT -> {
                    title.setValue(
                        cards.card.value,
                        cards.card.attributes.text_color,
                        cards.card.attributes.font.size
                    )
                    imageView.visibility = View.GONE
                    description.visibility = View.GONE
                }
                CARD_TYPE_TITLE_DESCRIPTION -> {
                    title.setValue(
                        cards.card.title.value,
                        cards.card.title.attributes.text_color,
                        cards.card.title.attributes.font.size
                    )
                    description.setValue(
                        cards.card.description.value,
                        cards.card.description.attributes.text_color,
                        cards.card.description.attributes.font.size
                    )
                    imageView.visibility = View.GONE
                }
                CARD_TYPE_IMAGE_TITLE_DESCRIPTION -> {
                    title.setValue(
                        cards.card.title.value,
                        cards.card.title.attributes.text_color,
                        cards.card.title.attributes.font.size
                    )
                    description.setValue(
                        cards.card.description.value,
                        cards.card.description.attributes.text_color,
                        cards.card.description.attributes.font.size
                    )
                    imageView.loadImage(
                        cards.card.image.url,
                        cards.card.image.size.height,
                        cards.card.image.size.width,
                        progressDrawable
                    )
                }
            }
        }
    }
}


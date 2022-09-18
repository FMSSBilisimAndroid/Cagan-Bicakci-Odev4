package com.caganbicakci.spaceexplorer

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class DataBindingAdapter {

    /**
     * binding adapter to handle network image resource with picasso.
     */

    companion object {
        @JvmStatic
        @BindingAdapter("imageResource")
        fun setImageResource(imageView: ImageView, resource: String) {
            Picasso.get().load(resource).into(imageView)
        }
    }
}
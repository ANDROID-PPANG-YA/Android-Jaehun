package sopt.android.assignment.util

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("profileImgUri")
    fun setProfileImg(imageview: ImageView, imgUri: Uri?) {
        if (imgUri != null) {
            Glide.with(imageview.context)
                .load(imgUri)
                .circleCrop()
                .into(imageview)
        }
    }
}
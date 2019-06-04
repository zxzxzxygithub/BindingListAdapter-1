package io.ditclear.app

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Description:
 * Created by FQH on 2019/6/4.
 */
class ImageLoader {

    companion object {
        @JvmStatic
        @BindingAdapter("imgUrl")
        fun load(iv: ImageView, url: String) {
            Glide.with(iv.context)
                    .load(url)
                    .into(iv)
        }
    }
}
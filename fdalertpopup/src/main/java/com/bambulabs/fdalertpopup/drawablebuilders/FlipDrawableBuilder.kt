package com.bambulabs.fdalertpopup.drawablebuilders

import android.graphics.drawable.Drawable
import com.bambulabs.fdalertpopup.helpers.FlipDrawable

class FlipDrawableBuilder: DrawableWrapperBuilder<FlipDrawableBuilder>() {

    private var orientation: Int =
        FlipDrawable.ORIENTATION_HORIZONTAL

    fun orientation(orientation: Int) = apply { this.orientation = orientation }

    override fun build(): Drawable {
        return FlipDrawable(
            drawable!!,
            orientation
        )
    }
}
package com.bambulabs.fdalertpopup

import android.graphics.Color
import android.view.*
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.bambulabs.fdalertpopup.drawablebuilders.DrawableBuilder
import kotlinx.android.synthetic.main.dialog_errors.view.*
import kotlin.math.min

class FDAlertPopup constructor(private var activity: AppCompatActivity) {

    /**
     * Configurations
     * @param resource popup custom image resource
     * @param lottieResource popup custom lottie resource
     * @param titleText popup title text
     * @param contentText popup content text
     * @param confirmButtonText confirm button text
     * @param cancelButtonText cancel button text
     * @param popupBackgroundColor popup background color
     * @param confirmButtonNormalColor confirm button normal color
     * @param confirmButtonNormalTextColor confirm button normal text color
     * @param confirmButtonNormalStrokeColor confirm button normal stroke color
     * @param confirmButtonPressedColor confirm button pressed color
     * @param confirmButtonPressedTextColor confirm button pressed text color
     * @param confirmButtonPressedStrokeColor confirm button pressed stroke color
     * @param cancelButtonNormalColor cancel button normal color
     * @param cancelButtonNormalTextColor cancel button normal text color
     * @param cancelButtonNormalStrokeColor cancel button normal stroke color
     * @param cancelButtonPressedColor cancel button pressed color
     * @param cancelButtonPressedTextColor cancel button pressed text color
     * @param cancelButtonPressedStrokeColor cancel button pressed stroke color
     * @param confirmAction if has try again action as function
     * @param cancelAction if has dismiss action as function
     */

    private var resource: Int? = null
    private var lottieResource: Int? = null
    private var lottieLoop: Boolean? = false
    private var titleText: String? = null
    private var contentText: String? = null
    private var confirmButtonText: String? = null
    private var cancelButtonText: String? = null
    private var popupBackgroundColor: Int = Color.WHITE
    private var confirmButtonNormalColor: Int? = null
    private var confirmButtonNormalTextColor: Int? = null
    private var confirmButtonNormalStrokeColor: Int? = null
    private var confirmButtonPressedColor: Int? = null
    private var confirmButtonPressedTextColor: Int? = null
    private var confirmButtonPressedStrokeColor: Int? = null
    private var cancelButtonNormalColor: Int? = null
    private var cancelButtonNormalTextColor: Int? = null
    private var cancelButtonNormalStrokeColor: Int? = null
    private var cancelButtonPressedColor: Int? = null
    private var cancelButtonPressedTextColor: Int? = null
    private var cancelButtonPressedStrokeColor: Int? = null
    private var confirmButtonRound: Boolean? = true
    private var confirmButtonRadius: Float? = null
    private var confirmAction: (() -> Unit)? = null
    private var cancelAction: (() -> Unit)? = null

    fun setResource(resource: Int?): FDAlertPopup {
        this.resource = resource
        return this
    }

    fun setLottieResource(lottieResource: Int): FDAlertPopup {
        this.lottieResource = lottieResource
        return this
    }

    fun setLottieLoop(lottieLoop: Boolean): FDAlertPopup {
        this.lottieLoop = lottieLoop
        return this
    }

    fun setTitleText(text: String?): FDAlertPopup {
        this.titleText = text
        return this
    }

    fun setContentText(text: String?): FDAlertPopup {
        this.contentText = text
        return this
    }

    fun setConfirmButtonText(text: String?): FDAlertPopup {
        this.confirmButtonText = text
        return this
    }

    fun setCancelButtonText(text: String?): FDAlertPopup {
        this.cancelButtonText = text
        return this
    }

    fun setPopupBackgroundColor(color: Int): FDAlertPopup {
        this.popupBackgroundColor = color
        return this
    }

    fun setConfirmButtonNormalColor(color: Int): FDAlertPopup {
        this.confirmButtonNormalColor = color
        return this
    }

    fun setCancelButtonNormalColor(color: Int): FDAlertPopup {
        this.cancelButtonNormalColor = color
        return this
    }

    fun setConfirmButtonPressedColor(color: Int): FDAlertPopup {
        this.confirmButtonPressedColor = color
        return this
    }

    fun setCancelButtonPressedColor(color: Int): FDAlertPopup {
        this.cancelButtonPressedColor = color
        return this
    }

    fun setConfirmButtonNormalTextColor(color: Int): FDAlertPopup {
        this.confirmButtonNormalTextColor = color
        return this
    }

    fun setCancelButtonNormalTextColor(color: Int): FDAlertPopup {
        this.cancelButtonNormalTextColor = color
        return this
    }

    fun setConfirmButtonPressedTextColor(color: Int): FDAlertPopup {
        this.confirmButtonPressedTextColor = color
        return this
    }

    fun setCancelButtonPressedTextColor(color: Int): FDAlertPopup {
        this.cancelButtonPressedTextColor = color
        return this
    }

    fun setConfirmButtonNormalStrokeColor(color: Int): FDAlertPopup {
        this.confirmButtonNormalStrokeColor = color
        return this
    }

    fun setCancelButtonNormalStrokeColor(color: Int): FDAlertPopup {
        this.cancelButtonNormalStrokeColor = color
        return this
    }

    fun setConfirmButtonPressedStrokeColor(color: Int): FDAlertPopup {
        this.confirmButtonNormalStrokeColor = color
        return this
    }

    fun setCancelButtonPressedStrokeColor(color: Int): FDAlertPopup {
        this.cancelButtonNormalStrokeColor = color
        return this
    }

    fun setConfirmButtonRound(round: Boolean): FDAlertPopup {
        this.confirmButtonRound = round
        return this
    }

    fun setConfirmButtonRadius(radius: Float): FDAlertPopup {
        this.confirmButtonRadius = radius
        return this
    }

    fun setConfirmAction(action: (() -> Unit)? = null): FDAlertPopup {
        this.confirmAction = action
        return this
    }

    fun setCancelAction(action: (() -> Unit)? = null): FDAlertPopup {
        this.cancelAction = action
        return this
    }

    fun show() : AlertDialog? {

        val metrics = activity.resources.displayMetrics
        val smallestScreenSize = min(metrics.widthPixels, metrics.heightPixels)

        var dialog: AlertDialog? = null

        if (!activity.isFinishing) {

            activity.runOnUiThread {

                val builder = AlertDialog.Builder(activity)

                val customLayout: View = if (cancelButtonText.isNullOrEmpty())
                    LayoutInflater.from(activity).inflate(R.layout.dialog_errors_nocancel, null)
                else
                    LayoutInflater.from(activity).inflate(R.layout.dialog_errors, null)

                customLayout.confirmButton.setOnClickListener {
                    dialog?.dismiss()
                    confirmAction?.let { it1 -> it1() }

                }

                if (!cancelButtonText.isNullOrEmpty()) {

                    customLayout.cancelButton.setOnClickListener {
                        dialog?.dismiss()
                        cancelAction?.let { it1 -> it1() }
                    }

                    customLayout.cancelButton.text = cancelButtonText

                    cancelButtonNormalColor?.let {
                        customLayout.cancelButton.setNormalBackgroundColor(it)
                    }
                    cancelButtonNormalTextColor?.let {
                        customLayout.cancelButton.setNormalTextColor(it)
                    }
                    cancelButtonNormalStrokeColor?.let {
                        customLayout.cancelButton.setNormalStrokeColor(it)
                    }
                    cancelButtonPressedColor?.let {
                        customLayout.cancelButton.setPressedBackgroundColor(it)
                    }
                    cancelButtonPressedTextColor?.let {
                        customLayout.cancelButton.setPressedTextColor(it)
                    }
                    cancelButtonPressedStrokeColor?.let {
                        customLayout.cancelButton.setPressedStrokeColor(it)
                    }
                    confirmButtonRound?.let {
                        customLayout.cancelButton.setRound(it)
                    }

                    confirmButtonRadius?.let {
                        customLayout.cancelButton.setRadius(it)
                    }
                }

                customLayout.confirmButton.text = confirmButtonText

                resource?.let {
                    customLayout.popupIcon.visibility = View.VISIBLE
                    customLayout.popupIcon.setImageResource(it)
                }

                lottieResource?.let {
                    customLayout.popupIcon.visibility = View.GONE
                    customLayout.animation_view.visibility = View.VISIBLE
                    customLayout.animation_view.setAnimation(it)

                    val constraintSet = ConstraintSet()
                    constraintSet.clone(customLayout.parentView)
                    constraintSet.connect(
                        R.id.titleText,
                        ConstraintSet.TOP,
                        R.id.animation_view,
                        ConstraintSet.BOTTOM,
                        0
                    )
                    constraintSet.applyTo(customLayout.parentView)
                }

                lottieLoop?.let {
                    if (it) {
                        customLayout.animation_view.layoutParams.width += 300
                        customLayout.animation_view.layoutParams.height += 25

                        customLayout.animation_view.requestLayout()
                        customLayout.animation_view.loop(true)
                    }
                }

                if (titleText.isNullOrEmpty())
                    customLayout.titleText.visibility = View.GONE
                else
                    customLayout.titleText.text = titleText

                if (contentText.isNullOrEmpty())
                    customLayout.content.visibility = View.GONE
                else
                    customLayout.content.text = contentText

                confirmButtonNormalColor?.let {
                    customLayout.confirmButton.setNormalBackgroundColor(it)
                }
                confirmButtonNormalTextColor?.let {
                    customLayout.confirmButton.setNormalTextColor(it)
                }
                confirmButtonNormalStrokeColor?.let {
                    customLayout.confirmButton.setNormalStrokeColor(it)
                }
                confirmButtonPressedColor?.let {
                    customLayout.confirmButton.setPressedBackgroundColor(it)
                }
                confirmButtonPressedTextColor?.let {
                    customLayout.confirmButton.setPressedTextColor(it)
                }
                confirmButtonPressedStrokeColor?.let {
                    customLayout.confirmButton.setPressedStrokeColor(it)
                }

                confirmButtonRound?.let {
                    customLayout.confirmButton.setRound(it)
                }

                confirmButtonRadius?.let {
                    customLayout.confirmButton.setRadius(it)
                }

                if (cancelButtonText.isNullOrEmpty() && confirmButtonText.isNullOrEmpty()) {
                    customLayout.confirmButton.visibility = View.GONE
                }

                builder.setView(customLayout)
                dialog = builder.create()

                val drawable = DrawableBuilder()
                    .rectangle()
                    .cornerRadius(10)
                    .solidColor(popupBackgroundColor)
                    .build()

                dialog?.window?.setBackgroundDrawable(drawable)
                dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
                dialog?.window?.setGravity(Gravity.CENTER)

                dialog?.setCancelable(false)
                dialog?.setCanceledOnTouchOutside(false)
                dialog?.show()

                if (metrics.density > 2.0) {

                    dialog?.window?.setLayout(
                        smallestScreenSize / 8 * 6,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                } else {

                    dialog?.window?.setLayout(
                        smallestScreenSize / 5 * 3,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                }
            }
        }

        return dialog
    }

}
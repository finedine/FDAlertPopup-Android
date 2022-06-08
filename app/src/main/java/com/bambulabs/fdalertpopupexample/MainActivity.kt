package com.bambulabs.fdalertpopupexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bambulabs.fdalertpopup.FDAlertPopup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCustomPopupWithResource()

    }

    private fun showCustomPopup() {

        FDAlertPopup(this)
            .setTitleText("Title")
            .setContentText("Content")
            .setPopupBackgroundColor(Color.YELLOW)
            .setConfirmButtonText("OK")
            .setConfirmAction { showCustomPopupWithResource() }
            .show()


    }

    private fun showCustomPopupWithLottie() {

        FDAlertPopup(this)
            .setTitleText("Feedback was sent successfully")
            .setLottieResource(R.raw.loading)
            .setLottieLoop(true)
            .show()

    }

    private fun showCustomPopupWithResource() {

        FDAlertPopup(this)
            .setTitleText("1/3")
            .setContentText("Downloading Venue Configurations...")
            .setLottieResource(R.raw.loading)
            .setLottieLoop(true)
            .show()

    }
}

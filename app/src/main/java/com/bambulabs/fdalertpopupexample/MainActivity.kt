package com.bambulabs.fdalertpopupexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bambulabs.fdalertpopup.FDAlertPopup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCustomPopup()

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
            .setLottieResource(R.raw.success2)
            .setPopupBackgroundColor(Color.WHITE)
            .setConfirmAction { showCustomPopupWithResource() }
            .show()

    }

    private fun showCustomPopupWithResource() {

        FDAlertPopup(this)
            .setResource(R.drawable.successicon)
            .setTitleText("Title")
            .setContentText("Content")
            .setConfirmButtonText("Confirm")
            .setCancelButtonText("Cancel")
            .setConfirmAction { showCustomPopupWithLottie() }
            .setCancelAction {  }
            .show()

    }
}

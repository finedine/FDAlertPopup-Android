# FDAlertPopup

[![](https://jitpack.io/v/serhaterfidan/FDAlertPopup.svg)](https://jitpack.io/#serhaterfidan/FDAlertPopup)

![ss1](https://github.com/serhaterfidan/FDAlertPopup/blob/master/screenshots/ss1.png)
![ss2](https://github.com/serhaterfidan/FDAlertPopup/blob/master/screenshots/ss2.png)
![ss3](https://github.com/serhaterfidan/FDAlertPopup/blob/master/screenshots/ss3.png)

## Overview

* Version :1.0
* Minimum SDK Version : Android Jelly Bean API 16 - 4.1
* Target SDK Version : Android Q API 29 - 9.1

* Language : Kotlin

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.serhaterfidan:FDAlertPopup:-SNAPSHOT'
	}

## Usage

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
            .setConfirmButtonText("ConfirmConfirmConfirmConfirm")
            .setConfirmAction { showCustomPopupWithResource() }
            .show()


    }

    private fun showCustomPopupWithLottie() {

        FDAlertPopup(this)
            .setLottieResource(R.raw.success2)
            .setTitleText("Title")
            .setPopupBackgroundColor(Color.BLACK)
            .setContentText("Content")
            .setConfirmButtonText("Try again")
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
	
## Support thanks :

* [Lottie](https://github.com/airbnb/lottie-android)
* [StateButton](https://github.com/niniloveyou/StateButton)

## Developed By

* Serhat Erfidan

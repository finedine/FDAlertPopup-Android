# FDAlertPopup

[![](https://jitpack.io/v/serhaterfidan/FDAlertPopup.svg)](https://jitpack.io/#serhaterfidan/FDAlertPopup)

[![Image from Gyazo](https://i.gyazo.com/f54086aa8cad08cc08f4a3f0b774cba4.gif)](https://gyazo.com/f54086aa8cad08cc08f4a3f0b774cba4)
[![Image from Gyazo](https://i.gyazo.com/192ef001267fa75cfec2732b52811c5f.gif)](https://gyazo.com/192ef001267fa75cfec2732b52811c5f)
[![Image from Gyazo](https://i.gyazo.com/e9928eade508ca4f5eddb91bf5ae8845.gif)](https://gyazo.com/e9928eade508ca4f5eddb91bf5ae8845)

## Overview

* Version :1.0
* Minimum SDK Version : Android Jelly Bean API 16 - 4.1
* Target SDK Version : Android Q API 29 - 9.1

* Language : Kotlin

## How to get

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

## Configurations

    * @param resource // popup custom image resource
    * @param lottieResource // popup custom lottie resource
    * @param titleText // popup title text
    * @param contentText // popup content text
    * @param confirmButtonText // confirm button text
    * @param cancelButtonText // cancel button text
    * @param popupBackgroundColor // popup background color
    * @param confirmButtonNormalColor // confirm button normal color
    * @param confirmButtonNormalTextColor // confirm button normal text color
    * @param confirmButtonNormalStrokeColor // confirm button normal stroke color
    * @param confirmButtonPressedColor // confirm button pressed color
    * @param confirmButtonPressedTextColor // confirm button pressed text color
    * @param confirmButtonPressedStrokeColor // confirm button pressed stroke color
    * @param cancelButtonNormalColor // cancel button normal color
    * @param cancelButtonNormalTextColor // cancel button normal text color
    * @param cancelButtonNormalStrokeColor // cancel button normal stroke color
    * @param cancelButtonPressedColor // cancel button pressed color
    * @param cancelButtonPressedTextColor // cancel button pressed text color
    * @param cancelButtonPressedStrokeColor // cancel button pressed stroke color
    * @param confirmAction // if has try again action as function
    * @param cancelAction // if has dismiss action as function
	
## Support thanks :

* [Lottie](https://github.com/airbnb/lottie-android)
* [StateButton](https://github.com/niniloveyou/StateButton)

## Developed By

* Serhat Erfidan

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)


    Copyright 2019 FDAlertPopup
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

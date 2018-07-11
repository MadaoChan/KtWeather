package com.madaochan.ktweather.utils

import android.os.Build

class SystemUtils {
    companion object {
        inline fun afterLollipop(code: () -> Unit) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                code()
            }
        }
    }
}
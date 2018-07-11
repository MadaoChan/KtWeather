package com.madaochan.ktweather.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.madaochan.ktweather.R
import org.jetbrains.anko.find

class ForecastItemView: ConstraintLayout {

    val iconView: ImageView

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.item_forecast, this)
        iconView = find(R.id.weather_icon)
    }
}
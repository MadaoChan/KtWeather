package com.madaochan.ktweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.madaochan.ktweather.domain.model.ForecastList
import com.madaochan.ktweather.domain.model.WeatherForecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForecastListAdapter(
        private val forecastList: ForecastList,
        private val itemClick: (WeatherForecast) -> Unit) :

        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(TextView(parent.context))
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, null)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return forecastList.size()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(forecastList[position])
    }

    /**
     * ViewHolder(应该定义个好看点的Item)
     */
    class ViewHolder(val view: View, private val itemClick: (WeatherForecast) -> Unit)
        : RecyclerView.ViewHolder(view) {

        // (T) -> Unit是OnClickListener的一个Lambda表现形式
        private val iconView: ImageView = view.find(R.id.weather_icon)
        private val dateView: TextView = view.find(R.id.datetime_text)
        private val descriptionView: TextView = view.find(R.id.weather_description)
        private val maxTempView: TextView = view.find(R.id.max_temp)
        private val minTempView: TextView = view.find(R.id.min_temp)

        fun bindForecast(forecast: WeatherForecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTempView.text = high.toString()
                minTempView.text = low.toString()

                itemView.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}
package com.madaochan.ktweather

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madaochan.ktweather.domain.model.ForecastList
import com.madaochan.ktweather.domain.model.WeatherForecast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import kotlin.properties.Delegates
import kotlin.reflect.KMutableProperty

class ForecastListAdapter(
        private val forecastList: ForecastList,
        private val itemClick: (WeatherForecast) -> Unit) :

        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    var myVal: WeatherForecast by Delegates.observable(forecastList[0]) {
        k, old, new ->
        Log.e(javaClass.simpleName, "$k ${old.date} ${new.date}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
//        private val iconView: ImageView = view.find(R.id.weather_icon)
//        private val dateView: TextView = view.find(R.id.datetime_text)
//        private val descriptionView: TextView = view.find(R.id.weather_description)
//        private val maxTempView: TextView = view.find(R.id.max_temp)
//        private val minTempView: TextView = view.find(R.id.min_temp)

        fun bindForecast(forecast: WeatherForecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(itemView.weather_icon)
                itemView.datetime_text.text = date
                itemView.weather_description.text = description
                itemView.max_temp.text = high.toString()
                itemView.min_temp.text = low.toString()

                itemView.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }
}
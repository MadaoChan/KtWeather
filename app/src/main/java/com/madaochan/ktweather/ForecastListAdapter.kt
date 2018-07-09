package com.madaochan.ktweather

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.madaochan.ktweather.domain.model.ForecastList

class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "${this.date} - ${this.description} - ${this.low} - ${this.high}"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
package com.madaochan.ktweather

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import com.madaochan.ktweather.domain.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    private val items = listOf(
            "7月1日 星期日 晴 17 - 31",
            "7月2日 星期一 雾 8 - 21",
            "7月3日 星期二 多云 17 - 22",
            "7月4日 星期三 雨 11 - 18",
            "7月5日 星期四 雾 10 - 21",
            "7月6日 星期五 雨 10 - 21",
            "7月7日 星期六 晴 7 - 20",
            "7月1日 星期日 晴 17 - 31"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageTextView = findViewById<TextView>(R.id.message)
        messageTextView.text = "Hello"
//        message.text = getString(R.string.app_name)

        val forecastList : RecyclerView = find(R.id.forcast_list)
        forecastList.layoutManager = LinearLayoutManager(this)


        doAsync {
            val result = RequestForecastCommand("Guangzhou").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
//        forecastList.adapter = ensureAdapter()

        toastWithTag("Context.toast")
    }

    fun add(x: Int, y: Int) = x + y

    private fun Context.toastWithTag(message: String, length: Int = Toast.LENGTH_SHORT, tag: String = TAG) {
        Toast.makeText(this, "[$TAG] $message", length).show()
    }
//
//    private fun ensureAdapter(): ForecastListAdapter {
//        doAsync {
//            val result = RequestForecastCommand("94043").execute()
//            uiThread {
//                return@uiThread ForecastListAdapter(result)
//            }
//        }
//    }


}

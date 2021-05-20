package com.example.wakeup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

open class AlarmAdaptor(val context: Context) : RecyclerView.Adapter<AlarmViewHolder>() {

    private var alarmList: ArrayList<Alarm> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        return SimpleAlarmViewHolder(
            LayoutInflater.from(context).inflate(R.layout.alarm_card, parent, false))
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(alarmList[position])
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    fun addAlarm(alarm: Alarm) {
        if (alarm.time != "") {
            alarmList.add(alarm)
            notifyDataSetChanged()
        }
    }

    inner class SimpleAlarmViewHolder(view: View) : AlarmViewHolder(view) {
        private var alarmTitle : TextView = view.findViewById(R.id.alarm_title)
        private var alarmRepeat : TextView = view.findViewById(R.id.alarm_repeat)
        private var alarmTime : TextView = view.findViewById(R.id.alarm_time)
        private var alarmStatus : Switch = view.findViewById(R.id.alarm_status)

        override fun bind(alarm: Alarm) {
            alarmTitle.text = alarm.title
            alarmTime.text = alarm.time
            alarmRepeat.text = alarm.repeat
            alarmStatus.isChecked = alarm.status
        }
    }
}

open class AlarmViewHolder(view: View): RecyclerView.ViewHolder(view) {
    open fun bind(alarm: Alarm) {

    }
}
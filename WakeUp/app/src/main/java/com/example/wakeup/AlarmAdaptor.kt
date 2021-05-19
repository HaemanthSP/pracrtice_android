package com.example.wakeup

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

open class AlarmAdaptor(val context: Context) : RecyclerView.Adapter<AlarmViewHolder>() {

    private var alarmList: ArrayList<com.example.wakeup.Alarm> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(alarmList[position])
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    fun addAlarm(alarm: Alarm) {
        if (alarm.title != "") {
            alarmList.add(alarm)
            notifyDataSetChanged()
        }
    }

    inner class SimpleAlarmViewHolder(view: View) : AlarmViewHolder(view) {
        private var alarmTitle : TextView = view.findViewById(R.id.alarm_title)
        private var alarmDate : TextView = view.findViewById(R.id.alarm_date)
        private var alarmTime : TextView = view.findViewById(R.id.alarm_time)
    }

}

open class AlarmViewHolder(view: View): RecyclerView.ViewHolder(view) {
    open fun bind(alarm: com.example.wakeup.Alarm) {

    }
}
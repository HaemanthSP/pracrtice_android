package com.example.wakeup

import java.sql.Time
import java.util.*

data class Alarm(val time: Time, val status: Boolean, val repeat: String, val title: String)

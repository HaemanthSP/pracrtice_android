package com.example.wakeup

import java.io.Serializable

data class Alarm(val time: String, val status: Boolean, val repeat: String, val title: String) :
    Serializable

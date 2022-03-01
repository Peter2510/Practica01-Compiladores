package com.peter.practica01.reportes

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.peter.practica01.R

class SinError: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.sin_error)
        println("eNTRO AL SIN ERROR XD")
    }
}
package com.example.pokdex

import android.app.Application
import com.example.pokdex.data.AppContainter

class PokedexApplication: Application() {

    lateinit var container: AppContainter

    override fun onCreate() {
        super.onCreate()
        container = AppContainter()
    }
}
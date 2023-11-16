package com.example.unitconverter

import android.app.Application
import com.example.unitconverter.di.DefaultUnitConverterDataModule
import com.example.unitconverter.di.UnitConverterDataModule

class UnitConverterApp: Application() {
    lateinit var dataModule: UnitConverterDataModule
    override fun onCreate() {
        super.onCreate()
        dataModule = DefaultUnitConverterDataModule()
    }
}
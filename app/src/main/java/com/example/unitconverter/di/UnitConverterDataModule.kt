package com.example.unitconverter.di

import com.example.unitconverter.data.UnitConverterRepositoryImpl
import com.example.unitconverter.domain.UnitConverterRepository

interface UnitConverterDataModule {
    val unitConverterRepository: UnitConverterRepository
}
class DefaultUnitConverterDataModule: UnitConverterDataModule {
    override val unitConverterRepository: UnitConverterRepository by lazy {
        UnitConverterRepositoryImpl()
    }
}

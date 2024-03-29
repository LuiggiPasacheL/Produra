package com.example.produra.di

import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.infrastructure.dao.UnitDao
import com.example.produra.infrastructure.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BindDao {
    @Singleton
    @Provides
    fun bindProductDao(db: AppDatabase): ProductDao = db.productDao()

    @Singleton
    @Provides
    fun bindUnitDao(db: AppDatabase): UnitDao = db.unitDao()
}
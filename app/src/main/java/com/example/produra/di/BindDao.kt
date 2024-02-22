package com.example.produra.di

import android.content.Context
import androidx.room.Room
import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.infrastructure.dao.UnitDao
import com.example.produra.infrastructure.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BindDao {
    @Singleton
    @Provides
    fun bindProductDao(@ApplicationContext context: Context): ProductDao {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "products"
        ).build()

        return db.productDao()
    }

    @Singleton
    @Provides
    fun bindUnitDao(@ApplicationContext context: Context): UnitDao {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "units"
        ).build()

        return db.unitDao()
    }
}
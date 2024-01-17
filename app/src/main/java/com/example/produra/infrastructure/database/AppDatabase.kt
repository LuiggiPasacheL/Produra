package com.example.produra.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.infrastructure.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}

package com.example.produra.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.infrastructure.dao.UnitDao
import com.example.produra.infrastructure.entities.ProductEntity
import com.example.produra.infrastructure.entities.UnitEntity

@Database(entities = [ProductEntity::class, UnitEntity::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun unitDao(): UnitDao
}

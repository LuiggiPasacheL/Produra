package com.example.produra.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.produra.infrastructure.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BindAppDatabase {

    private val INSERT_DEFAULT_UNITS_MIGRATION = object : Migration(2, 3) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("INSERT INTO units (unitId, measure) VALUES (1, 'Kilogramo')")
            db.execSQL("INSERT INTO units (unitId, measure) VALUES (2, 'Unidad')")
        }
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "produra_database"
        )
            .addMigrations(INSERT_DEFAULT_UNITS_MIGRATION)
            .build()
    }
}
package com.example.produra.di

import com.example.produra.infrastructure.repositories.ProductRepositoryImpl
import com.example.produra.infrastructure.repositories.UnitRepositoryImpl
import com.example.produra.useCase.products.ProductRepository
import com.example.produra.useCase.units.UnitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindRepositories {
    @Binds
    abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository

    @Binds
    abstract fun bindUnitRepository(unitRepositoryImpl: UnitRepositoryImpl): UnitRepository
}
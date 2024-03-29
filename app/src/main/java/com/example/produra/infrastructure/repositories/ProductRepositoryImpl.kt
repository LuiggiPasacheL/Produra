package com.example.produra.infrastructure.repositories

import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.infrastructure.entities.ProductEntity
import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {
    override suspend fun save(p: Product, unitId: Int) {
        if (p.productId == null) {
            val productEntity = ProductEntity.fromProduct(p, unitId)
            productDao.addProduct(productEntity)
            return
        }
        val productEntity = ProductEntity.fromProduct(p, unitId)
        productDao.updateProduct(productEntity)
    }

    override suspend fun getById(id: Int): Product? {
        return productDao.getProductWithUnit(id)?.toProduct()
    }

    override suspend fun getByName(name: String): Product? {
        return productDao.getProductWithUnitByName(name)?.toProduct()
    }

    override suspend fun getAll(): List<Product> {
        return productDao.getProductsWithUnit().map { productEntity -> productEntity.toProduct() }
    }

    override suspend fun getCart(): List<Product> {
        return productDao.getProductsWithUnitMustBePurchased().map { productEntity -> productEntity.toProduct() }
    }

    override suspend fun getProductWithUnit(id: Int): Product? {
        return productDao.getProductWithUnit(id)?.toProduct()
    }
}
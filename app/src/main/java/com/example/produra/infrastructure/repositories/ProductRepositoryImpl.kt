package com.example.produra.infrastructure.repositories

import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.infrastructure.entities.ProductEntity
import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {
    override suspend fun save(p: Product) {
        if (p.id == null) {
            val productEntity = ProductEntity.fromProduct(p)
            productDao.addProduct(productEntity)
            return
        }

        val productEntity = productDao.getProductById(id = p.id) ?: return
        val newProductEntity = productEntity.copy(id = p.id)
        productDao.updateProduct(newProductEntity)
    }

    override suspend fun getById(id: Int): Product? {
        return productDao.getProductById(id)?.toProduct()
    }

    override suspend fun getByName(name: String): Product? {
        return productDao.getProductByName(name)?.toProduct()
    }

    override suspend fun getAll(): List<Product> {
        return productDao.getProducts().map { productEntity -> productEntity.toProduct() }
    }

}
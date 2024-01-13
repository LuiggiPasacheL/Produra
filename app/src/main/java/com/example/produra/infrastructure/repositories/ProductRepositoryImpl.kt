package com.example.produra.infrastructure.repositories

import com.example.produra.infrastructure.dao.ProductDao
import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository

class ProductRepositoryImpl(
    private val productDao: ProductDao
): ProductRepository {
    override suspend fun save(p: Product) {
        if (p.id == null) {
            productDao.addProduct(p)
            return
        }

        val product = productDao.getProductById(p.id) ?: return
        val newProduct = p.copy(id=product.id)
        productDao.updateProduct(newProduct)
    }

    override suspend fun getById(id: Int): Product? {
        return productDao.getProductById(id)
    }

    override suspend fun getByName(name: String): Product? {
        return productDao.getProductByName(name)
    }

    override suspend fun getAll(): List<Product> {
        return productDao.getProducts()
    }

}
package com.example.ayurvedahouseassesment.data.repository

import androidx.lifecycle.LiveData
import com.example.ayurvedahouseassesment.data.local.ShoppingDao
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.domain.repository.ShoppingRepository
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val shoppingDao: ShoppingDao
) : ShoppingRepository {
    override suspend fun createItem(item: ShoppingItem) {
        shoppingDao.insert(item)
    }

    override fun getAllItem(): LiveData<List<ShoppingItem>> {
        return shoppingDao.getCartItemList()
    }

    override fun getItemInCartItem(): LiveData<List<ShoppingItem>> {
        return shoppingDao.getItemInCart()
    }

    override suspend fun deleteItem(item: ShoppingItem) {
        shoppingDao.delete(item)
    }

    override suspend fun updateItem(item: ShoppingItem) {
        shoppingDao.update(item)
    }

    override fun getCartCount(): LiveData<Int> {
        return shoppingDao.getCartItemCount()
    }

    override fun getItem(id: String): LiveData<ShoppingItem> {
        return shoppingDao.getItemUsingId(id)
    }


}
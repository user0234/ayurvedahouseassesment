package com.example.ayurvedahouseassesment.domain.repository

import androidx.lifecycle.LiveData
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem

interface ShoppingRepository {

    suspend fun createItem(item: ShoppingItem)

    fun getAllItem(): LiveData<List<ShoppingItem>>

    fun getItemInCartItem(): LiveData<List<ShoppingItem>>

    suspend fun deleteItem(item: ShoppingItem)

    suspend fun updateItem(item: ShoppingItem)

    fun getCartCount(): LiveData<Int>

    fun getItem(id: String): LiveData<ShoppingItem>

}
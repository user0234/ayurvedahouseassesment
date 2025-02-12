package com.example.ayurvedahouseassesment.domain.use_cases.shopping

import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.domain.repository.ShoppingRepository
import javax.inject.Inject

class DeleteShoppingItem @Inject constructor(
    private val repository: ShoppingRepository
) {

    suspend operator fun invoke(shoppingItem: ShoppingItem) {
        repository.deleteItem(shoppingItem)
    }

}
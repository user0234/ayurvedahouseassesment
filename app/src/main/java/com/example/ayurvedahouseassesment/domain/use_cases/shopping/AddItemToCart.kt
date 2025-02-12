package com.example.ayurvedahouseassesment.domain.use_cases.shopping

import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.domain.repository.ShoppingRepository
import javax.inject.Inject


class AddItemToCart @Inject constructor(
    private val repository: ShoppingRepository
) {

    suspend operator fun invoke(shoppingItem: ShoppingItem) {

        shoppingItem.cartCount++
        repository.updateItem(shoppingItem)

    }

}
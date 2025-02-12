package com.example.ayurvedahouseassesment.domain.use_cases.shopping

import androidx.lifecycle.LiveData
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.domain.repository.ShoppingRepository
import javax.inject.Inject

class GetCartItems @Inject constructor(
    private val repository: ShoppingRepository
) {

    operator fun invoke(): LiveData<List<ShoppingItem>> {
        return repository.getItemInCartItem()
    }

}
package com.example.ayurvedahouseassesment.domain.use_cases.shopping

import androidx.lifecycle.LiveData
import com.example.ayurvedahouseassesment.domain.repository.ShoppingRepository
import javax.inject.Inject

class GetCartItemCount @Inject constructor(
    private val repository: ShoppingRepository
) {

    operator fun invoke(): LiveData<Int> {
        return repository.getCartCount()
    }

}
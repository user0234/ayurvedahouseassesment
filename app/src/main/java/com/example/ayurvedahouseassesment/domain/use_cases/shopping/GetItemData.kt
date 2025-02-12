package com.example.ayurvedahouseassesment.domain.use_cases.shopping

import androidx.lifecycle.LiveData
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.domain.repository.ShoppingRepository
import javax.inject.Inject


class GetItemData @Inject constructor(
    private val repository: ShoppingRepository
) {

    operator fun invoke(id: String):
            LiveData<ShoppingItem> {

       return repository.getItem(id)

    }

}
package com.example.ayurvedahouseassesment.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.AddItemToCart
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.DeleteShoppingItem
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.GetAllShoppingItems
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.GetCartItemCount
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.GetCartItems
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.GetItemData
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.RemoveItemFromCart
import com.example.ayurvedahouseassesment.domain.use_cases.shopping.SaveShoppingItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addItemToCartUseCase: AddItemToCart,
    private val deleteItemUseCase: DeleteShoppingItem,
    getShoppingItemsUseCase: GetAllShoppingItems,
    getCartItemCountUseCase: GetCartItemCount,
    getCartItemsUseCase: GetCartItems,
    private val removeItemCartUseCase: RemoveItemFromCart,
    private val saveShoppingItemUseCase: SaveShoppingItem,
    private val getItemUseCase: GetItemData
) : ViewModel() {

    val shoppingItems = getShoppingItemsUseCase()
    val cartItems = getCartItemsUseCase()
    val cartItemCount = getCartItemCountUseCase()

    fun saveItem(item: ShoppingItem) {
        viewModelScope.launch {
            saveShoppingItemUseCase(item)
        }

    }

    fun addToCart(item: ShoppingItem) {
        viewModelScope.launch {
            addItemToCartUseCase(item)
        }

    }

    fun removeFromCart(item: ShoppingItem) {
        viewModelScope.launch {
            removeItemCartUseCase(item)
        }

    }

    fun getItemLive(id: String)
        = getItemUseCase(id)


}
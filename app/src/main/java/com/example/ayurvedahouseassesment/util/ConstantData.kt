package com.example.ayurvedahouseassesment.util

import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import java.util.UUID

object ConstantData {

    val item1 = ShoppingItem(
        id = "4",
        name = "Berkely",
        price = 100,
        cartCount = 0,
        imageUrl = "https://plus.unsplash.com/premium_photo-1678739395192-bfdd13322d34?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )

    val item2 = ShoppingItem(
        id = "3",
        name = "kohlmarkt",
        price = 200,
        cartCount = 0,
        imageUrl = "https://images.unsplash.com/photo-1584917865442-de89df76afd3?q=80&w=1935&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )

    val item3 = ShoppingItem(
        id = "2",
        name = "innere stadt",
        price = 200,
        cartCount = 0,
        imageUrl = "https://images.unsplash.com/photo-1590874103328-eac38a683ce7?q=80&w=1938&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    )

    val item4 = ShoppingItem(
        id = "1",
        name = "tote bag",
        price = 200,
        cartCount = 0,
        imageUrl = "https://plus.unsplash.com/premium_photo-1681498856888-2f3552c0b189?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

    )

    fun getCartItem() = listOf(item1, item2, item3, item4)

}
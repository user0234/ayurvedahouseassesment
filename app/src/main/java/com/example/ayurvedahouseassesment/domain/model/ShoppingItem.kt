package com.example.ayurvedahouseassesment.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @PrimaryKey()
    val id: String,
    val name: String,
    val price: Int,
    val imageUrl: String,
    var cartCount: Int = 0,
    var details: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer hendrerit, diam eget porttitor auctor, felis felis egestas sapien, sit amet egestas sapien arcu ac tortor. Proin convallis diam eget nulla rutrum, eu faucibus dolor sodales. Etiam varius nisl diam, sit amet imperdiet est condimentum at. Pellentesque pharetra laoreet enim eget sodales. Ut at elit non mi cursus ornare eu eu nisl. Nam ut auctor arcu. Sed lectus tortor, efficitur vitae scelerisque sollicitudin, dictum eu tellus. Donec pretium justo vitae purus efficitur tristique. Suspendisse sit amet dui leo. Nullam dictum pellentesque nibh in ornare. Phasellus vel lacus a nulla vehicula iaculis.",
    var materialDetails: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer hendrerit, diam eget porttitor auctor, felis felis egestas sapien, sit amet egestas sapien arcu ac tortor. Proin convallis diam eget nulla rutrum, eu faucibus dolor sodales. Etiam varius nisl diam, sit amet imperdiet est condimentum at. Pellentesque pharetra laoreet enim eget sodales. Ut at elit non mi cursus ornare eu eu nisl. Nam ut auctor arcu. Sed lectus tortor, efficitur vitae scelerisque sollicitudin, dictum eu tellus. Donec pretium justo vitae purus efficitur tristique. Suspendisse sit amet dui leo. Nullam dictum pellentesque nibh in ornare. Phasellus vel lacus a nulla vehicula iaculis."
): Parcelable

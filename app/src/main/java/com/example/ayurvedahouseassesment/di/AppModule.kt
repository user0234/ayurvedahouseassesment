package com.example.ayurvedahouseassesment.di

import android.app.Application
import androidx.room.Room
import com.example.ayurvedahouseassesment.data.local.ShoppingDao
import com.example.ayurvedahouseassesment.data.local.ShoppingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShoppingDatabase(
        application: Application
    ): ShoppingDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = ShoppingDatabase::class.java,
            name = "shopping_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideShoppingDao(
        shoppingDatabase: ShoppingDatabase
    ): ShoppingDao = shoppingDatabase.shoppingDao

}
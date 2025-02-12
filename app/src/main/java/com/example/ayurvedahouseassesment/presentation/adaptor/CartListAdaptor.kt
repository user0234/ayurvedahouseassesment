package com.example.ayurvedahouseassesment.presentation.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ayurvedahouseassesment.R
import com.example.ayurvedahouseassesment.databinding.ShoppingItemLayoutBinding
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem


class CartListAdaptor : RecyclerView.Adapter<CartListAdaptor.CartListViewHolder>() {

    inner class CartListViewHolder(val binding: ShoppingItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    // for faster change in view
    private val differCallBack = object : DiffUtil.ItemCallback<ShoppingItem>() {
        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.id == newItem.id && oldItem.cartCount == newItem.cartCount
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem == newItem
        }

    }

    val cartDiffer = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CartListAdaptor.CartListViewHolder {
        return CartListViewHolder(
            ShoppingItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartListAdaptor.CartListViewHolder, position: Int) {

        val binding = holder.binding
        val itemCurrent = cartDiffer.currentList[position]

        binding.titleTv.text = itemCurrent.name
        binding.countBt.text = itemCurrent.cartCount.toString()
        binding.itemPriceTv.text = "$ ${itemCurrent.price}"

        if (itemCurrent.cartCount > 0) {

            binding.itemCount.visibility = View.VISIBLE
            binding.addToCartBt.visibility = View.GONE

        } else {
            binding.itemCount.visibility = View.GONE
            binding.addToCartBt.visibility = View.VISIBLE

        }

        Glide
            .with(binding.imageIv)
            .load(itemCurrent.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.iv_place_holder)
            .into(binding.imageIv)


        binding.addToCartBt.setOnClickListener {

            onItemAddedListener?.let {
                it(itemCurrent, position)
            }
        }

        binding.addBt.setOnClickListener {

            onItemAddedListener?.let {
                it(itemCurrent, position)
            }
        }

        binding.removeBt.setOnClickListener {

            onItemRemovedListener?.let {
                it(itemCurrent, position)
            }

        }

        binding.root.setOnClickListener {
            onItemClickListener?.let {
                it(itemCurrent)
            }
        }


    }

    override fun getItemCount(): Int {
        return cartDiffer.currentList.size
    }

    private var onItemAddedListener: ((ShoppingItem, Int) -> Unit)? = null

    fun setOnItemAddedListener(listener: (ShoppingItem, Int) -> Unit) {
        onItemAddedListener = listener
    }

    private var onItemRemovedListener: ((ShoppingItem, Int) -> Unit)? = null

    fun setOnItemRemovedListener(listener: (ShoppingItem, Int) -> Unit) {
        onItemRemovedListener = listener
    }

    private var onItemClickListener: ((ShoppingItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (ShoppingItem) -> Unit) {
        onItemClickListener = listener
    }


}
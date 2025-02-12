package com.example.ayurvedahouseassesment.presentation.screens.detailScreen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.ayurvedahouseassesment.R
import com.example.ayurvedahouseassesment.databinding.FragmentDetailScreenBinding
import com.example.ayurvedahouseassesment.domain.model.ShoppingItem
import com.example.ayurvedahouseassesment.presentation.screens.MainViewModel
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.ExperimentalBadgeUtils


class DetailScreen : Fragment(R.layout.fragment_detail_screen) {

    val viewModel: MainViewModel by activityViewModels()

    lateinit var binding: FragmentDetailScreenBinding

    val args: DetailScreenArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailScreenBinding.bind(view)

        viewModel.getItemLive(args.shoppingItem.id).observe(viewLifecycleOwner) {
            setUpDataItem(it)
        }

        binding.toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.actionNotifications -> {
                    findNavController().navigate(R.id.action_detailScreen_to_cartScreen)
                    true
                }

                else -> false
            }
        }

        viewModel.shoppingItems.observe(viewLifecycleOwner) {

            val sum = it.sumOf { it.cartCount }

            setUpCartItemCount(sum)

        }

    }

    @OptIn(ExperimentalBadgeUtils::class)
    private fun setUpCartItemCount(sum: Int) {

        val badgeDrawable = BadgeDrawable.create(requireContext()).apply {
            isVisible = true
            backgroundColor = Color.parseColor("#FF0000")
            number = sum
            maxNumber = 999
        }
        BadgeUtils.attachBadgeDrawable(badgeDrawable, binding.toolBar, R.id.actionNotifications)

    }

    private fun setUpDataItem(item: ShoppingItem) {

        binding.toolBar.title = item.name

        if (item.cartCount > 0) {

            binding.itemCount.visibility = View.VISIBLE
            binding.addToCartBt.visibility = View.GONE

        } else {
            binding.itemCount.visibility = View.GONE
            binding.addToCartBt.visibility = View.VISIBLE

        }

        binding.apply {
            titleTv.text = item.name
            priceTv.text = "$ ${item.price}"
            detailDescTv.text = item.details
            materialDescTv.text = item.materialDetails
        }

        binding.addToCartBt.setOnClickListener {

            viewModel.addToCart(item)
        }

        binding.addBt.setOnClickListener {

            viewModel.addToCart(item)
        }

        binding.removeBt.setOnClickListener {

            viewModel.removeFromCart(item)

        }

        binding.countBt.text = item.cartCount.toString()

        Glide
            .with(binding.imageIv)
            .load(item.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.iv_place_holder)
            .into(binding.imageIv)

    }

    companion object {

        val DETAIL_ARG = "shoppingItem"

    }

}
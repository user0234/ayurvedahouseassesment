package com.example.ayurvedahouseassesment.presentation.screens.homeScreen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayurvedahouseassesment.R
import com.example.ayurvedahouseassesment.databinding.FragmentHomeScreenBinding
import com.example.ayurvedahouseassesment.presentation.adaptor.CartListAdaptor
import com.example.ayurvedahouseassesment.presentation.screens.MainViewModel
import com.example.ayurvedahouseassesment.presentation.screens.detailScreen.DetailScreen
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.ExperimentalBadgeUtils


class HomeScreen : Fragment(R.layout.fragment_home_screen) {

    lateinit var binding: FragmentHomeScreenBinding
    val viewModel: MainViewModel by activityViewModels()
    private lateinit var cartAdaptor: CartListAdaptor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeScreenBinding.bind(view)

        binding.toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.actionNotifications -> {
                    findNavController().navigate(R.id.action_homeScreen_to_cartScreen)
                    true
                }

                else -> false
            }
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {

        cartAdaptor = CartListAdaptor()

        binding.itemListRv.apply {
            adapter = cartAdaptor
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(false)
        }

        cartAdaptor.setOnItemAddedListener { item, i ->

            viewModel.addToCart(item)
            cartAdaptor.notifyItemChanged(i)

        }

        cartAdaptor.setOnItemRemovedListener { item, i ->

            viewModel.removeFromCart(item)
            cartAdaptor.notifyItemChanged(i)
        }

        cartAdaptor.setOnItemClickListener {

            val bundle = Bundle().apply {
                putParcelable(DetailScreen.DETAIL_ARG, it)
            }

            findNavController().navigate(
                R.id.action_homeScreen_to_detailScreen, bundle
            )

        }

        viewModel.shoppingItems.observe(viewLifecycleOwner) {

            cartAdaptor.cartDiffer.submitList(it)

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

}
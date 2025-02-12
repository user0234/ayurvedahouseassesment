package com.example.ayurvedahouseassesment.presentation.screens.cartScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayurvedahouseassesment.R
import com.example.ayurvedahouseassesment.databinding.FragmentCartScreenBinding
import com.example.ayurvedahouseassesment.presentation.adaptor.CartListAdaptor
import com.example.ayurvedahouseassesment.presentation.screens.MainViewModel
import com.example.ayurvedahouseassesment.presentation.screens.detailScreen.DetailScreen


class CartScreen : Fragment(R.layout.fragment_cart_screen) {

    lateinit var binding: FragmentCartScreenBinding
    val viewModel: MainViewModel by activityViewModels()
    private lateinit var cartAdaptor: CartListAdaptor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartScreenBinding.bind(view)
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

        viewModel.cartItems.observe(viewLifecycleOwner) {

            cartAdaptor.cartDiffer.submitList(it)

        }

    }



}
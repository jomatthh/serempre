package com.jomatt.serempreapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jomatt.serempreapp.R
import com.jomatt.serempreapp.core.BaseFragment
import com.jomatt.serempreapp.databinding.FragmentPostBinding
import com.jomatt.serempreapp.ui.adapter.PostAdapter

class PostFragment : BaseFragment<FragmentPostBinding>(FragmentPostBinding::inflate) {

    private val adapter by lazy {
        PostAdapter(emptyList())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.rvPost.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPost.adapter = adapter
        binding.rvPost.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}
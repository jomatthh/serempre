package com.jomatt.serempreapp.ui.fragment.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jomatt.serempreapp.core.BaseFragment
import com.jomatt.serempreapp.databinding.FragmentPostFavoriteBinding
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.ui.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostFavoriteFragment : BaseFragment<FragmentPostFavoriteBinding>(FragmentPostFavoriteBinding::inflate), PostAdapter.OnPostListener  {

    private val viewModel: PostViewModel by viewModels()
    private val adapter by lazy {
        PostAdapter(requireContext(), emptyList(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
    }
    private fun setupObservers(){
        viewModel.fetchFavoritePostLocal.observe(viewLifecycleOwner,{
            adapter.update(it)
        })
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


    override fun onItemClick(item: Post) {
    }
}
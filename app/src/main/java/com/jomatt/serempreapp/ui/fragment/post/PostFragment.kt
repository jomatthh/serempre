package com.jomatt.serempreapp.ui.fragment.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jomatt.serempreapp.core.BaseFragment
import com.jomatt.serempreapp.databinding.FragmentPostBinding
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.showToast
import com.jomatt.serempreapp.ui.adapter.PostAdapter
import com.jomatt.serempreapp.vo.OperationResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFragment : BaseFragment<FragmentPostBinding>(FragmentPostBinding::inflate),
    PostAdapter.OnPostListener {

    private val viewModel: PostViewModel by viewModels()

    private val adapter by lazy {
        PostAdapter(requireContext(), emptyList(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.fetchPosts.observe(viewLifecycleOwner, { result ->
            when (result) {
                is OperationResult.Success -> {
                    adapter.update(result.data)
                }
                is OperationResult.Failure -> {
                    requireContext().showToast(result.exception.message)
                }
            }
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
        val action = PostFragmentDirections.actionPostFragmentToPostDetailFragment(item.userId)
        findNavController().navigate(action)
    }
}
package com.jomatt.serempreapp.ui.fragment.post

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jomatt.serempreapp.R
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
        setHasOptionsMenu(true)
        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.fetchAllPostLocal.observe(viewLifecycleOwner, {
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuRemove) {
            adapter.update(emptyList())
        }
        return true
    }

    override fun onItemClick(item: Post) {
        val action = PostFragmentDirections.actionPostFragmentToPostDetailFragment(item)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater = requireActivity().menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
    }
}
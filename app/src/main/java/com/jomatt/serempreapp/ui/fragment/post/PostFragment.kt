package com.jomatt.serempreapp.ui.fragment.post

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jomatt.serempreapp.R
import com.jomatt.serempreapp.core.BaseFragment
import com.jomatt.serempreapp.databinding.FragmentPostBinding
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.ui.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostFragment : BaseFragment<FragmentPostBinding>(FragmentPostBinding::inflate),
    PostAdapter.OnPostListener {


    private val viewModel: PostViewModel by viewModels()
    private lateinit var posts : List<Post>

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
            posts = it
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

        val mIth = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: ViewHolder, target: ViewHolder
                ): Boolean {
                    return true // true if moved, false otherwise
                }

                override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val item = posts[position]
                    adapter.update( posts.filter { it.id!=item.id } )
                }
            })
        mIth.attachToRecyclerView(binding.rvPost)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuRemove) {
            adapter.update(emptyList())
        }
        return true
    }

    override fun onItemClick(item: Post) {
        Log.d("TAG","Lol")
        val action = PostFragmentDirections.actionPostFragmentToPostDetailFragment(item)
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater = requireActivity().menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
    }
}
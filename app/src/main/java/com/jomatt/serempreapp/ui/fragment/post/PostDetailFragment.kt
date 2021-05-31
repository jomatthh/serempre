package com.jomatt.serempreapp.ui.fragment.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jomatt.serempreapp.R
import com.jomatt.serempreapp.core.BaseFragment
import com.jomatt.serempreapp.databinding.FragmentPostDetailBinding
import com.jomatt.serempreapp.domain.model.User
import com.jomatt.serempreapp.showToast
import com.jomatt.serempreapp.vo.OperationResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment :
    BaseFragment<FragmentPostDetailBinding>(FragmentPostDetailBinding::inflate) {

    private val viewModel: PostViewModel by viewModels()

    private var idUser: Int = 0
    private val args: PostDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idUser = args.userId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getUserById(idUser).observe(viewLifecycleOwner, { result ->
            when (result) {
                is OperationResult.Success -> {
                    setData(result.data)
                }
                is OperationResult.Failure -> {
                    requireContext().showToast(result.exception.message)
                }
            }
        })
    }

    private fun setData(user: User) {
        with(binding) {
            tvName.text = user.name
            tvEmail.text = user.email
            tvUsername.text = user.username
        }
    }
}
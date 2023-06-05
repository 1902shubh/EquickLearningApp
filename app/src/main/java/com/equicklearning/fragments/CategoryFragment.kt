package com.equicklearning.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.equicklearning.adapter.CategoryAdapter
import com.equicklearning.databinding.FragmentCategoryBinding
import com.equicklearning.interfaces.CategoryClick
import com.equicklearning.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment(), CategoryClick {

    private lateinit var binding: FragmentCategoryBinding


    private val postViewModel by viewModels<PostViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCategoryBinding.inflate(layoutInflater)


        postViewModel.getCategory()

        postViewModel.categoryLiveData.observe(requireActivity()) {
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.adapter = CategoryAdapter(
                requireContext(), it.data!!, this
            )

        }




        return binding.root
    }

    override fun onCategoryClick(category: String) {

        val direction =
            CategoryFragmentDirections.actionCategoryFragmentToCategoryPostFragment(category)

        findNavController().navigate(direction)
    }

}
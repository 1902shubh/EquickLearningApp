package com.equicklearning.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.equicklearning.adapter.PostAdapter
import com.equicklearning.databinding.FragmentHomeBinding
import com.equicklearning.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CategoryPostFragment : Fragment() {


    private lateinit var binding : FragmentHomeBinding
    private val args : CategoryPostFragmentArgs by navArgs()


    private val postViewModel by viewModels<PostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment


        postViewModel.getCategoryByPost(args.category!!)


        postViewModel.postLiveData.observe(requireActivity()){
            Log.d("SHUBH", "onCreateView: ${it.data}")

            binding.progressBar.visibility = View.GONE
            binding.recyclerView.adapter = PostAdapter(requireContext(), it.data!!)

        }


        return binding.root
    }




}
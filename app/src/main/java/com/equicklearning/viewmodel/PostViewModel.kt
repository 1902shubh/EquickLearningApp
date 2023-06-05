package com.equicklearning.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equicklearning.models.category.CategoryModel
import com.equicklearning.models.post.PostModel
import com.equicklearning.repository.PostRepository
import com.equicklearning.utils.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    val postLiveData : LiveData<NetworkResults<PostModel>>
        get() = postRepository.postLiveData

    val categoryLiveData : LiveData<NetworkResults<CategoryModel>>
        get() = postRepository.categoryLiveData

    fun getPost(){
        viewModelScope.launch {
            postRepository.getPost()
        }
    }


    fun getCategory(){
        viewModelScope.launch {
            postRepository.getCategory()
        }
    }


    fun getCategoryByPost(categoryId : String){
        viewModelScope.launch {
            postRepository.getPostByCategory(categoryId)
        }
    }



}
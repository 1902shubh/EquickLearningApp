package com.equicklearning.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.equicklearning.di.ApiInterface
import com.equicklearning.models.category.CategoryModel
import com.equicklearning.models.post.PostModel
import com.equicklearning.utils.NetworkResults
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    private val _postLiveData = MutableLiveData<NetworkResults<PostModel>>()
    val postLiveData : LiveData<NetworkResults<PostModel>>
        get() = _postLiveData

    private val _categoryLiveData = MutableLiveData<NetworkResults<CategoryModel>>()
    val categoryLiveData : LiveData<NetworkResults<CategoryModel>>
        get() = _categoryLiveData


    suspend fun getPost() {
        val res = apiInterface.getPost()


        if (res.isSuccessful && res.body() != null){
            _postLiveData.postValue(NetworkResults.SUCCESS(res.body()))

        }else if (res.errorBody() != null){
            _postLiveData.postValue(NetworkResults.ERROR(message = "Something went wrong."))
        }else{
            _postLiveData.postValue(NetworkResults.ERROR(message = "Something went wrong."))

        }



    }


    suspend fun getPostByCategory(categoryId : String) {
        val res = apiInterface.getPostByCategory(categoryId)


        if (res.isSuccessful && res.body() != null){
            _postLiveData.postValue(NetworkResults.SUCCESS(res.body()))

        }else if (res.errorBody() != null){
            _postLiveData.postValue(NetworkResults.ERROR(message = "Something went wrong."))
        }else{
            _postLiveData.postValue(NetworkResults.ERROR(message = "Something went wrong."))

        }



    }


    suspend fun getCategory() {
        val res = apiInterface.getCategory()


        if (res.isSuccessful && res.body() != null){
            _categoryLiveData.postValue(NetworkResults.SUCCESS(res.body()))

        }else if (res.errorBody() != null){
            _categoryLiveData.postValue(NetworkResults.ERROR(message = "Something went wrong."))
        }else{
            _categoryLiveData.postValue(NetworkResults.ERROR(message = "Something went wrong."))

        }



    }


}
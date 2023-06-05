package com.equicklearning.di

import com.equicklearning.models.category.CategoryModel
import com.equicklearning.models.post.PostModel
import com.equicklearning.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {



    @GET(Constants.END_POINT+Constants.POST)
    suspend fun getPost() : Response<PostModel>


    @GET(Constants.END_POINT+Constants.CATEGORY)
    suspend fun getCategory() : Response<CategoryModel>


    @GET(Constants.END_POINT+Constants.POST)
    suspend fun getPostByCategory(
        @Query(Constants.CATEGORY) category : String
    ) : Response<PostModel>



}
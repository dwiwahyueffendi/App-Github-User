package com.example.githubuser.network

import com.example.githubuser.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserService {
    @GET("search/users")
    @Headers("Authorization: token caf8f67493058a15d4cddcb5badb07945ec6fda4")
    fun getSearchUsers( @Query("q") query: String) : Call<UserResponse>
}
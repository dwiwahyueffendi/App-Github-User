package com.example.githubuser.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubuser.data.DetailUserRespone
import com.example.githubuser.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel: ViewModel() {
    val user = MutableLiveData<DetailUserRespone>()

    fun setUserDetail(username: String){
        RetrofitClient.getUser()
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUserRespone>{
                override fun onResponse(
                    call: Call<DetailUserRespone>,
                    response: Response<DetailUserRespone>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUserRespone>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }

    fun getUserDetail(): LiveData<DetailUserRespone>{
        return user
    }
}
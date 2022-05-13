package sopt.android.assignment.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sopt.android.assignment.data.remote.service.LoginService

object RetrofitBuilder {
    private const val BASE_URL = "http://13.124.62.236/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService: LoginService = retrofit.create(LoginService::class.java)
}

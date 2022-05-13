package sopt.android.assignment.data.remote.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import sopt.android.assignment.data.remote.entity.request.SignInRequest
import sopt.android.assignment.data.remote.entity.request.SignUpRequest
import sopt.android.assignment.data.remote.entity.response.SignInResponse
import sopt.android.assignment.data.remote.entity.response.SignUpResponse

interface LoginService {
    @POST("auth/signin")
    fun postSignIn(
        @Body body: SignInRequest,
    ): Call<SignInResponse>

    @POST("auth/signup")
    fun postSignUp(
        @Body body: SignUpRequest,
    ): Call<SignUpResponse>
}

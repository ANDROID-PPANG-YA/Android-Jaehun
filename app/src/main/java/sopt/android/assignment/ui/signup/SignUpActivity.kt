package sopt.android.assignment.ui.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sopt.android.assignment.R
import sopt.android.assignment.data.remote.RetrofitBuilder
import sopt.android.assignment.data.remote.entity.request.SignUpRequest
import sopt.android.assignment.data.remote.entity.response.SignUpResponse
import sopt.android.assignment.databinding.ActivitySignUpBinding
import sopt.android.assignment.ui.base.BaseActivity
import sopt.android.assignment.ui.signin.SignInActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSubmitBtnClickListener()
    }

    private fun initSubmitBtnClickListener() {
        binding.btnSignUpSubmit.setOnClickListener {
            if (binding.etSignUpName.text.isEmpty() || binding.etSignUpId.text.isEmpty() || binding.etSignUpPw.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.sign_up_toast_fail), Toast.LENGTH_SHORT)
                    .show()
            } else {
                signupNetwork()
//                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
//                intent
//                    .putExtra("id", binding.etSignUpId.text.toString())
//                    .putExtra("pw", binding.etSignUpPw.text.toString())
//                setResult(RESULT_OK, intent)
//                finish()
            }
        }
    }

    private fun signupNetwork() {
        val signUpRequest = SignUpRequest(
            email = binding.etSignUpId.text.toString(),
            name = binding.etSignUpName.text.toString(),
            password = binding.etSignUpPw.text.toString()
        )

        val call: Call<SignUpResponse> = RetrofitBuilder.loginService.postSignUp(signUpRequest)

        call.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>,
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignUpActivity,
                        "회원가입 완료",
                        Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    intent
                        .putExtra("id", binding.etSignUpId.text.toString())
                        .putExtra("pw", binding.etSignUpPw.text.toString())
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}

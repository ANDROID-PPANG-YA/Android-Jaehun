package sopt.android.assignment.ui.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sopt.android.assignment.R
import sopt.android.assignment.data.local.LoginSharedPreferences
import sopt.android.assignment.data.remote.RetrofitBuilder
import sopt.android.assignment.data.remote.entity.request.SignInRequest
import sopt.android.assignment.data.remote.entity.response.SignInResponse
import sopt.android.assignment.databinding.ActivitySignInBinding
import sopt.android.assignment.ui.base.BaseActivity
import sopt.android.assignment.ui.home.HomeActivity
import sopt.android.assignment.ui.signup.SignUpActivity
import sopt.android.assignment.util.showToast

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAutoLogin()
        initAutoLoginBtnClickListener()
        initActivityResultListener()
        initSignUpBtnClickListener()
        initLoginBtnClickListener()
    }

    private fun initAutoLogin() {
        LoginSharedPreferences.init(this)
        isAutoLogin()
    }

    private fun isAutoLogin() {
        if (LoginSharedPreferences.getAutoLogin()) {
            showToast("자동 로그인 되었습니다.")
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
        }
    }

    private fun initAutoLoginBtnIsChecked() {
        binding.btnSignInAutoLogin.isChecked = LoginSharedPreferences.getAutoLogin()
    }

    private fun initAutoLoginBtnClickListener() {
        binding.btnSignInAutoLogin.setOnCheckedChangeListener { _, isChecked ->
            LoginSharedPreferences.setAutoLogin(isChecked)
        }
    }

    private fun initActivityResultListener() {
        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val id = it.data?.getStringExtra("id")
                    val pw = it.data?.getStringExtra("pw")
                    binding.etSignInId.setText(id)
                    binding.etSignInPw.setText(pw)
                }
            }
    }

    private fun initSignUpBtnClickListener() {
        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }

    private fun initLoginBtnClickListener() {
        binding.btnSignInLogin.setOnClickListener {
            if (binding.etSignInId.text.isEmpty() || binding.etSignInPw.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.sign_in_toast_fail), Toast.LENGTH_SHORT)
                    .show()
            } else {
                signinNetwork()
            }
        }
    }

    private fun signinNetwork() {
        val signinRequest = SignInRequest(
            email = binding.etSignInId.text.toString(),
            password = binding.etSignInPw.text.toString()
        )

        val call: Call<SignInResponse> = RetrofitBuilder.loginService.postSignIn(signinRequest)

        call.enqueue(object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>,
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignInActivity,
                        "${data?.email}님 반갑습니다!",
                        Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else {
                    Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        initAutoLoginBtnIsChecked()
    }
}

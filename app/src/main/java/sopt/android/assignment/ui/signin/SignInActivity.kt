package sopt.android.assignment.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import sopt.android.assignment.R
import sopt.android.assignment.databinding.ActivitySignInBinding
import sopt.android.assignment.ui.base.BaseActivity
import sopt.android.assignment.ui.home.HomeActivity
import sopt.android.assignment.ui.signup.SignUpActivity

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSignUpBtnClickListener()
        initLoginBtnClickListener()
    }

    private fun initSignUpBtnClickListener() {
        binding.btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initLoginBtnClickListener() {
        binding.btnSignInLogin.setOnClickListener {
            if (binding.etSignInId.text.isEmpty() || binding.etSignInPw.text.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

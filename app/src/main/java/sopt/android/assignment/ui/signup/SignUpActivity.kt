package sopt.android.assignment.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import sopt.android.assignment.R
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
                Toast.makeText(this, getString(R.string.sign_up_toast_fail), Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                intent
                    .putExtra("id", binding.etSignUpId.text.toString())
                    .putExtra("pw", binding.etSignUpPw.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}

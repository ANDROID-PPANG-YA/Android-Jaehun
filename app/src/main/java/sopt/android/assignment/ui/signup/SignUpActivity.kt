package sopt.android.assignment.ui.signup

import android.os.Bundle
import android.widget.Toast
import sopt.android.assignment.R
import sopt.android.assignment.databinding.ActivitySignUpBinding
import sopt.android.assignment.ui.base.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSubmitBtnClickListener()
    }

    private fun initSubmitBtnClickListener() {
        binding.btnSignUpSubmit.setOnClickListener {
            if (binding.etSignUpName.text.isEmpty() || binding.etSignUpId.text.isEmpty() || binding.etSignUpPw.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }
    }
}

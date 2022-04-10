package sopt.android.assignment.ui.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import sopt.android.assignment.R
import sopt.android.assignment.databinding.ActivitySignInBinding
import sopt.android.assignment.ui.base.BaseActivity
import sopt.android.assignment.ui.home.HomeActivity
import sopt.android.assignment.ui.signup.SignUpActivity

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityResultListener()
        initSignUpBtnClickListener()
        initLoginBtnClickListener()
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
                Toast.makeText(this, getString(R.string.sign_in_toast_fail), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.sign_up_toast_success), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

package sopt.android.assignment.ui.home

import android.os.Bundle
import sopt.android.assignment.R
import sopt.android.assignment.databinding.ActivityHomeBinding
import sopt.android.assignment.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private var state = FOLLOWER_LIST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTransactionEvent()
        initFollowerListBtnClickListener()
        initRepositoryListBtnClickListener()
    }

    private fun initTransactionEvent() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container_home_list, HomeFollowerFragment()).commit()
    }

    private fun initFollowerListBtnClickListener() {
        binding.btnHomeFollowerList.setOnClickListener {
            if (state != FOLLOWER_LIST) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_home_list, HomeFollowerFragment()).commit()
                state = FOLLOWER_LIST
            }
        }
    }

    private fun initRepositoryListBtnClickListener() {
        binding.btnHomeRepositoryList.setOnClickListener {
            if (state != REPOSITORY_LIST) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_home_list, HomeRepositoryFragment()).commit()
                state = REPOSITORY_LIST
            }
        }
    }

    companion object {
        const val FOLLOWER_LIST = 0
        const val REPOSITORY_LIST = 1
    }
}
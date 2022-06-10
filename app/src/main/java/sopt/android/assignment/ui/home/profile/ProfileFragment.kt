package sopt.android.assignment.ui.home.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import sopt.android.assignment.R
import sopt.android.assignment.data.local.LoginSharedPreferences
import sopt.android.assignment.databinding.FragmentProfileBinding
import sopt.android.assignment.ui.base.BaseFragment
import sopt.android.assignment.ui.home.viewmodel.HomeViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private var state = FOLLOWER_LIST
    private val homeViewModel by activityViewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTransactionEvent()
        initLogoutBtnClickListener()
        initFollowerListBtnClickListener()
        initRepositoryListBtnClickListener()
        initProfileImg()
    }

    private fun initProfileImg() {
        Glide.with(this)
            .load("https://www.riotgames.com/darkroom/2880/656220f9ab667529111a78aae0e6ab9f:d1a7c6d0384f2edf9672d9369a8e9083/01-logo.png")
            .circleCrop()
            .into(binding.ivProfileImg)
    }

    private fun initTransactionEvent() {
        binding.btnProfileFollowerList.isSelected = true
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container_home_list, ProfileFollowerFragment()).commit()
    }

    private fun initLogoutBtnClickListener() {
        binding.btnProfileLogout.setOnClickListener {
            LoginSharedPreferences.setLogOut(requireContext())
            requireActivity().finish()
        }
    }

    private fun initFollowerListBtnClickListener() {
        binding.btnProfileFollowerList.setOnClickListener {
            binding.btnProfileFollowerList.isSelected = true
            binding.btnProfileRepositoryList.isSelected = false
            if (state != FOLLOWER_LIST) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container_home_list, ProfileFollowerFragment()).commit()
                state = FOLLOWER_LIST
            }
        }
    }

    private fun initRepositoryListBtnClickListener() {
        binding.btnProfileRepositoryList.setOnClickListener {
            binding.btnProfileRepositoryList.isSelected = true
            binding.btnProfileFollowerList.isSelected = false
            if (state != REPOSITORY_LIST) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container_home_list, ProfileRepositoryFragment()).commit()
                state = REPOSITORY_LIST
            }
        }
    }

    companion object {
        const val FOLLOWER_LIST = 0
        const val REPOSITORY_LIST = 1
    }

}

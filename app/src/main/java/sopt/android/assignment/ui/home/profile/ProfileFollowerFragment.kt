package sopt.android.assignment.ui.home.profile

import android.os.Bundle
import android.view.View
import sopt.android.assignment.R
import sopt.android.assignment.databinding.FragmentProfileFollowerBinding
import sopt.android.assignment.ui.base.BaseFragment
import sopt.android.assignment.ui.home.profile.adapter.ProfileFollowerRVAdapter

class ProfileFollowerFragment :
    BaseFragment<FragmentProfileFollowerBinding>(R.layout.fragment_profile_follower) {
    private lateinit var profileFollowerRVAdapter: ProfileFollowerRVAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        profileFollowerRVAdapter = ProfileFollowerRVAdapter()
        binding.rvHomeFollowerList.adapter = profileFollowerRVAdapter

        profileFollowerRVAdapter.followerList.addAll(
            listOf(
                Follower("", "이강민", "안드로이드 파트장"),
                Follower("", "김태현", "iOS 파트장"),
                Follower("", "김두범", "기획 파트장"),
                Follower("", "권혁진", "웹 파트장"),
                Follower("", "조재훈1", "안드 파트원"),
                Follower("", "조재훈2", "안드 파트원"),
                Follower("", "조재훈3", "안드 파트원")
            )
        )
    }
}
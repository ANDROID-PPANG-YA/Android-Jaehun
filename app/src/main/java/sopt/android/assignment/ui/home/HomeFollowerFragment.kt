package sopt.android.assignment.ui.home

import android.os.Bundle
import android.view.View
import sopt.android.assignment.R
import sopt.android.assignment.databinding.FragmentHomeFollowerBinding
import sopt.android.assignment.ui.base.BaseFragment

class HomeFollowerFragment :
    BaseFragment<FragmentHomeFollowerBinding>(R.layout.fragment_home_follower) {
    private lateinit var homeFollowerRVAdapter: HomeFollowerRVAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        homeFollowerRVAdapter = HomeFollowerRVAdapter()
        binding.rvHomeFollowerList.adapter = homeFollowerRVAdapter

        homeFollowerRVAdapter.followerList.addAll(
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
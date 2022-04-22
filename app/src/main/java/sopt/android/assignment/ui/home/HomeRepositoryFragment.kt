package sopt.android.assignment.ui.home

import android.os.Bundle
import android.view.View
import sopt.android.assignment.R
import sopt.android.assignment.databinding.FragmentHomeRepositoryBinding
import sopt.android.assignment.ui.base.BaseFragment

class HomeRepositoryFragment :
    BaseFragment<FragmentHomeRepositoryBinding>(R.layout.fragment_home_repository) {
    private lateinit var homeRepositoryRVAdapter: HomeRepositoryRVAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
        homeRepositoryRVAdapter = HomeRepositoryRVAdapter()
        binding.rvHomeRepositoryList.adapter = homeRepositoryRVAdapter

        homeRepositoryRVAdapter.repositoryList.addAll(
            listOf(
                Repository("안드로이드 과제 레포지토리", "안드로이드 과제"),
                Repository("iOS 과제 레포지토리", "iOS 과제"),
                Repository("서버 과제 레포지토리", "서버 과제"),
                Repository("기획 과제 레포지토리", "기획 과제"),
                Repository("웹 과제 레포지토리", "웹 과제")
            )
        )
    }
}
package sopt.android.assignment.ui.home.home

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import sopt.android.assignment.R
import sopt.android.assignment.databinding.FragmentHomeBinding
import sopt.android.assignment.ui.base.BaseFragment
import sopt.android.assignment.ui.home.home.adapter.HomeFragmentTabViewPagerAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var homeFragmentTabViewPagerAdapter: HomeFragmentTabViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initTablayout()
    }

    private fun initAdapter() {
        val fragmentList = listOf(HomeFollowingFragment(), HomeFollowerFragment())
        homeFragmentTabViewPagerAdapter = HomeFragmentTabViewPagerAdapter(this)
        homeFragmentTabViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vpHomeFragment.adapter = homeFragmentTabViewPagerAdapter
    }

    private fun initTablayout() {
        val tabLabel = listOf("팔로잉", "팔로워")
        TabLayoutMediator(binding.tlHomeFragment, binding.vpHomeFragment) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }
}
package sopt.android.assignment.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.android.assignment.databinding.ItemFollowerListBinding

class HomeFollowerRVAdapter() :
    RecyclerView.Adapter<HomeFollowerRVAdapter.HomeFollowerViewHolder>() {
    val followerList = mutableListOf<Follower>()

    class HomeFollowerViewHolder(private val binding: ItemFollowerListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Follower) {
            binding.follower = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFollowerViewHolder {
        val binding =
            ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeFollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount() = followerList.size
}
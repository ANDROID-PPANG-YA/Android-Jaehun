package sopt.android.assignment.ui.home.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.android.assignment.databinding.ItemRepositoryListBinding
import sopt.android.assignment.ui.home.profile.Repository

class ProfileRepositoryRVAdapter() :
    RecyclerView.Adapter<ProfileRepositoryRVAdapter.HomeRepositoryViewHolder>() {
    val repositoryList = mutableListOf<Repository>()

    class HomeRepositoryViewHolder(private val binding: ItemRepositoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Repository) {
            binding.repository = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRepositoryViewHolder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeRepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    override fun getItemCount() = repositoryList.size
}
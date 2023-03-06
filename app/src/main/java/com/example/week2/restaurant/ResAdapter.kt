package com.example.week2.restaurant

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.week2.singleonData.DataStore
import com.example.week2.singleonData.Restaurant

class ResAdapter: ListAdapter<Restaurant, ResViewHolder>(RestaurantDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResViewHolder {
        return ResViewHolder.from(parent) { setList(it) }
    }

    override fun onBindViewHolder(holder: ResViewHolder, position: Int) {
        val idol = getItem(position)
        holder.bindData(idol)

    }

    class RestaurantDiffUtil: DiffUtil.ItemCallback<Restaurant>()   {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.resName == newItem.resName &&
                    oldItem.address == newItem.address &&
                    oldItem.avatar == newItem.avatar
        }

    }
    class RestaurantDiffUtilCallback(private val oldList: MutableList<Restaurant>, private val newList: MutableList<Restaurant>): DiffUtil.Callback()
    {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].avatar == newList[newItemPosition].avatar &&
                    oldList[oldItemPosition].resName == newList[newItemPosition].resName &&
                    oldList[oldItemPosition].address == newList[newItemPosition].address
        }

    }
    private fun setList(newList: MutableList<Restaurant>) {
        DataStore.restaurantData.value?.let { RestaurantDiffUtilCallback(it, newList) }
            ?.let { DiffUtil.calculateDiff(it).dispatchUpdatesTo(this) }
        DataStore.restaurantData.value?.clear()
        DataStore.restaurantData.value?.addAll(newList)
    }
}
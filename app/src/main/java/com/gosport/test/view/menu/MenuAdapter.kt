package com.gosport.test.view.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.gosport.test.databinding.MainFragmentFoodRecyclerItemBinding
import com.gosport.test.model.data.Meal

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.RecyclerItemViewHolder>() {

    private var mainDataList: List<Meal> = arrayListOf()
    private var childDataList: List<Meal> = arrayListOf()

    fun setData(data: List<Meal>) {
        this.mainDataList = data
    }

    fun changeCategory(category: String) {
        this.childDataList = mainDataList.filter { it.strCategory == category }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val binding = MainFragmentFoodRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecyclerItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(childDataList[position])
    }

    override fun getItemCount(): Int {
        return childDataList.size
    }

    inner class RecyclerItemViewHolder(private val binding: MainFragmentFoodRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Meal) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                binding.foodImage.load(data.strMealThumb)
                binding.mealNameTextView.text = data.strMeal
                binding.instructionsTextView.text = data.strInstructions
            }
        }
    }
}
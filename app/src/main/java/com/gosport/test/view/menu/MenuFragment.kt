package com.gosport.test.view.menu

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.chip.Chip
import com.gosport.test.App
import com.gosport.test.R
import com.gosport.test.checkForInternet
import com.gosport.test.databinding.FragmentMenuBinding
import com.gosport.test.model.data.AppState
import com.gosport.test.model.data.Category
import com.gosport.test.model.data.Meal
import com.gosport.test.viewmodel.MainViewModel
import javax.inject.Inject

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private lateinit var binding: FragmentMenuBinding

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    private val adapter: MenuAdapter by lazy { MenuAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        App.instance.component.inject(this)
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        binding.categoriesChipGroup.isSingleSelection = true
        initViewModel(checkForInternet(requireActivity()))
        initAdapter()
    }

    private fun initAdapter() {

        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.recycler_divider
            )!!
        )
        binding.foodListRecyclerView.addItemDecoration(dividerItemDecoration)

        binding.foodListRecyclerView.adapter = adapter
    }

    private fun initViewModel(isNetworkConnection: Boolean) {
        viewModel = viewModelFactory.create(MainViewModel::class.java)
        lifecycleScope.launchWhenStarted {
            viewModel.dataCategories.collect {
                renderData(it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.dataMeal.collect {
                renderData(it)
            }
        }
        viewModel.getCategoriesData(isNetworkConnection)
        viewModel.getMealData(isNetworkConnection)
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessCategories -> {
                appState.data?.let {
                    if (it.categories.isEmpty()) {
                        Toast.makeText(
                            context,
                            getString(R.string.no_data_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else
                        showCategoriesData(appState.data.categories)
                }
            }

            is AppState.SuccessMeal -> {
                appState.data?.let { it ->
                    if (it.meals.isEmpty()) {
                        Toast.makeText(
                            context,
                            getString(R.string.no_data_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else
                        showMealData(appState.data.meals)
                }
            }

            is AppState.Loading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }

            is AppState.Error -> {
                Toast.makeText(context, appState.error.message, Toast.LENGTH_SHORT).show()
                Log.d("LOG_TAG", appState.error.message.toString())
            }

            else -> Unit
        }
    }

    private fun showMealData(meals: List<Meal>) {
        adapter.setData(meals)
        adapter.changeCategory(DEFAULT_CATEGORY)
    }


    private fun showCategoriesData(list: List<Category>) {
        list.forEach {
            val chip = layoutInflater.inflate(
                R.layout.single_chip_layout,
                binding.categoriesChipGroup,
                false
            ) as Chip
            chip.apply {
                text = it.strCategory
                isCheckable = true

            }
            chip.setOnClickListener {
                val category = chip.text.toString()
                adapter.changeCategory(category)
            }
            binding.categoriesChipGroup.addView(chip)
        }

        binding.categoriesChipGroup.check(binding.categoriesChipGroup.getChildAt(DEFAULT_CHIP_ID).id)
    }

    companion object {
        private const val DEFAULT_CATEGORY = "Beef"
        private const val DEFAULT_CHIP_ID = 0
    }

}
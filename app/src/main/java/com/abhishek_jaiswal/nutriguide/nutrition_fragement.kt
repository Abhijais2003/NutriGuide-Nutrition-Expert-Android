// NutritionFragment.kt
package com.abhishek_jaiswal.nutriguide

import EdamamResponse
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abhishek_jaiswal.nutriguide.databinding.FragmentNutritionBinding

class NutritionFragment : Fragment() {

    private var _binding: FragmentNutritionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    fun displayNutrition(nutrition: EdamamResponse) {
        binding.caloriesTextView.text = "Calories: ${nutrition.calories}"
        binding.totalFatTextView.text = "Total Fat: ${nutrition.totalFat}"
        binding.totalFatTextView.text = "Saturated Fat: ${nutrition.saturatedFat}"
        binding.proteinTextView.text = "Protein: ${nutrition.protein}"
        binding.carbsTextView.text = "Carbohydrates: ${nutrition.carbs}"
        binding.fiberTextView.text = "Fiber: ${nutrition.fiber}"
        binding.sugarTextView.text = "Sugar: ${nutrition.sugar}"
    }
}

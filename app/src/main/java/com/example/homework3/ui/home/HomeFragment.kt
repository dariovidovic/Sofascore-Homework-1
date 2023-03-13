@file:Suppress("DEPRECATION")

package com.example.homework3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homework3.Cocktail
import com.example.homework3.Glass
import com.example.homework3.PageViewModel
import com.example.homework3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val adapter = ArrayAdapter<Glass>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            Glass.values()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.glassSpinner.adapter = adapter

        binding.run {
            submitButton.setOnClickListener {

                if (enterName.text.isEmpty()) {
                    Toast.makeText(context, "Please enter the cocktail name!", Toast.LENGTH_SHORT)
                        .show()
                    submitButton.isClickable = false
                }

                if (enterIngredients.text.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Please enter the cocktail's ingredients!",
                        Toast.LENGTH_SHORT
                    ).show()
                    submitButton.isClickable = false
                }

                if (enterGarnish.text.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Please enter the cocktail's garnish'!",
                        Toast.LENGTH_SHORT
                    ).show()
                    submitButton.isClickable = false
                }

                if (enterDescription.text.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Please enter the instructions for the cocktail!",
                        Toast.LENGTH_SHORT
                    ).show()
                    submitButton.isClickable = false
                }

                if (typeGroup.checkedRadioButtonId == -1) {
                    Toast.makeText(context, "Please pick the cocktail type!", Toast.LENGTH_SHORT)
                        .show()
                    submitButton.isClickable = false
                }
                val selectedRadioButtonId = typeGroup.checkedRadioButtonId
                val checkedType = view?.findViewById<RadioButton>(selectedRadioButtonId)

                val cocktail = Cocktail(
                    enterName.text.toString(),
                    enterIngredients.text.toString(),
                    enterGarnish.text.toString(),
                    enterDescription.text.toString(),
                    checkedType?.text.toString(),
                    glassSpinner.selectedItem.toString()
                )
                viewModel.addCocktail(cocktail)
                this.constraintLayout.children.forEach {
                    (it as? EditText)?.text?.clear()
                }
                typeGroup.clearCheck()

            }
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

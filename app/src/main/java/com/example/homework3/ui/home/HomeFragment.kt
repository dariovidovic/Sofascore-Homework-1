@file:Suppress("DEPRECATION")

package com.example.homework3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homework3.Cocktail
import com.example.homework3.Glass
import com.example.homework3.PageViewModel
import com.example.homework3.R
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
        var test : Glass


        binding.run {
            submitButton.setOnClickListener {

                if (enterName.text!!.isEmpty()) {
                    enterName.error = getString(R.string.name_error_message)
                    submitButton.isClickable = false
                }

                if (enterIngredients.text!!.isEmpty()) {
                    enterIngredients.error = getString(R.string.ingredients_error_message)
                    submitButton.isClickable = false
                }

                if (enterGarnish.text!!.isEmpty()) {
                    enterGarnish.error = getString(R.string.garnish_error_message)
                    submitButton.isClickable = false
                }

                if (enterInstructions.text!!.isEmpty()) {
                    enterInstructions.error = getString(R.string.instructions_error_message)
                    submitButton.isClickable = false
                }

                if (typeGroup.checkedRadioButtonId == -1) {
                    Toast.makeText(context, getString(R.string.type_error_message) , Toast.LENGTH_SHORT)
                        .show()
                    submitButton.isClickable = false
                }

                val selectedRadioButtonId = typeGroup.checkedRadioButtonId
                val checkedType = view?.findViewById<RadioButton>(selectedRadioButtonId)

                val cocktail = Cocktail(
                    enterName.text.toString(),
                    enterIngredients.text.toString(),
                    enterGarnish.text.toString(),
                    enterInstructions.text.toString(),
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

@file:Suppress("DEPRECATION")

package com.example.homework3.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
    var flag = false

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
        var test: Glass
        binding.submitButton.isEnabled = false
        val selectedRadioButtonId = binding.typeGroup.checkedRadioButtonId
        val checkedType = view?.findViewById<RadioButton>(selectedRadioButtonId)


        binding.run {
            typeGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
                group, checkedId -> if(checkedId!=-1) flag = true;
            })
            enterName.addTextChangedListener(textWatcher)
            enterIngredients.addTextChangedListener(textWatcher)
            enterGarnish.addTextChangedListener(textWatcher)
            enterInstructions.addTextChangedListener(textWatcher)



            submitButton.setOnClickListener {
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

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.run {
                submitButton.isEnabled =
                    (!enterName.text.toString().isEmpty() && !enterIngredients.text.toString()
                        .isEmpty() && !enterGarnish.text.toString()
                        .isEmpty() && !enterInstructions.text.toString().isEmpty() && flag)

            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

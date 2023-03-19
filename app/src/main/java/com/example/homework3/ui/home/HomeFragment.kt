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
import com.example.homework3.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PageViewModel by activityViewModels()
    var inputFlag = false
    var radioFlag = false

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
        binding.submitButton.isEnabled = false

        binding.run {
            typeGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { _, checkedId ->
                radioFlag = (checkedId != -1)
                enableButton()
            })
            enterName.addTextChangedListener(textWatcher)
            enterIngredients.addTextChangedListener(textWatcher)
            enterGarnish.addTextChangedListener(textWatcher)
            enterInstructions.addTextChangedListener(textWatcher)



            submitButton.setOnClickListener {
                val selectedRadioButtonId = typeGroup.checkedRadioButtonId
                val checkedType = view?.findViewById<RadioButton>(selectedRadioButtonId)
                val cocktail = Cocktail(
                    enterName.text.toString(),
                    enterIngredients.text.toString(),
                    enterGarnish.text.toString(),
                    enterInstructions.text.toString(),
                    checkedType?.text.toString(),
                    Glass.valueOf(glassSpinner.selectedItem.toString())
                )
                viewModel.addCocktail(cocktail)
                this.constraintLayout.children.forEach {
                    (it as? EditText)?.text?.clear()
                }
                typeGroup.clearCheck()

                /*this.constraintLayout.children.forEach {
                    (it as? TextInputEditText)?.text?.clear()
                }*/
                //Nisam siguran zasto ne radi s forEach clear() :(

                binding.enterName.text?.clear()
                binding.enterIngredients.text?.clear()
                binding.enterGarnish.text?.clear()
                binding.enterInstructions.text?.clear()
            }


        }


        return root
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.run {
                inputFlag =
                    (!enterName.text.toString().isEmpty() && !enterIngredients.text.toString()
                        .isEmpty() && !enterGarnish.text.toString()
                        .isEmpty() && !enterInstructions.text.toString().isEmpty())
                enableButton()
            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }

    private fun enableButton() {
        binding.submitButton.isEnabled = radioFlag && inputFlag
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

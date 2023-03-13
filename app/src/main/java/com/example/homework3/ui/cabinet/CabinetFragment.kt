package com.example.homework3.ui.cabinet

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homework3.Cocktail
import com.example.homework3.PageViewModel
import com.example.homework3.databinding.FragmentCabinetBinding


class CabinetFragment : Fragment() {

    private var _binding: FragmentCabinetBinding? = null

    private val binding get() = _binding!!

    private val viewModel: PageViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCabinetBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel.getLiveData().observe(viewLifecycleOwner) {
            buildList(it)
        }
        return root
    }

    companion object {
        fun newInstance() = CabinetFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun buildList(cocktails: List<Cocktail>) {
        binding.linearLayout.removeAllViews()
        for (cocktail in cocktails) {
            val cocktailTextView = TextView(requireContext())
            cocktailTextView.text = cocktail.toString()
            cocktailTextView.setTextColor(Color.BLACK)

            binding.linearLayout.addView(cocktailTextView)
        }
    }
}
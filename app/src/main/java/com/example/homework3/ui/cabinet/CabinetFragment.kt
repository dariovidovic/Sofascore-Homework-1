package com.example.homework3.ui.cabinet

import com.example.homework3.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homework3.Cocktail
import com.example.homework3.Glass
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

        var tempArray : MutableList<String> = arrayListOf()

        viewModel.getLiveData().observe(viewLifecycleOwner) {
            for(cocktail in it){
                tempArray.add(cocktail.toString())
            }
        }
        val adapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.activity_list_view,
            R.id.cocktails_info,
            tempArray
        )
        binding.listView.adapter = adapter

        return root
    }

    companion object {
        fun newInstance() = CabinetFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
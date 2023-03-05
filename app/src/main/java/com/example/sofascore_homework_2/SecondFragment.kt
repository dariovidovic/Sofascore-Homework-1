package com.example.sofascore_homework_2

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.sofascore_homework_2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PageViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root


        viewModel.getLiveData().observe(viewLifecycleOwner){
            binding.listOfPeople.text = it.toString()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}